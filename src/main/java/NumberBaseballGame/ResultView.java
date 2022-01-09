package NumberBaseballGame;

enum OutputType {
    NEW_INPUT("���ڸ� �Է����ּ��� : "),
    RULE("���ڴ� 1���� 9���� ���� �ٸ� ���� �̷���� 3�ڸ��� ���� �Է� �����մϴ�."),
    USER_WIN("3���� ���ڸ� ��� �����̽��ϴ�! ���� ����"),
    RESTART_OR_QUIT("������ ���� �����Ϸ��� 1, �����Ϸ��� 2�� �Է��ϼ���.");

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
