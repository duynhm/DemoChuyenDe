package dzumi.demo.app.mvp;

/**
 * Created by Dzumi on 8/15/2016.
 */
public interface CallbackLoginActivity {
    void setErrorUsername(String error);
    void setErrorPassword(String error);
    void onLoginSuccess();
    void onLoginFailed();
}
