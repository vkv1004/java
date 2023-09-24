public class Main {
    public static void main(String[] args) {
        Car car = new Car("Red", 50, "Toyota");
        car.startEngine();
        car.refuel(30);
        car.drive(100);
        car.stopEngine();
        car.info();

        car.startEngine();
        car.drive(50);
        car.info();

        car.refuel();
        car.startEngine();
        car.drive(200);
        car.info();
    }
    //Task 1
    static boolean equals(String s, String t) {
        return s.equalsIgnoreCase(t);
    }

    static String replace(String str, String oldStr, String newStr) {
        return str.replaceAll(oldStr, newStr);
    }

    static String format(String surname, int mark, String subject) {
        return String.format("Студент %s получил %d по %s", surname, mark, subject);
    }

    static boolean isPalindrome(String str) {
        StringBuilder reversed = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; i--) {
            reversed.append(str.charAt(i));
        }
        return str.equalsIgnoreCase(reversed.toString());
    }
}

