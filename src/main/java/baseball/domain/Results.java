package baseball.domain;

public class Results {

    int ballCount;
    int strikeCount;

    public Results(int ballCount, int strikeCount) {
        this.ballCount = ballCount;
        this.strikeCount = strikeCount;
    }

    @Override
    public String toString() {
        String string = "";

        if (ballCount > 0) {
            string += ballCount + "∫º";
        }

        if (ballCount > 0 && strikeCount > 0) {
            string += " ";
        }

        if (strikeCount > 0) {
            string += strikeCount + "Ω∫∆Æ∂Û¿Ã≈©";
        }

        if (string.equals("")) {
            string += "≥¥ΩÃ";
        }
        return string;
    }

    public boolean is3strike() {
        return strikeCount == 3;
    }
}
