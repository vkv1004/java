package Task_2;

public class Tuple<T> {
    private Object[] elements;
    private int size;

    public Tuple(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity должен быть хотя бы 0");
        }
        elements = new Object[capacity];
        size = 0;
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index выходит за область определения");
        }
        return (T) elements[index];
    }

    public void add(T el) {
        if (size == elements.length) {
            throw new IllegalStateException("Tuple полон");
        }
        elements[size] = el;
        size++;
    }

    public void add(T el, int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index выходит за область определения");
        }
        if (size == elements.length) {
            throw new IllegalStateException("Tuple полон");
        }
        for (int i = size; i > index; i--) {
            elements[i] = elements[i - 1];
        }
        elements[index] = el;
        size++;
    }

    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index выходит за область определения");
        }
        for (int i = index; i < size - 1; i++) {
            elements[i] = elements[i + 1];
        }
        elements[size - 1] = null;
        size--;
    }

    public void remove(T el) {
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(el)) {
                remove(i);
                return;
            }
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public T orElse(int i, T defaultValue) {
        if (i < 0 || i >= size) {
            return defaultValue;
        }
        return (T) elements[i];
    }

    public static void main(String[] args) {
        Tuple<Integer> tuple = new Tuple<>(5);
        // Добавление элементов
        tuple.add(1);
        tuple.add(2);
        tuple.add(3);
        tuple.add(4);

        // Проверка метода get
        assert tuple.get(0) == 1;
        assert tuple.get(2) == 3;

        // Проверка метода add с индексом
        tuple.add(10, 2);
        assert tuple.get(2) == 10;
        assert tuple.get(3) == 3;
        assert tuple.get(4) == 4;

        // Проверка метода remove с индексом
        tuple.remove(1);
        assert tuple.get(0) == 1;
        assert tuple.get(1) == 10;
        assert tuple.get(2) == 3;

        // Проверка метода remove с элементом
        tuple.remove(Integer.valueOf(10));
        assert tuple.get(0) == 1;
        assert tuple.get(1) == 3;

        // Проверка метода isEmpty
        assert !tuple.isEmpty();

        // Проверка метода orElse
        assert tuple.orElse(0, -1) == 1;
        assert tuple.orElse(2, -1) == -1;

        System.out.println("OK");
    }
}