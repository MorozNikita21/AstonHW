package lesson1_HW;

public interface MyList<T> extends MyCollection<T>{

    /**
     * Получение элемента на указанной позиции
     * @param index индекс элемента, который хотите получить
     * @return T - элемент типа T
     * @author Мороз Никита
     */
    T get(int index);

    /**
     * Вставка элемента в конец
     * @param element элемент, который хотите вставить
     * @return true - если элемент был удачно добавлен, в противном случае - false
     * @author Мороз Никита
     */
    boolean add(T element);

    /**
     * Добавление элемента на указанную позицию
     * @param element элемент, который хотите вставить
     * @param index индекс, на который хотите вставить элемент
     * @return true - если элемент был удачно добавлен, в противном случае - false
     * @author Мороз Никита
     */
    boolean add(T element, int index);

    /**
     * Проверка на наличие элемента
     * @param element элемент, который хотите проверить на наличие
     * @return true - если элемент был найден, в противном случае - false
     * @author Мороз Никита
     */
    boolean contains(T element);

    /**
     * Удаление элемента
     * @param element элемент, который хотите удалить
     * @return true - если элемент был удачно удалён, в противном случае - false
     * @author Мороз Никита
     */
    boolean remove(T element);

    /**
     * Удаление элемента на указанной позиции
     * @param index индекс элемента, который хотите удалить
     * @return true - если элемент был удачно удалён, в противном случае - false
     * @author Мороз Никита
     */
    boolean removeAt(int index);

    /**
     * Возвращение размера
     * @return size - размер
     * @author Мороз Никита
     */
    int size();

    /**
     * Очистка от всех элементов
     * @author Мороз Никита
     */
    void clear();
}

