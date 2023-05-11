package imit.seminars.seminar_2;

public interface IBuffer<T> {
    void add(T element);
    T get();
    int getSize();
    void clear();
    boolean isEmpty();
}
