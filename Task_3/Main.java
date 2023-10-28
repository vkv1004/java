package Task_3;

public class Main {
    public static void main(String[] args) {
        Printable printable = () -> System.out.println("текст на ваше усмотрение");
        printable.print();
    }
}
