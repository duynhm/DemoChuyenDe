package dzumi.demo.app.mvvm.db.dao.base;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import dzumi.demo.app.mvvm.db.DatabaseHelper;


/**
 * Created by Dzumi on 5/15/2016.
 */
public abstract class BaseDao<T>{
    public final static String TAG = BaseDao.class.getName();
    protected Context context;
    public BaseDao(Context context){
        this.context = context;
    }

    public abstract int clearTable();
    protected abstract T fetch(Cursor cursor);
    protected List<T> fetchAll(Cursor cursor){
        List<T> listData = new ArrayList<>();

        if (cursor != null) {
            Log.i(TAG, "list "+this.getClass()+" size:" + cursor.getCount());
            if (cursor.moveToFirst()) {
                do {
                    listData.add(fetch(cursor));
                } while (cursor.moveToNext());
            }
            cursor.close();
        }
        return listData;
    }

    protected SQLiteDatabase getDB(){
        return DatabaseHelper.getInstance(context).getDB();
    }
}
