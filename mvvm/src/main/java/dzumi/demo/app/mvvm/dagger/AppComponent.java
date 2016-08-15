package dzumi.demo.app.mvvm.dagger;

import javax.inject.Singleton;

import dagger.Component;
import dzumi.demo.app.mvvm.modules.sign.LoginActivity;

/**
 * Created by Dzumi on 5/12/2016.
 */
@Singleton
@Component(modules = {AppModule.class, NetModule.class, DBModule.class})
public interface AppComponent {
    //inject activity
    void inject(LoginActivity activity);
}
