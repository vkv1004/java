package Task_2;

import java.util.function.*;

public class Main{
    public static void main(String[] args) {
        String string = "abcdefg";
        substring5(string);
    }

    static <A, B, C> Function<B, C> bind(BiFunction<A, B, C> fn, A a) {
        return b -> fn.apply(a, b);
    }

    static void substring5(String str) {
        Function<String, String> result = bind((a, b) -> b.substring(0, a), 5);
        System.out.println(result.apply(str));
    }
}