package dzumi.demo.app.mvvm.modules.sign;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import dzumi.demo.app.mvvm.base.BaseResponse;


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
