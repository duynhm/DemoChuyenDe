package dzumi.demo.app.demoretrofit.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import dzumi.demo.app.demoretrofit.model.base.BaseResponse;
import dzumi.demo.app.demoretrofit.model.base.Notification;

/**
 * Created by Dzumi on 7/30/2016.
 */
public class GetNotificationResponse extends BaseResponse {
    @SerializedName("data")
    @Expose
    Notification notification;

    public Notification getNotification() {
        return notification;
    }

    public void setNotification(Notification notification) {
        this.notification = notification;
    }
}
