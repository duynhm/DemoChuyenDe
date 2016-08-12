package dzumi.demo.app.demodatabinding;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import dzumi.demo.app.demodatabinding.databinding.ActivityProfileBinding;
import dzumi.demo.app.demodatabinding.signin.model.User;

public class ProfileActivity extends AppCompatActivity {
    ActivityProfileBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView();

        binding = DataBindingUtil.
                setContentView(this, R.layout.activity_profile);

        initData();
    }

    void initData(){
        User user = new User();
        user.setUserName("t3h");
        user.setName("Trung tâm tin học KHTN");
        user.setAge(10);
        user.setAddress("357 Lê Hồng Phong, Phường 2, Quận 10, TP. Hồ Chí Minh");

        binding.setUser(user);
    }
}
