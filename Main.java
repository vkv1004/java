import java.lang.Math;
import java.math.BigInteger;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        //task_1(10);
        //task_2(-1);
        //task_3(1, -1000, 500);
        //System.out.println(task_4(5));
        //System.out.println(task_5(new BigInteger("5")));
        //task_6();
        //task_7(1, 1, 2, 4);
        /*int a[] = new int[]{1, 2, 5, 4};
        task_9(a);*/
        /*int a[] = new int[]{10, 8, 5, 6};
        task_10(a);*/
        /*int a[] = new int[]{10, 8, 5, 10, 0, 10, 6};
        task_11(a, 10);*/
    }
    public static void task_1(int number) {
        // Бинарный формат числа
        System.out.println(Integer.toBinaryString(number));

        // Восьмиричная форма
        System.out.println(Integer.toOctalString(number));

        // Шеснадцатиричная форма
        System.out.println(Integer.toHexString(number).toUpperCase());
    }
    public static void task_2(int number) {
        // Нормализация угла
        System.out.println(((number % 360) + 360) % 360);
    }
    public static void task_3(int number_1, int number_2, int number_3) {
        // Максимум
        System.out.println(Math.max(Math.max(number_1, number_2), number_3));
    }
    public static int task_4(int number) {
        // Факториал
         if (number == 1){
             return 1;
         }
         else{
             return number*task_4(number - 1);
         }
    }
    public static BigInteger task_5(BigInteger number) {
        // Факториал
        BigInteger value_1 = new BigInteger("-1");
        BigInteger value_result = number.add(value_1);
        if (number.longValue() == 1){
            return new BigInteger("1");
        }
        else{
            return number.multiply(task_5(value_result));
        }
    }
    public static void task_6() {
        // Таблица умножения
        for (int i = 1; i <= 10; i++){
            for (int j = 1; j <= 10; j++){
                System.out.print(i*j + " ");
            }
            System.out.println();
        }
    }
    public static void task_7(int... numbers) {
        // Среднее арифметическое
        int sum = IntStream.of(numbers).sum();
        int lngh = numbers.length;
        System.out.println(sum/lngh);
    }
    public static void task_9(int[] a) {
        // reverse
        int [] b;
        b = new int[a.length];
        for (int i = a.length; i >= 1; i--){
            b[a.length - i] = a[i-1];
        }
        for (int i = 0; i < a.length; i++){
            System.out.print(b[i] + " ");
        }
    }
    public static void task_10(int[] a) {
        // сортировка
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length - i - 1; j++) {
                if (a[j] > a[j + 1]) {
                    int b = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = b;
                }
            }
        }
        for (int i : a){
            System.out.print(i + " ");
        }
    }
    public static void task_11(int[] a, int element) {
        // удаление элемента
        int c = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] == element){
                c++;
            }
        }
        int b[];
        b = new int[a.length - c];
        int j = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] != element){
                b[j] = a[i];
                j++;
            }
        }
        for (int i : b){
            System.out.print(i + " ");
        }
    }
}
