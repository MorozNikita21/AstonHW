package lesson1_HW;

import java.util.Iterator;

public class MyLinkedList<T> implements MyList<T> {

    private Node first;
    private Node last;
    private int size = 0;


    /**
     * Получение элемента на указанной позиции в списке
     * @param index индекс элемента, который хотите получить, в списке
     * @return T - элемент типа T
     * @exception IndexOutOfBoundsException если передаваемый индекс отрицательный или неменьше размера списка
     * @author Мороз Никита
     */
    @Override
    public T get(int index) {
        return getNode(index).value;
    }

    /**
     * Вставка элемента в конец списка
     * @param element элемент, который хотите вставить
     * @return true - если элемент был удачно добавлен, в противном случае - false
     * @author Мороз Никита
     */
    @Override
    public boolean add(T element) {
        if (size == 0) {
            first = new Node(null, element, null);
            last = first;
        } else {
            Node secondLast = last;
            last = new Node(secondLast, element, null);
            secondLast.next = last;
        }
        size++;
        return true;
    }

    /**
     * Добавление элемента на указанную позицию в списке
     * @param element элемент, который хотите вставить в список
     * @param index индекс, на который хотите вставить элемент
     * @return true - если элемент был удачно добавлен, в противном случае - false
     * @exception IndexOutOfBoundsException если передаваемый индекс отрицательный или неменьше размера списка
     * @author Мороз Никита
     */
    @Override
    public boolean add(T element, int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        if (index == size) {
            return add(element);
        }
        Node nodeNext = getNode(index);
        Node nodePrevious = nodeNext.previous;
        Node newNode = new Node(nodePrevious, element, nodeNext);
        nodeNext.previous = newNode;
        if (nodePrevious != null) {
            nodePrevious.next = newNode;
        } else {
            first = newNode;
        }
        size++;
        return true;
    }

    /**
     * Удаление элемента в списке
     * @param element элемент, который хотите удалить
     * @return true - если элемент был удачно удалён, в противном случае - false
     * @author Мороз Никита
     */
    @Override
    public boolean remove(T element) {
        int index = findElement(element);
        if (index != -1) {
            return removeAt(index);
        }
        return false;
    }

    /**
     * Проверка на наличие элемента в списке
     * @param element элемент, который хотите проверить на наличие
     * @return true - если элемент был найден, в противном случае - false
     * @author Мороз Никита
     */
    @Override
    public boolean contains(T element) {
        return findElement(element) != -1;
    }

    /**
     * Прохождение по всем элементам в списке
     * @author Мороз Никита
     */
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {

            private Node node = first;

            @Override
            public boolean hasNext() {
                return node != null;
            }

            @Override
            public T next() {
                T element = node.value;
                node = node.next;
                return element;
            }
        };
    }

    /**
     * Удаление элемента на указанной позиции в списке
     * @param index индекс элемента, который хотите удалить, в списке
     * @return true - если элемент был удачно удалён, в противном случае - false
     * @exception IndexOutOfBoundsException если передаваемый индекс отрицательный или неменьше размера списка
     * @author Мороз Никита
     */
    @Override
    public boolean removeAt(int index) {
        Node node = getNode(index);
        Node nodeNext = node.next;
        Node nodePrevious = node.previous;
        if (nodeNext != null) {
            nodeNext.previous = nodePrevious;
        } else {
            last = nodePrevious;
        }
        if (nodePrevious != null) {
            nodePrevious.next = nodeNext;
        } else {
            first = nodeNext;
        }
        size--;
        return true;
    }

    /**
     * Возвращение размера списка
     * @return size - размер списка
     * @author Мороз Никита
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Очистка списка от всех элементов
     * @author Мороз Никита
     */
    @Override
    public void clear() {
        first = null;
        last = null;
        size = 0;
    }

    private int findElement(T element) {
        Node node = first;
        for (int i = 0; i < size; i++) {
            if (node.value.equals(element)) {
                return i;
            }
            node = node.next;
        }
        return -1;
    }

    private Node getNode(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node node = first;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }

    private class Node {
        private Node previous;
        private T value;
        private Node next;

        public Node(Node previous, T value, Node next) {
            this.previous = previous;
            this.value = value;
            this.next = next;
        }
    }
}
