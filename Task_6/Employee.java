package Task_6;

import java.util.Comparator;

public class Employee implements Comparable<Employee> {
    private String name;
    private String surname;
    private String city;
    private int age;
    private int salary;

    public Employee(String name, String surname, String city, int age, int salary) {
        this.name = name;
        this.surname = surname;
        this.city = city;
        this.age = age;
        this.salary = salary;
    }

    public Employee(String name, int age) {
        this(name, "", "", age, 0);
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getCity() {
        return city;
    }

    public int getAge() {
        return age;
    }

    public int getSalary() {
        return salary;
    }

    public static final Comparator<Employee> AGE_SALARY_COMPARATOR = Comparator
            .comparing(Employee::getAge)
            .thenComparing(Employee::getSalary);
    public static final Comparator<Employee> PASSPORT_COMPARATOR = Comparator
            .comparing(Employee::getName)
            .thenComparing(Employee::getSurname)
            .thenComparing(Employee::getCity);
    public static final Comparator<Employee> FULL_COMPARATOR = Comparator
            .comparing(Employee::getName)
            .thenComparing(Employee::getSurname)
            .thenComparing(Employee::getCity)
            .thenComparing(Employee::getAge)
            .thenComparing(Employee::getSalary);

    @Override
    public int compareTo(Employee first) {
        if (this.name.compareToIgnoreCase(first.getName()) > 0) {
            return 1;
        } else if (this.name.compareToIgnoreCase(first.getName()) < 0) {
            return -1;
        } else {
            if (this.age > first.getAge()) {
                return 1;
            } else if (this.age < first.getAge()) {
                return -1;
            } else {
                return 0;
            }
        }
    }
}