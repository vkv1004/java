package Task_1;

public interface Matrix<T> {
    void addElement(T element);
    void removeElement(int row, int column);
    T getElement(int row, int column);
}