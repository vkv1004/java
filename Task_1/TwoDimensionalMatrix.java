package Task_1;

public class TwoDimensionalMatrix<T> implements Matrix<T> {
    private T[][] matrix;
    private int rows;
    private int columns;

    public TwoDimensionalMatrix() {
        this.rows = 0;
        this.columns = 0;
        this.matrix = (T[][]) new Object[rows][columns];
    }

    public TwoDimensionalMatrix(T[][] matrix) {
        this.rows = matrix.length;
        this.columns = matrix[0].length;
        this.matrix = matrix;
    }

    @Override
    public void addElement(T element) {
        T[][] newMatrix = (T[][]) new Object[rows][columns + 1];
        for (int i = 0; i < rows; i++) {
            System.arraycopy(matrix[i], 0, newMatrix[i], 0, columns);
            newMatrix[i][columns] = element;
        }
        columns++;
        matrix = newMatrix;
    }

    @Override
    public void removeElement(int row, int column) {
        T[][] newMatrix = (T[][]) new Object[rows][columns - 1];
        for (int i = 0; i < rows; i++) {
            int index = 0;
            for (int j = 0; j < columns; j++) {
                if (i != row || j != column) {
                    newMatrix[i][index] = matrix[i][j];
                    index++;
                }
            }
        }
        columns--;
        matrix = newMatrix;
    }

    @Override
    public T getElement(int row, int column) {
        return matrix[row][column];
    }

    public static void main(String[] args) {
        TwoDimensionalMatrix<Integer> matrix = new TwoDimensionalMatrix<>();
        // Добавление элементов
        matrix.addElement(1);
        matrix.addElement(2);
        matrix.addElement(3);

        // Проверка значений элементов
        assert matrix.getElement(0, 0) == 1;
        assert matrix.getElement(0, 1) == 2;
        assert matrix.getElement(0, 2) == 3;

        // Удаление элемента
        matrix.removeElement(0, 1);

        // Проверка значений после удаления
        assert matrix.getElement(0, 0) == 1;
        assert matrix.getElement(0, 1) == 3;
        System.out.println("OK");
    }
}