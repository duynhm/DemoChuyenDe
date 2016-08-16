package dzumi.demo.app.mvvm.base;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Dzumi on 7/30/2016.
 */
public class BaseResponse {
    public final static int STATUS_OK = 200;
    @SerializedName("msg") @Expose String msg;
    @SerializedName("status") @Expose int status;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
