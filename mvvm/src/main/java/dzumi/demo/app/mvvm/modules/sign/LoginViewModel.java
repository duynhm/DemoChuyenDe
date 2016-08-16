package dzumi.demo.app.mvvm.modules.sign;

import android.content.Context;
import android.databinding.ObservableField;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.widget.Toast;

import dzumi.demo.app.mvvm.base.BaseResponse;
import dzumi.demo.app.mvvm.base.BaseViewModel;
import dzumi.demo.app.mvvm.base.ViewModel;
import dzumi.demo.app.mvvm.databinding.LayoutSampleLogin2Binding;
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
    LayoutSampleLogin2Binding binding;
    public LoginViewModel(Context mContext, APIService apiService, LayoutSampleLogin2Binding binding) {
        super(mContext);
        this.apiService = apiService;
        this.binding = binding;
        email = new ObservableField<>("");
        password = new ObservableField<>("");

        errorPass = new ObservableField<>(null);
        errorEmail = new ObservableField<>(null);
    }


    public void doLogin(View v) {
        User user = new User();
        user.setEmail(email.get());
        user.setPassword(password.get());
        if (validate(user))
            subscription = NetworkRequest.performAsyncRequest(mContext,
                    apiService.login(user),
                    data -> {
                        if (data.getStatus() == BaseResponse.STATUS_OK) {
                            //lưu sharedPreference

                        }
                        return data;
                    },
                    next -> {
                        if (next.getStatus() == BaseResponse.STATUS_OK)
                            Toast.makeText(mContext, "Success", Toast.LENGTH_SHORT).show();
                        else
                            Toast.makeText(mContext, next.getStatus(), Toast.LENGTH_SHORT).show();
                    }
            );
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
