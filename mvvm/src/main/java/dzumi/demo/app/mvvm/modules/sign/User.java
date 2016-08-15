package dzumi.demo.app.mvvm.modules.sign;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Dzumi on 7/24/2016.
 */
public class User {
    @SerializedName("userID")
    @Expose (serialize = false)
    long userID;
    @SerializedName("pass")
    @Expose (deserialize = false)
    String password;
    @SerializedName("fullName")
    @Expose (serialize = false)
    String fullName;
    @SerializedName("token")
    @Expose (serialize = false)
    String token;
    @SerializedName("email")
    @Expose
    String email;

    @SerializedName("user_name")
    @Expose
    String userName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public long getUserID() {
        return userID;
    }

    public void setUserID(long userID) {
        this.userID = userID;
    }
}
