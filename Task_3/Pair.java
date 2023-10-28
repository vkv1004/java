package Task_3;

public class Pair<T extends Comparable<T>> {
    private T left;
    private T right;

    public Pair(T left, T right) {
        this.left = left;
        this.right = right;
    }

    public T getLeft() {
        return left;
    }

    public void setLeft(T left) {
        this.left = left;
    }

    public T getRight() {
        return right;
    }

    public void setRight(T right) {
        this.right = right;
    }

    public T min() {
        return left.compareTo(right) < 0 ? left : right;
    }

    public T max() {
        return left.compareTo(right) > 0 ? left : right;
    }

    public static void main(String[] args) {
        Pair<Integer> pair = new Pair<>(5, 10);
        System.out.println(pair.min()); // 5
        System.out.println(pair.max()); // 10
    }
}