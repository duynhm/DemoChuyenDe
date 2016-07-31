package dzumi.demo.app.demoretrofit.network;

import java.io.IOException;

import dzumi.demo.app.demoretrofit.base.Constants;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceBuilder {

    private static OkHttpClient.Builder httpClient =
            new OkHttpClient.Builder();

    private static Retrofit.Builder builder =
            new Retrofit.Builder()
                    .baseUrl(Constants.API_BASE_URL)
                    .addConverterFactory(
                            GsonConverterFactory.create());

    public static <S> S createService(Class<S> serviceClass) {
        Retrofit retrofit = builder.client(httpClient.build())
                .build();
        return retrofit.create(serviceClass);
    }

    public static <S> S createServiceWithLog(Class<S> serviceClass) {
        HttpLoggingInterceptor logging =
                new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        Retrofit retrofit = builder.client(
                httpClient.addInterceptor(logging).build()).build();

        return retrofit.create(serviceClass);
    }

    public static <S> S createService(Class<S> serviceClass, final String authToken) {
        if (authToken != null) {
            httpClient.addInterceptor(new Interceptor() {
                @Override
                public Response intercept(Interceptor.Chain chain) throws IOException {
                    Request original = chain.request();

                    // Request customization: add request headers
                    Request.Builder requestBuilder = original.newBuilder()
                            .header("token", authToken)
                            .method(original.method(), original.body());

                    Request request = requestBuilder.build();
                    return chain.proceed(request);
                }
            });
        }

        OkHttpClient client = httpClient.build();
        Retrofit retrofit = builder.client(client).build();
        return retrofit.create(serviceClass);
    }

    public static <S> S createServiceWithTokenParam(Class<S> serviceClass, final String authToken) {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        if (authToken != null) {
            httpClient.addInterceptor(logging).addInterceptor(new Interceptor() {
                @Override
                public Response intercept(Interceptor.Chain chain) throws IOException {
                    Request original = chain.request();
                    HttpUrl originalHttpUrl = original.url();

                    HttpUrl url = originalHttpUrl.newBuilder()
                            .addQueryParameter("token", authToken)
                            .build();

                    // Request customization: add request headers
                    Request.Builder requestBuilder = original.newBuilder()
                            .url(url);

                    Request request = requestBuilder.build();
                    return chain.proceed(request);
                }
            });
        }

        OkHttpClient client = httpClient.build();
        Retrofit retrofit = builder.client(client).build();
        return retrofit.create(serviceClass);
    }

}