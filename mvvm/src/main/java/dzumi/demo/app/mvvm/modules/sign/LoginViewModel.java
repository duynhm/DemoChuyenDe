package dzumi.demo.app.mvvm.modules.sign;

import android.content.Context;
import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;
import android.view.View;

import dzumi.demo.app.mvvm.base.BaseViewModel;
import dzumi.demo.app.mvvm.base.ViewModel;
import dzumi.demo.app.mvvm.network.APIService;
import dzumi.demo.app.mvvm.network.NetworkRequest;
import rx.Subscription;

/**
 * Created by Dzumi on 8/15/2016.
 */
public class LoginViewModel extends BaseViewModel implements ViewModel {
    public ObservableField<String> email;
    public ObservableField<String> password;
    public ObservableField<String> errorEmail;
    public ObservableField<String> errorPass;


    Subscription subscription;
    APIService apiService;
    public LoginViewModel(Context mContext, APIService apiService) {
        super(mContext);
        this.apiService = apiService;
        email = new ObservableField<>("");
        password = new ObservableField<>("");

        errorPass = new ObservableField<>(null);
        errorEmail = new ObservableField<>(null);
    }


    public void doLogin(View v){
    }
    @Override
    public void destroy() {
        if (subscription != null) {
            subscription.unsubscribe();
            subscription = null;
        }
    }

    public boolean validate(User user) {
        boolean valid = true;


        if (user.email.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(user.email).matches()) {
            errorEmail.set("enter a valid email address");
            valid = false;
        } else {
            errorEmail.set(null);
        }

        if (user.password.isEmpty() || user.password.length() < 4 || user.password.length() > 10) {
            errorPass.set("between 4 and 10 alphanumeric characters");
            valid = false;
        } else {
            errorPass.set(null);
        }

        return valid;
    }

}
