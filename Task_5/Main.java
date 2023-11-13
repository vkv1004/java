package Task_5;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(8, 0, 5, 3, 7, 9);
        System.out.println(medianSort(numbers));
    }

    public static List<Integer> medianSort(List<Integer> list) {
        Collections.sort(list);
        int median;
        if (list.size() % 2 == 0) {
            median = (list.get(list.size() / 2 - 1) + list.get(list.size() / 2)) / 2;
        } else {
            median = list.get(list.size() / 2);
        }
        List<Integer> sortedList = list.stream()
                .sorted(Comparator.comparingInt(num -> Math.abs(num - median)))
                .toList();
        return sortedList;
    }
}
