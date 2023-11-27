package Task_2;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static <K, V> Map<V, Collection<K>> inverse(Map<? extends K, ? extends V> map){
        Map<V, K> swapMap = map.entrySet().stream().collect(Collectors.toMap(Map.Entry::getValue, Map.Entry::getKey, (a, b) -> b));
        return (Map<V, Collection<K>>) swapMap;
    }

    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("a", 1);
        map.put("b", 2);
        map.put("c", 3);
        Map<Integer, Collection<String>> swapMap = inverse(map);
        System.out.println(swapMap);
    }
}