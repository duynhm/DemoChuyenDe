package dzumi.demo.app.mvvm;

import android.app.Application;

import dzumi.demo.app.mvvm.dagger.AppComponent;
import dzumi.demo.app.mvvm.dagger.AppModule;
import dzumi.demo.app.mvvm.dagger.DaggerAppComponent;
import dzumi.demo.app.mvvm.dagger.NetModule;


/**
 */
public class BaseApplication extends Application {

    private static BaseApplication mInstance;
    private AppComponent mAppComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        mInstance = this;

        mAppComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .netModule(new NetModule(""))
                .build();

        androidDefaultUEH = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(handler);
    }

    private Thread.UncaughtExceptionHandler androidDefaultUEH;
    private Thread.UncaughtExceptionHandler handler = new Thread.UncaughtExceptionHandler() {
        public void uncaughtException(Thread thread, Throwable ex) {
//            Log.e("TestApplication", "Uncaught exception is: ", ex);
            androidDefaultUEH.uncaughtException(thread, ex);
//            FirebaseCrash.report(ex);
        }
    };

    public static synchronized BaseApplication getInstance() {
        return mInstance;
    }

    public AppComponent getAppComponent() {
        return mAppComponent;
    }

}
