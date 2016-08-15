package dzumi.demo.app.mvvm.base;

import android.app.ProgressDialog;
import android.content.Context;

/**
 * Created by Dzumi on 4/6/2016.
 */
public abstract class BaseViewModel {

    protected String getTag(){return this.getClass().getName();};
    public Context getContext() {
        return mContext;
    }

    protected Context mContext;

    public BaseViewModel(Context mContext) {
        this.mContext = mContext;
    }

    ProgressDialog mProgressDialog;
    protected void showProgressDialog(String message){
        if(mProgressDialog == null)
        {
            mProgressDialog = new ProgressDialog(mContext);
            mProgressDialog.setCancelable(false);
        }
        mProgressDialog.setMessage(message);
        mProgressDialog.show();
    }

    protected void dismissProgressDialog() {
        if(mProgressDialog == null)
            throw new RuntimeException();
        mProgressDialog.dismiss();
    }

}
