package dzumi.demo.app.demodatabinding.signin;

import android.app.ProgressDialog;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.location.Location;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import dzumi.demo.app.demodatabinding.R;
import dzumi.demo.app.demodatabinding.databinding.ActivityLoginBinding;
import dzumi.demo.app.demodatabinding.signin.model.User;

public class LoginActivity extends AppCompatActivity {
ActivityLoginBinding binding;
    User user;
    private static final String TAG = "LoginActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login);
        user = new User();

        binding.setViewModel(user);
    }

    void login() {
        user.errorPass.set(null);
        if(user.getPassword().length() < 8)
            user.errorPass.set("pass length >= 8");

    }

    public void doLogin(View v) {
        login();
    }

}

