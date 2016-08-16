package dzumi.demo.app.mvvm.network;

import dzumi.demo.app.mvvm.modules.sign.LoginResponse;
import dzumi.demo.app.mvvm.modules.sign.User;
import retrofit2.http.Body;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by Dzumi on 4/23/2016.
 */
public interface APIService {

/*    @POST("api/Account/login")
    Observable<LoginResponse> login(@Body LoginRequest loginRequest);*/
@POST("user/login")
Observable<LoginResponse> login(@Body User user);


}
