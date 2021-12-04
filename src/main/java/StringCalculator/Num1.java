package StringCalculator;

import java.util.Objects;

class Num1 {
    private int num1;

    public Num1(int num1) {
        this.num1 = num1;
    }

    public int getNum1() {
        return num1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Num1 num11 = (Num1) o;
        return num1 == num11.num1;
    }

    @Override
    public int hashCode() {
        return Objects.hash(num1);
    }
}
