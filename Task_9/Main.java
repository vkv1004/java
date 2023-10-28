package Task_9;

public class Main {
    public static void main(String[] args) {
        try {
            int[] m = new int[2];
            m[8] = 5;
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Выход за границы массива");
        }
    }
}
