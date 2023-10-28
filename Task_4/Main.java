package Task_4;

public class Main {
    public static <T extends Comparable<T>> Pair<T, T> minMax(T[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }

        T min = arr[0];
        T max = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (arr[i].compareTo(min) < 0) {
                min = arr[i];
            }

            if (arr[i].compareTo(max) > 0) {
                max = arr[i];
            }
        }

        return new Pair<>(min, max);
    }

    public static void main(String[] args) {
        Integer[] numbers = {5, 10, 3, 8, 2};
        Pair<Integer, Integer> result = minMax(numbers);

        System.out.println(result.getLeft()); // 2
        System.out.println(result.getRight()); // 10
    }
}