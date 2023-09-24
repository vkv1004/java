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
        //Животные
        Cat cat = new Cat("Мурзик", 5.2, 3, "Вася", "Персидский", FoodType.EXPENSIVE);
        cat.say();
        cat.walk();
        cat.walk("Алиса");

        Dog dog = new Dog("Шарик", 10.5, 5, "Маша", "Лабрадор", FoodType.CHEAP);
        dog.say();
        dog.walk();
        dog.walk("Максим");

        Parrot parrot = new Parrot("Полли", 0.3, 1, "Катя", "Бразилия", true);
        parrot.say();
        parrot.fly();
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

