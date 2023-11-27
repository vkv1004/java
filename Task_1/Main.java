package Task_1;
import java.util.*;

public class Main {
    public static List<Integer> findPrimes(int n) {
        HashSet<Integer> numbers = new HashSet<>();
        ArrayList<Integer> primes = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            numbers.add(i);
        }
        while (numbers.iterator().hasNext()) {
            int element = numbers.iterator().next();
            primes.add(element);
            for (int i = element; i <= n; i += element) {
                numbers.remove(i);
            }
        }
        return primes;
    }

    public static void main(String[] args) {
        System.out.println(findPrimes(10));
        System.out.println(findPrimes(15));
    }
}