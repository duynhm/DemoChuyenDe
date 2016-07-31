package dzumi.demo.app.demoretrofit.network;

import java.util.List;

import dzumi.demo.app.demoretrofit.model.LoginResponse;
import dzumi.demo.app.demoretrofit.model.GetNotificationResponse;
import dzumi.demo.app.demoretrofit.model.base.Notification;
import dzumi.demo.app.demoretrofit.model.base.User;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by Dzumi on 7/30/2016.
 */
public interface DemoRetrofitService {

    @GET("user/login")
    Call<User> loginError1(
            @Query("userName") String userName,
            @Query("password") String password
    );

    @GET("user/login")
    Call<LoginResponse> login(
            @Query("userName") String userName,
            @Query("password") String password
    );

    @POST("user/login")
    Call<LoginResponse> login(@Body User user);

    @GET("notification/getByID")
    Call<GetNotificationResponse> getNotificatioByID(@Query("id") long id);
}
