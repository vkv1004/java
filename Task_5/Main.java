package Task_5;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class Main {
    public static <T, R> List<R> map(List<T> list, Function<T, R> function) {
        List<R> result = new ArrayList<>();
        for (T element : list) {
            R mappedElement = function.apply(element);
            result.add(mappedElement);
        }
        return result;
    }

    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5);
        List<Integer> mappedNumbers = map(numbers, n -> n*n);
        System.out.println(mappedNumbers); // [1, 4, 9, 16, 25]
    }
}
