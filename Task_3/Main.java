package Task_3;

import java.util.AbstractList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> range = rangeList(3, 8);
        System.out.println(range);
        System.out.println(range.indexOf(5));
        System.out.println(range.lastIndexOf(5));
    }

    static List<Integer> rangeList(int from, int to) {
        return new AbstractList<>() {
            @Override
            public Integer get(int index) {
                if (index < 0 || index >= size()) {
                    throw new IndexOutOfBoundsException();
                }
                return from + index;
            }

            @Override
            public int size() {
                return Math.max(0, to - from);
            }

            @Override
            public int indexOf(Object o) {
                if (o instanceof Integer) {
                    int value = (int) o;
                    if (value >= from && value < to) {
                        return value - from;
                    }
                }
                return -1;
            }

            @Override
            public int lastIndexOf(Object o) {
                return indexOf(o);
            }

            @Override
            public boolean contains(Object o) {
                if (o instanceof Integer) {
                    int value = (int) o;
                    return value >= from && value < to;
                }
                return false;
            }
        };
    }
}
