package StringCalculator;

class Operator {
    private String operator;

    public Operator(String operator) {
        this.operator = operator;
    }

    public int operate(Num1 num1, Num2 num2) {
        if (operator.equals("+"))
            return num1.getNum1() + num2.getNum2();

        if (operator.equals("-"))
            return num1.getNum1() - num2.getNum2();

        if (operator.equals("*"))
            return num1.getNum1() * num2.getNum2();

        if (operator.equals("/"))
            return num1.getNum1() / num2.getNum2();

        return 0;
    }
}
