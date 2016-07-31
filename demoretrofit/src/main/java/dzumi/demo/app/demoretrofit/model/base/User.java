package dzumi.demo.app.demoretrofit.model.base;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class User {

    @SerializedName("userID")
    @Expose
    private Long userID;
    @SerializedName("userName")
    @Expose
    private String username;

    @SerializedName("password")
    @Expose(deserialize = false)
    private String pass;

    @SerializedName("token")
    @Expose
    private String token;
    @SerializedName("fullName")
    @Expose
    private String fullName;
    @SerializedName("email")
    @Expose
    private String email;

    /**
     * @return The userID
     */
    public Long getUserID() {
        return userID;
    }

    /**
     * @param userID The userID
     */
    public void setUserID(Long userID) {
        this.userID = userID;
    }

    /**
     * @return The token
     */
    public String getToken() {
        return token;
    }

    /**
     * @param token The token
     */
    public void setToken(String token) {
        this.token = token;
    }

    /**
     * @return The fullName
     */
    public String getFullName() {
        return fullName;
    }

    /**
     * @param fullName The fullName
     */
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    /**
     * @return The email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email The email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    @Override
    public String toString() {
        return "UserID: " + userID + "\nFull name: " + fullName + "\nEmail: " + email + "\nToken: " + token ;
    }
}