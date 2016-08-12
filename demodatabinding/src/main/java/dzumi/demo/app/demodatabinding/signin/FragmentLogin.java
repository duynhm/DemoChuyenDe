package dzumi.demo.app.demodatabinding.signin;

import android.app.Fragment;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import dzumi.demo.app.demodatabinding.R;
import dzumi.demo.app.demodatabinding.databinding.ActivityLoginBinding;

/**
 * Created by Dzumi on 8/6/2016.
 */
public class FragmentLogin extends Fragment {

    ActivityLoginBinding binding;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
       /* View view = null;
        view = inflater.inflate(R.layout.activity_login, container, false);
        return view;*/

        binding = DataBindingUtil.inflate(inflater, R.layout.activity_login,container, false);
        return binding.getRoot();
    }

}
