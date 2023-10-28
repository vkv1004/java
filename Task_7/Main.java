package Task_7;

public class Main {
    public static void main(String[] args) {
        try {
            int a = 42 / 0;
        } catch (ArithmeticException e) {
            System.out.println("Нельзя делить на ноль!");
        }
    }
}
