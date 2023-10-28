package Task_8;

public class Main {
    public static void main(String[] args) {
        try {
            String s = null;
            String m = s.toLowerCase();
        } catch (NullPointerException e) {
            System.out.println("Строка пуста");
            String m = null;
        }
    }
}
