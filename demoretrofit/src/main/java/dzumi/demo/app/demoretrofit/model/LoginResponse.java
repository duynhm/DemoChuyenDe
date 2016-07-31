package dzumi.demo.app.demoretrofit.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import dzumi.demo.app.demoretrofit.model.base.BaseResponse;
import dzumi.demo.app.demoretrofit.model.base.User;

/**
 * Created by Dzumi on 7/30/2016.
 */
public class LoginResponse extends BaseResponse {
    @SerializedName("data")
    @Expose
    User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
