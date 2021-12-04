package StringCalculator;

import java.util.Scanner;

public class StringCalculator {
    private Scanner sc = new Scanner(System.in);
    Num1 num1;
    Num2 num2;
    Operator operator;

    public String calculate(String expression){

        String[] strings = expression.split(" ");

        for (String s : strings) {
            boolean isAllSet = setNumsAndOperator(s);
            Integer calculatedResult = caclulateTwoNumWhenAllSet(isAllSet);
            init(calculatedResult);
        }

        return ""+num1.getNum1();
    }

    private boolean setNumsAndOperator(String s) {
        if(num1 == null){
            num1 = new Num1(Integer.parseInt(s));
            return false;
        }

        if(operator == null){
            operator = new Operator(s);
            return false;
        }

        if(num2 == null){
            num2 = new Num2(Integer.parseInt(s));
            return true;
        }

        return false;
    }

    private Integer caclulateTwoNumWhenAllSet(boolean isAllSet){
        if(isAllSet)
            return operator.operate(num1, num2);

        return null;
    }

    private void init(Integer calculatedResult){
        if(calculatedResult != null){
            num1 = new Num1(calculatedResult);
            num2 = null;
            operator = null;
        }
    }
}



