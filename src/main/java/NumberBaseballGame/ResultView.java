package NumberBaseballGame;

enum OutputType {
    NEW_INPUT("숫자를 입력해주세요 : "),
    RULE("숫자는 1부터 9까지 서로 다른 수로 이루어진 3자리의 수만 입력 가능합니다."),
    USER_WIN("3개의 숫자를 모두 맞히셨습니다! 게임 종료"),
    RESTART_OR_QUIT("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

    private String message;

    OutputType(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}

public class ResultView {

    public void print(String message) {
        System.out.print(message);
    }

    public void println(String message) {
        System.out.println(message);
    }

    public void print(OutputType output) {
        if (output == OutputType.NEW_INPUT) {
            print(output.getMessage());
            return;
        }

        println(output.getMessage());
    }
}
