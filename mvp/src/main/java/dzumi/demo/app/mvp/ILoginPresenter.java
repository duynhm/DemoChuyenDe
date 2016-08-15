package dzumi.demo.app.mvp;

/**
 * Created by Dzumi on 8/15/2016.
 */
public interface ILoginPresenter {
    void login(User user);
    boolean validate(User user);
}
