package lesson1_HW;

public interface MyCollection<T> extends Iterable<T> {
    boolean add(T element);
    boolean remove(T element);
    boolean contains(T element);
    int size();
    void clear();
}
