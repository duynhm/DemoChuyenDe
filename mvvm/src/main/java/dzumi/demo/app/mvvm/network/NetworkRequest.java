package dzumi.demo.app.mvvm.network;

import android.content.Context;
import android.util.Log;

import java.io.IOException;
import java.net.SocketTimeoutException;

import dzumi.demo.app.mvvm.R;
import retrofit2.adapter.rxjava.HttpException;
import rx.Observable;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

public class NetworkRequest {

    private static final String TAG = "NetworkRequest";

    // Default error handling
    private static Action1<Throwable> mOnError = new Action1<Throwable>() {
        @Override
        public void call(Throwable throwable) {
//			PublicFunction.showDialog(getActivity(),throwable.getMessage(), (dialog, which) -> {dialog.dismiss();});
            Log.e(TAG, throwable.getMessage());
            if (throwable instanceof HttpException) {
                HttpException response = (HttpException) throwable;
                int code = response.code();

            }
            throwable.printStackTrace();
        }
    };

    //TODO: co api se xay dung cau truc nay
   /* public static <T> Subscription performAsyncRequest(final Context context, Observable<T> observable,
                                                       Func1<? super T, ? extends BaseRespone> onDoInBackground,
                                                       Action1<? super BaseRespone> onNext) {
        Log.e("TAI", "NetworkRequest - performAsyncRequest");
        // Specify a scheduler (Scheduler.newThread(), Scheduler.immediate(), ...)
        // We choose Scheduler.io() to perform network request in a thread pool
        return observable.subscribeOn(Schedulers.io())
                // Observe result in the main thread to be able to update UI
                .observeOn(AndroidSchedulers.mainThread())
                // Set callbacks actions
                .map(onDoInBackground)
                .onErrorReturn(throwable -> {

                    //neu sua phan error --> update source cho tat ca method co su dung error
                    BaseRespone baseRespone = new BaseRespone();
                    if (throwable instanceof HttpException) {
                        HttpException response = (HttpException) throwable;
                        int code = response.code();
                        baseRespone.setCode(code);
                        baseRespone.addError(response.getMessage());
                        baseRespone.setHasError(true);

                    }else if(throwable instanceof SocketTimeoutException){
                        baseRespone.setCode(BaseRespone.STATUS_SOCKET_TIME_OUT);
                        baseRespone.addError(context.getString(R.string.socket_time_out));
                        baseRespone.setHasError(true);
                    }
                    else if (throwable instanceof IOException) {
                        if (throwable.getMessage().equals("NO_INTERNET")) {
                            baseRespone.setCode(BaseRespone.STATUS_NETWORK_NOT_CONNECTED);
                            baseRespone.addError(context.getString(R.string.error_network_not_connected));
                            baseRespone.setHasError(true);

                        } else {
                            baseRespone.addError(throwable.getMessage());
                            baseRespone.setCode(0);
                            baseRespone.setHasError(true);

                        }
                    } else {
                        baseRespone.addError(throwable.getMessage());
                        baseRespone.setCode(0);
                        baseRespone.setHasError(true);

                    }
                    return baseRespone;
                })
                .subscribe(onNext);
    }*/

}