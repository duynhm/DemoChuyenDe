package dzumi.demo.app.mvvm.dagger;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dzumi.demo.app.mvvm.db.provider.DataProvider;
import dzumi.demo.app.mvvm.db.provider.IDataProvider;

/**
 * Created by Dzumi on 6/2/2016.
 */
@Module
public class DBModule {
    @Provides
    @Singleton
    IDataProvider provideData(Application application){
        return new DataProvider(application);
    }
}
