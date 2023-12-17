import java.util.Random;

enum FoodType {
    EXPENSIVE, CHEAP
}

class Pet {
    protected String name;
    protected double weight;
    protected int age;
    protected String owner;

    public Pet(String name, double weight, int age, String owner) {
        this.name = name;
        this.weight = weight;
        this.age = age;
        this.owner = owner;
    }

    public void say() {
        System.out.println("Питомец сказал...");
    }
}

class Cat extends Pet {
    private String breed;
    private FoodType foodType;

    public Cat(String name, double weight, int age, String owner, String breed, FoodType foodType) {
        super(name, weight, age, owner);
        this.breed = breed;
        this.foodType = foodType;
    }

    @Override
    public void say() {
        System.out.println(name + " сказал Мяу!");
    }

    public void walk() {
        System.out.println("Прогулка с " + owner + " и " + breed + " котом");
    }

    public void walk(String name) {
        System.out.println("Прогулка с " + name + " и " + breed + " котом");
    }
}

class Dog extends Pet {
    private String breed;
    private FoodType foodType;

    public Dog(String name, double weight, int age, String owner, String breed, FoodType foodType) {
        super(name, weight, age, owner);
        this.breed = breed;
        this.foodType = foodType;
    }

    @Override
    public void say() {
        System.out.println(name + " сказал Гав!");
    }

    public void walk() {
        System.out.println("Прогулка с " + owner + " и " + breed + " собакой");
    }

    public void walk(String name) {
        System.out.println("Прогулка с " + name + " и " + breed + " собакой");
    }
}

class Parrot extends Pet {
    private String country;
    private boolean hasDocuments;

    public Parrot(String name, double weight, int age, String owner, String country, boolean hasDocuments) {
        super(name, weight, age, owner);
        this.country = country;
        this.hasDocuments = hasDocuments;
    }

    @Override
    public void say() {
        System.out.println(name + " сказал Кар(я не знаю, что говорят попугаи)!");
    }

    public void fly() {
        Random random = new Random();
        int minutes = random.nextInt(60) + 1;
        System.out.println(name + " улетел, но обещал вернуться через " + minutes + " минут");
    }
}
