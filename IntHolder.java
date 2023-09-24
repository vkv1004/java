import java.util.Objects;

public class IntHolder {
    private int value;

    public IntHolder(int value) {
        this.value = value;
    }

    public static IntHolder fromInt(int value) {
        return new IntHolder(value);
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public static void swap(IntHolder i, IntHolder j) {
        int temp = i.getValue();
        i.setValue(j.getValue());
        j.setValue(temp);
    }

    public IntHolder add(IntHolder other) {
        return new IntHolder(value + other.getValue());
    }

    public IntHolder subtract(IntHolder other) {
        return new IntHolder(value - other.getValue());
    }

    public IntHolder multiply(IntHolder other) {
        return new IntHolder(value * other.getValue());
    }

    public IntHolder divide(IntHolder other) {
        return new IntHolder(value / other.getValue());
    }

    public IntHolder modulo(IntHolder other) {
        return new IntHolder(value % other.getValue());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        IntHolder other = (IntHolder) obj;
        return value == other.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
