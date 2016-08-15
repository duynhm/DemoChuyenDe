package dzumi.demo.app.mvp;

import android.content.Context;

/**
 * Created by Dzumi on 8/15/2016.
 */
public class LoginPresenter implements ILoginPresenter {
    Context mContext;
    CallbackLoginActivity callbackLoginActivity;
    public LoginPresenter(Context context, CallbackLoginActivity callbackLoginActivity) {
        mContext = context;
        this.callbackLoginActivity = callbackLoginActivity;
    }

    @Override
    public void login(final User user) {
        if(validate(user))
        new android.os.Handler().postDelayed(
                new Runnable() {
                    public void run() {
                        // On complete call either onLoginSuccess or onLoginFailed
                        if(user.email.equals("t3h@t3h.vn") && user.password.equals("123456"))
                        {
                            callbackLoginActivity.onLoginSuccess();
                        }
                        // onLoginFailed();
                        else
                            callbackLoginActivity.onLoginFailed();
                    }
                }, 3000);
    }

    @Override
    public boolean validate(User user) {
        boolean valid = true;


        if (user.email.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(user.email).matches()) {
            callbackLoginActivity.setErrorUsername("enter a valid email address");
            valid = false;
        } else {
            callbackLoginActivity.setErrorUsername(null);
        }

        if (user.password.isEmpty() || user.password.length() < 4 || user.password.length() > 10) {
            callbackLoginActivity.setErrorPassword("between 4 and 10 alphanumeric characters");
            valid = false;
        } else {
            callbackLoginActivity.setErrorPassword(null);
        }

        return valid;
    }


}
