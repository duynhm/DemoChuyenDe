package dzumi.demo.app.mvvm.db.dao.base;

import java.util.List;

/**
 * Created by Dzumi on 6/6/2016.
 */
public interface IBaseDAO<T> {
    List<T> get();
    T getByID(int id);
    long insert(T t);
    int insert(List<T> items);
    int update(T t);
    int delete(T t);
    int delete(int id);


}
