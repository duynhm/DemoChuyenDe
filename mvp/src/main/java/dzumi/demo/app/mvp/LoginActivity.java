package dzumi.demo.app.mvp;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class LoginActivity extends AppCompatActivity implements CallbackLoginActivity {
    private static final String TAG = "LoginActivity";

    EditText edtEmail;
    EditText edtPassword;
    Button btnLogin;
    TextView tvSignUpLink;

    ILoginPresenter loginPresenter;
    private ProgressDialog progressDialog;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_sample_login2);

        loginPresenter = new LoginPresenter(this, this);

        edtEmail = (EditText) findViewById(R.id.edtEmail);
        edtPassword = (EditText) findViewById(R.id.edtPassword);
        tvSignUpLink = (TextView) findViewById(R.id.tvSignUpLink);
        btnLogin = (Button) findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if(progressDialog == null)
                    progressDialog = new ProgressDialog(LoginActivity.this);
                progressDialog.setIndeterminate(true);

                progressDialog.setMessage("Authenticating...");
                progressDialog.show();

                String email = edtEmail.getText().toString();
                String password = edtPassword.getText().toString();

                User user = new User();
                user.setUserName(email);
                user.setPassword(password);

                loginPresenter.login(user);
            }
        });


    }


    @Override
    public void onLoginSuccess() {
        progressDialog.dismiss();
        Toast.makeText(getBaseContext(), "Login success", Toast.LENGTH_LONG).show();
        btnLogin.setEnabled(true);
        finish();
    }

    @Override
    public void onLoginFailed() {
        progressDialog.dismiss();
        Toast.makeText(getBaseContext(), "Login failed", Toast.LENGTH_LONG).show();
        btnLogin.setEnabled(true);
    }

    @Override
    public void setErrorUsername(String error) {
        edtEmail.setError(error);
    }

    @Override
    public void setErrorPassword(String error) {
        edtPassword.setError(error);
    }
}
