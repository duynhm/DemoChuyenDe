package dzumi.demo.app.demoretrofit;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.io.IOException;

import dzumi.demo.app.demoretrofit.base.Constants;
import dzumi.demo.app.demoretrofit.model.LoginResponse;
import dzumi.demo.app.demoretrofit.model.base.BaseResponse;
import dzumi.demo.app.demoretrofit.model.base.User;
import dzumi.demo.app.demoretrofit.network.DemoRetrofitService;
import dzumi.demo.app.demoretrofit.network.DemoRetrofitServiceRx;
import dzumi.demo.app.demoretrofit.network.NetworkRequest;
import dzumi.demo.app.demoretrofit.network.ServiceBuilder;
import dzumi.demo.app.demoretrofit.network.ServiceBuilderRx;
import dzumi.demo.app.demoretrofit.utils.SnackbarUtils;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import rx.Subscription;

public class DemoSample extends AppCompatActivity {

    private static final String TAG = "DemoSample";
    TextView tvContent;
    EditText edtUserName, edtPassword, edtToken;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo_sample);

        tvContent = (TextView) findViewById(R.id.tvContent);
        edtPassword = (EditText) findViewById(R.id.edtPassword);
        edtUserName = (EditText) findViewById(R.id.edtUserName);
        edtToken = (EditText) findViewById(R.id.edtToken);
    }



    public void doGet(View v){
        new AsyncTask<String, Void, LoginResponse>(){
            @Override
            protected LoginResponse doInBackground(String... param) {
                DemoRetrofitService client = ServiceBuilder.
                        createServiceWithLog(DemoRetrofitService.class);

                // Fetch and print a list of the contributors to this library.
                Call<LoginResponse> call =
                        client.login(param[0], param[1]);

                LoginResponse loginResponse = null;
                try {
                    loginResponse = call.execute().body();
                } catch (IOException e) {
                    // handle errors
                    Log.e(TAG, "doGet: error: ", e );
                }
                return loginResponse;
            }

            @Override
            protected void onPostExecute(LoginResponse loginResponse) {
                if(loginResponse != null){
                    if(loginResponse.getStatus() == 200){

                        tvContent.setText(loginResponse.getUser().toString());
                        edtToken.setText(loginResponse.getUser().getToken());
                        SnackbarUtils.show(tvContent, loginResponse.getMsg());
                    }else{
                        SnackbarUtils.showError(tvContent, loginResponse.getMsg());
                        tvContent.setText("");
                    }
                }else{
                    SnackbarUtils.showError(tvContent, "Lỗi");
                }


            }
        }.execute(edtUserName.getText().toString(), edtPassword.getText().toString());

    }

    public void doGetError2(View v){
        new AsyncTask<String, Void, User>(){
            @Override
            protected User doInBackground(String... param) {
                DemoRetrofitService client = ServiceBuilder.createService(DemoRetrofitService.class);

                // Fetch and print a list of the contributors to this library.
                Call<User> call =
                        client.loginError1(param[0], param[1]);

                User user = null;
                try {
                    user = call.execute().body();
                } catch (IOException e) {
                    // handle errors
                    Log.e(TAG, "doGet: error: ", e );
                    user = new User();
                }

                Log.d(TAG, "doGet: " + user.toString());

                return user;
            }

            @Override
            protected void onPostExecute(User user) {
                super.onPostExecute(user);
                if(user!= null)
                tvContent.setText(user.toString());
            }
        }.execute(edtUserName.getText().toString(),
                edtPassword.getText().toString());

    }

    public void doGetError(View v){
        DemoRetrofitService client = ServiceBuilder.
                createService(DemoRetrofitService.class);

        // Fetch and print a list of the contributors to this library.
        Call<User> call =
                client.loginError1(edtUserName.getText().toString(),
                        edtPassword.getText().toString());

        User user = null;
        try {
            user = call.execute().body();
        } catch (IOException e) {
            // handle errors
            Log.e(TAG, "doGet: error: ", e );
            user = new User();
        }

        Log.d(TAG, "doGet: " + user.toString());
    }


    public void doPost(View v){
      new AsyncTask<String, Void, LoginResponse>(){
            @Override
            protected LoginResponse doInBackground(String... param) {
                DemoRetrofitService client = ServiceBuilder.
                        createServiceWithLog(DemoRetrofitService.class);

                // Fetch and print a list of the contributors to this library.
                User user = new User();
                user.setUsername(param[0]);
                user.setPass(param[1]);
                Call<LoginResponse> call =
                        client.login(user);

                LoginResponse loginResponse = null;
                try {
                    loginResponse = call.execute().body();
                } catch (IOException e) {
                    // handle errors
                    Log.e(TAG, "doGet: error: ", e );
                }


                return loginResponse;
            }

            @Override
            protected void onPostExecute(LoginResponse loginResponse) {
                if(loginResponse != null){
                    if(loginResponse.getStatus() == 200){

                        tvContent.setText(loginResponse.getUser().toString());
                        edtToken.setText(loginResponse.getUser().getToken());
                        SnackbarUtils.show(tvContent, loginResponse.getMsg());
                    }else{
                        SnackbarUtils.showError(tvContent, loginResponse.getMsg());
                        tvContent.setText("");
                    }
                }else{
                    SnackbarUtils.showError(tvContent, "Lỗi");
                }

            }
        }.execute(edtUserName.getText().toString(), edtPassword.getText().toString());
    }

    public void doPostAsyn(View v){
        User user = new User();
        user.setUsername(edtUserName.getText().toString());
        user.setPass(edtPassword.getText().toString());
        DemoRetrofitService service = ServiceBuilder.
                createServiceWithLog(DemoRetrofitService.class);
        Call<LoginResponse> call = service.login(user);
        call.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                if(response.isSuccessful()){
                    if(response.body().getStatus() == BaseResponse.STATUS_OK)
                        SnackbarUtils.show(edtUserName, response.body().getMsg());
                    else{
                        SnackbarUtils.showError(edtUserName, response.body().getMsg());
                    }
                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                if(t != null){
                    SnackbarUtils.showError(edtUserName, t.getMessage());
                }else{
                    SnackbarUtils.showError(edtUserName, "Lỗi");
                }
            }
        });

    }

    public void doRx(View v){

        User user = new User();
        user.setUsername(edtUserName.getText().toString());
        user.setPass(edtPassword.getText().toString());

        DemoRetrofitServiceRx demoRetrofitServiceRx = ServiceBuilderRx.buildAPIService(this, Constants.API_BASE_URL);
        Subscription subscription = NetworkRequest.performAsyncRequest(
                this, demoRetrofitServiceRx.login(user),
                data ->{
                    if(data.getStatus() == BaseResponse.STATUS_OK){

                    }
                    return data;
                },
                next->{
                    if(next.getStatus() == BaseResponse.STATUS_OK){
                        SnackbarUtils.show(edtUserName, next.getMsg());
                    }else {
                        SnackbarUtils.showError(edtUserName, next.getMsg());
                    }
                });
    }

}
