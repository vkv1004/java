public record Contact(String name, String email) {
    public Contact(String name) {
        this(name, "default@gmail.com");
    }

    public Contact {
        if (name == null || email == null) {
            throw new IllegalArgumentException("Имя и адрес электронной почты не могут быть null");
        }

        if (name.isEmpty()) {
            throw new IllegalArgumentException("Имя не может быть пустым");
        }

        if (!email.endsWith("@gmail.com")) {
            throw new IllegalArgumentException("Адрес электронной почты должен быть с @gmail.com");
        }
    }

    public void sayHello() {
        System.out.println("Привет, " + name);
    }
}
