package lesson1_HW;

import java.util.Arrays;
import java.util.Iterator;

public class MyArrayList<T> implements MyList<T> {

    private Object[] array = new Object[10];
    private int size = 0;

    /**
     * Получение элемента на указанной позиции в массиве
     * @param index индекс элемента, который хотите получить, в массиве
     * @return T - элемент типа T
     * @exception IndexOutOfBoundsException если передаваемый индекс отрицательный или неменьше размера массива
     * @author Мороз Никита
     */
    @Override
    public T get(int index) {
        checkIndex(index);
        return (T) array[index];
    }

    /**
     * Вставка элемента в конец массива
     * @param element элемент, который хотите вставить
     * @return true - если элемент был удачно добавлен, в противном случае - false
     * @author Мороз Никита
     */
    @Override
    public boolean add(T element) {
        increaseArray();
        array[size] = element;
        size++;
        return true;
    }

    /**
     * Удаление элемента в массиве
     * @param element элемент, который хотите удалить
     * @return true - если элемент был удачно удалён, в противном случае - false
     * @author Мороз Никита
     */
    @Override
    public boolean remove(T element) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(element)) {
                return removeAt(i);
            }
        }
        return false;
    }

    /**
     * Удаление элемента на указанной позиции в массиве
     * @param index индекс элемента, который хотите удалить, в массиве
     * @return true - если элемент был удачно удалён, в противном случае - false
     * @exception IndexOutOfBoundsException если передаваемый индекс отрицательный или неменьше размера массива
     * @author Мороз Никита
     */
    @Override
    public boolean removeAt(int index) {
        checkIndex(index);
        System.arraycopy(array, index + 1, array, index, size - index - 1);
        size--;
        return true;
    }

    /**
     * Добавление элемента на указанную позицию в массиве
     * @param element элемент, который хотите вставить в массив
     * @param index индекс, на который хотите вставить элемент
     * @return true - если элемент был удачно добавлен, в противном случае - false
     * @exception IndexOutOfBoundsException если передаваемый индекс отрицательный или неменьше размера массива
     * @author Мороз Никита
     */
    @Override
    public boolean add(T element, int index) {
        increaseArray();
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        System.arraycopy(array, index, array, index + 1, size - index);
        array[index] = element;
        size++;
        return true;
    }

    /**
     * Проверка на наличие элемента в массиве
     * @param element элемент, который хотите проверить на наличие
     * @return true - если элемент был найден, в противном случае - false
     * @author Мороз Никита
     */
    @Override
    public boolean contains(T element) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(element)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Прохождение по всем элементам в массиве
     * @author Мороз Никита
     */
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {

            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < size;
            }

            @Override
            public T next() {
                return (T) array[index++];
            }
        };
    }

    /**
     * Возвращение размера массива
     * @return size - размер массива
     * @author Мороз Никита
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Очистка массива от всех элементов
     * @author Мороз Никита
     */
    @Override
    public void clear() {
        array = new Object[10];
        size = 0;
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
    }

    private void increaseArray() {
        if (size >= array.length) {
            array = Arrays.copyOf(array, array.length * 2);
        }
    }
}
