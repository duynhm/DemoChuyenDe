package dzumi.demo.app.demodatabinding.signin.model;

import android.databinding.ObservableField;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Dzumi on 7/1/2016.
 */
public class User {
    public final static String USER_ID = "userID";
    public final static String NAME = "name";
    public final static String LOGIN_NAME = "loginName";
    public final static String ACCESS_TOKEN = "accessToken";

    public ObservableField<String> errorPass;

    public User() {
        errorPass = new ObservableField<>(null);
    }

    @Expose
    @SerializedName("UserId") int userID;
    @Expose
    @SerializedName("LoginName")
    String loginName;
    @Expose
    @SerializedName("Name")
    String name; //full name
    @Expose
    @SerializedName("AccessToken")
    String accessToken;

    @Expose @SerializedName("age") int age;
    @Expose @SerializedName("address") String address;
    @Expose @SerializedName("userName") String userName;

    String password;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }
}
