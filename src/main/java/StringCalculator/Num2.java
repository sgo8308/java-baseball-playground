package StringCalculator;

import java.util.Objects;

class Num2 {
    private int num2;

    public Num2(int num2) {
        this.num2 = num2;
    }

    public int getNum2() {
        return num2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Num2 num21 = (Num2) o;
        return num2 == num21.num2;
    }

    @Override
    public int hashCode() {
        return Objects.hash(num2);
    }
}
