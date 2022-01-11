package baseball.domain;

public enum NumberPosition {
    FIRST(0), SECOND(1), THIRD(2);
    private int value;

    NumberPosition(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
