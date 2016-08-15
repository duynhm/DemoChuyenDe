package dzumi.demo.app.mvvm.modules.sign;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import javax.inject.Inject;

import dzumi.demo.app.mvvm.BaseApplication;
import dzumi.demo.app.mvvm.R;
import dzumi.demo.app.mvvm.databinding.LayoutSampleLogin2Binding;
import dzumi.demo.app.mvvm.network.APIService;


public class LoginActivity extends AppCompatActivity  {
    private static final String TAG = "LoginActivity";

    @Inject
    APIService apiService;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ((BaseApplication)getApplication()).getAppComponent().inject(this);

        LayoutSampleLogin2Binding binding = DataBindingUtil.setContentView(this,R.layout.layout_sample_login2 );
        LoginViewModel loginViewModel = new LoginViewModel(this, apiService);
        binding.setViewModel(loginViewModel);
    }

}
