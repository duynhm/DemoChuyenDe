package dzumi.demo.app.mvvm.network;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Response;

/**
 * Created by Dzumi on 5/10/2016.
 */
public class NetworkInterceptor implements Interceptor {
    Context context;

    public NetworkInterceptor(Context context) {
        this.context = context;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {

        Log.e("TAI", "NetworkInterceptor - intercept");
        // Do anything with response here
        ConnectivityManager cm =
                (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        boolean isConnected = activeNetwork != null &&
                activeNetwork.isConnectedOrConnecting();
        if (!isConnected)
            throw new IOException("NO_INTERNET");
        else {
            /*Request newRequest = chain.request().newBuilder()
                    .header("Token", CustomSharedPref.getAccessToken(context))
                    .build();
              Response response = chain.proceed(chain.request());*/

            Response response = chain.proceed(chain.request());

            return response;
        }
    }


}
