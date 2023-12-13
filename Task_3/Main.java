package Task_3;

import java.util.function.*;

public class Main {
    public static void main(String[] args) {
        Function<String, String> sayHello = saySmth("Hello");
        System.out.println(sayHello.apply("Alice"));
    }

    static <A, B, C> Function<A, Function<B, C>> curry(BiFunction<A, B, C> fn) {
        return a -> b -> fn.apply(a, b);
    }

    static Function<String, String> saySmth(String greeting) {
        BiFunction<String, String, String> form = (a, b) -> a + ", " + b + "!";
        return curry(form).apply(greeting);
    }
}
