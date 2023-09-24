public class Car {
    private String colour;
    private int fuel;
    private final int maxFuel;
    private final String model;
    private final Engine engine;
    private int mileage;
  
    public Car(String colour, int maxFuel, String model) {
        this.colour = colour;
        this.maxFuel = maxFuel;
        this.model = model;
        this.engine = new Engine();
    }

    public void startEngine() {
        if (fuel <= 0) {
            System.out.println("Нет топлива. Требуется дозаправка.");
            return;
        }

        engine.turnOn();
        System.out.println("Двигатель запущен.");
    }

    public void stopEngine() {
        engine.turnOff();
        System.out.println("Двигатель остановлен.");
    }

    public void refuel() {
        refuel(maxFuel - fuel);
    }

    public void refuel(int amount) {
        if (amount <= 0) {
            System.out.println("Топливо закончилось.");
            return;
        }

        fuel = Math.min(fuel + amount, maxFuel);
        System.out.println("Машина заправлена. Уровень топлива: " + fuel);
    }

    public void drive(int distance) {
        if (!engine.isOn()) {
            System.out.println("Запустите двигатель.");
            return;
        }

        double maxDistance = fuel / engine.getFuelConsumption();
        if (distance > maxDistance) {
            System.out.println("Требуется дозаправка.");
            return;
        }

        fuel -= distance * engine.getFuelConsumption();
        mileage += distance;
        System.out.println("Машина проехала " + distance + " км. Пробег: " + mileage + " km.");
    }

    public void info() {
        System.out.println("info:");
        System.out.println("Цвет: " + colour);
        System.out.println("Уровень топлива: " + fuel);
        System.out.println("Максимальный уровень топлива: " + maxFuel);
        System.out.println("Модель: " + model);
        System.out.println("Пробег: " + mileage + " км");
        System.out.println("Статус двигателя: " + (engine.isOn() ? "on" : "off"));
        System.out.println("Расход топлива: " + engine.getFuelConsumption() + " км/литр");
    }

private class Engine {
    private boolean isOn;
    private int fuelConsumption;

    public Engine() {
        this.isOn = false;
        this.fuelConsumption = 40; // default fuel consumption rate
    }

    public void turnOn() {
        isOn = true;
    }

    public void turnOff() {
        isOn = false;
    }

    public boolean isOn() {
        return isOn;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }
}
}
