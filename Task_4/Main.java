package Task_4;

public class Main {
    public static void main(String[] args) {
        NumberClassifier classifier = (number) -> {
            if (number > 0) {
                return "Положительное число";
            } else if (number < 0) {
                return "Отрицательное число";
            } else {
                return "Ноль";
            }
        };

        String result = classifier.classify(42);
        System.out.println(result);
    }

    interface NumberClassifier {
        String classify(int number);
    }
}
