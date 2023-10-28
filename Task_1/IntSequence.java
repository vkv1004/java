package Task_1;

public interface IntSequence {
    int next();

    static IntSequence of(int... values) {
        return new IntSequence() {
            private int index = 0;

            @Override
            public int next() {
                try {
                    return values[index++];
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("Выход за границы массива");
                    return 0;
                }
            }
        };
    }

    static IntSequence constant(int value) {
        return new IntSequence() {
            @Override
            public int next() {
                return value;
            }
        };
    }
}
