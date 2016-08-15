package dzumi.demo.app.mvvm.dagger;

import android.app.Application;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dzumi.demo.app.mvvm.network.APIService;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Dzumi on 5/12/2016.
 */
@Module
public class NetModule {
    String mBaseUrl;

    public NetModule(String baseUrl) {
        this.mBaseUrl = baseUrl;
    }

    @Provides
    @Singleton
    Gson provideGson(){
        return new GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation()
//                .setVersion((double) BuildConfig.VERSION_CODE)
                .create();
    }

    @Provides
    @Singleton
    OkHttpClient provideOkHttpClient(Application application){
        Log.e("TAI", "NetModule - provideOkHttpClient");

        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient httpClient = new OkHttpClient.Builder()
                .addInterceptor(logging)
//                .addInterceptor(new NetworkInterceptor(application))
                .addInterceptor(chain -> {

                    ConnectivityManager cm =
                            (ConnectivityManager) application.getSystemService(Context.CONNECTIVITY_SERVICE);

                    NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
                    boolean isConnected = activeNetwork != null &&
                            activeNetwork.isConnectedOrConnecting();
                    if (!isConnected)
                        throw new IOException("NO_INTERNET");
                    else {
                        //thêm header
                        Request original = chain.request();
                        // Request customization: add request headers
                        Request.Builder requestBuilder = original.newBuilder();
                               /* .header("Token", CustomSharedPref.getAccessToken(application)); // <-- this is the important line
                        Log.d("TaskManagementService", "TOKEN: " + CustomSharedPref.getAccessToken(application));*/
                        Request request = requestBuilder.build();
                        return chain.proceed(request);
                    }
                }).build();
        return httpClient;
    }

    @Provides
    @Singleton
    Retrofit provideRetrofit(Gson gson, OkHttpClient okHttpClient){
        Log.e("TAI", "NetModule - provideRetrofit");

        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .baseUrl(mBaseUrl)
                .client(okHttpClient)
                .build();
        return retrofit;
    }

    @Provides @Singleton
    APIService provideTaskManagementService(Retrofit retrofit){
        return retrofit.create(APIService.class);
    }
}
