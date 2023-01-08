package repository;

import java.util.List;

public interface GeneralService<T> {
    public List<T> findAll();

    public void add(T t);

    public void updateById(int id, T t);

    public void deleteById(int id);

    public T findById(int id);
}
