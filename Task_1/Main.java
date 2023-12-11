package Task_1;

import java.util.function.*;

public class Main {
    public static void main(String[] args) {
        Integer value = 21;
        mult2(value);
    }

    static <A, B, C> Function<B, C> bind(BiFunction<A, B, C> fn, A a) {
        return b -> fn.apply(a, b);
    }
    static void mult2(Integer n) {
        Function<Integer, Integer> result = bind((a, b) -> a * b, 2);
        System.out.println(result.apply(n));
    }
}