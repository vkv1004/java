package Task_4;

import java.util.List;
import java.util.Optional;
import java.util.function.*;

public class Main{
    public static <T, R> Optional<R> processElements(
            List<T> elements,
            Predicate<T> predicate,
            Function<T, R> mapper,
            BinaryOperator<R> operator) {

        return elements.stream()
                .filter(predicate)
                .map(mapper)
                .reduce(operator);
    }

    public static void main(String[] args) {
        List<String> words = List.of("Hello", "World", "Semester1");
        Optional<String> result = processElements(
                words,
                s -> s.length() > 3,
                String::toUpperCase,
                String::concat);
        result.ifPresent(System.out::println);
    }
}