package utils;

public abstract class Crud<T> {
    public abstract void insert(T entity);
    public abstract void update(T entity);
    public abstract void delete(T entity);
}
