package dzumi.demo.app.demoretrofit.model.base;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Dzumi on 7/30/2016.
 */
public class BaseRequest {
    @SerializedName("token")
    @Expose
    String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
