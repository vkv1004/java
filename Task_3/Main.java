package Task_3;

import java.util.*;

public class Main {
    public static <E> Set<E> union(Set<? extends E> s1, Set<? extends E> s2) {
        Set<E> result = new HashSet<>(s1);
        result.addAll(s2);
        return result;
    }

    public static <E> Set<E> intersection(Set<? extends E> s1, Set<? extends E> s2) {
        Set<E> result = new HashSet<>(s1);
        result.retainAll(s2);
        return result;
    }

    public static <E> Set<E> difference(Set<? extends E> s1, Set<? extends E> s2) {
        Set<E> result = new HashSet<>(s1);
        result.removeAll(s2);
        return result;
    }

    public static <E> Set<E> symmetricDifference(Set<? extends E> s1, Set<? extends E> s2) {
        Set<E> union = new HashSet<>(s1);
        union.addAll(s2);
        Set<E> intersection = new HashSet<>(s1);
        intersection.retainAll(s2);
        return difference(union, intersection);
    }

    public static void main(String[] args) {
        Set<String> set1 = new HashSet<>();
        set1.add("a");
        set1.add("b");
        set1.add("c");
        Set<String> set2 = new HashSet<>();
        set2.add("b");
        set2.add("c");
        set2.add("d");
        System.out.println(union(set1, set2));
        System.out.println(intersection(set1, set2));
        System.out.println(difference(set1, set2));
        System.out.println(symmetricDifference(set1, set2));
    }
}
