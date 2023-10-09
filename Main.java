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
        if (number < 0){
            return 0;
        }
        else if ((number == 1) || (number == 0)){
            return 1;
        }
        else{
            return number*task_4(number - 1);
        }
    }
    public static BigInteger task_5(BigInteger number) {
        // Факториал
        BigInteger value_result = number.subtract(BigInteger.ONE);
        if (number.compareTo(BigInteger.ONE) <= 0){
            return BigInteger.ONE;
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
        if (numbers.length == 0){
            System.out.println(0);
        }
        else{
            int sum = IntStream.of(numbers).sum();
            int lngh = numbers.length;
            System.out.println(sum/lngh);
        }
    }
    //магический квадрат
    static boolean task_8(int[][] square) {
        int n = square.length;
        int m = square[0].length;
        if(n != m){
            return false;
        }
        long sm = Arrays.stream(square[0]).sum();
        for(int i = 0; i < n; i++){
            if(Arrays.stream(square[i]).sum() != sm){
                return false;
            }
        }
        for (int i = 0; i < n; i++){
            long sm_i = 0;
            for (int j = 0; j < n; j++){
                sm_i += square[j][i];
            }
            if(sm_i != sm){
                return false;
            }
        }
        long sm_0 = 0;
        for(int i = 0; i < n; i++){
            sm_0 += square[i][i];
        }
        if (sm_0 != sm){
            return false;
        }
        long sm_1 = 0;
        for(int i = 0; i < n; i++){
            sm_1 += square[i][n-i-1];
        }
        if (sm_1 != sm){
            return false;
        }
        return true;
    }
    public static void task_9(int[] a) {
        // reverse
        int temp = 0;
        for (int i = 0; i < a.length/2; i++){
            temp = a[a.length - i - 1];
            a[a.length - i - 1] = a[i];
            a[i] = temp;
        }
        for(int i = 0; i < a.length; i++){
            System.out.print(a[i] + " ");
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
    static int[] task_11(int[] a, int n) {
        // удаление элемента
        int c = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] != n){
                c++;
            }
        }
        int[] b = new int[c];
        int j = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] != n){
                b[j] = a[i];
                j++;
            }
        }
        return b;
    }
}
