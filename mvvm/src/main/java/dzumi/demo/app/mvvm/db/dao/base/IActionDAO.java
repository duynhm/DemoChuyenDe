package dzumi.demo.app.mvvm.db.dao.base;

import android.content.ContentValues;

/**
 * Created by Dzumi on 6/6/2016.
 */
public interface IActionDAO<T> {
    ContentValues mapContentValues(T t);
}
