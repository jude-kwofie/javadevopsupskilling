package com.jude.stack;

import java.util.ArrayList;
import java.util.Map;
import java.util.Stack;

public class Calculator {
    Stack<String> stack;
    String result;
    public Calculator(String expression){
        this.stack = new Stack<>();
        Postfix postfix = new Postfix(expression);
        ArrayList<String> postfixExpression = postfix.getPostfixExpression();

        Map<String, Integer> precedence = postfix.getPrecedence();
        for (String valueInPostfixExpression : postfixExpression){
            if(precedence.containsKey(valueInPostfixExpression) && stack.isEmpty()){
                stack.push(valueInPostfixExpression);
            }else if(precedence.containsKey(valueInPostfixExpression)){
                try {

                    Double operand1 = Double.valueOf(this.stack.pop());

                    Double operand2 = Double.valueOf(this.stack.pop());

                    String performedOperation = String.valueOf(this.performOperation(valueInPostfixExpression, operand1, operand2));
                    stack.push(performedOperation);
                }catch (Exception e){
                    return;
                }

            }else {
                stack.push(valueInPostfixExpression);
            }
        }
        if(stack.isEmpty()){
            return;
        }
        this.result = stack.pop();


    }
    public void printResult(){
        if(this.result == null){
            return;
        }
        System.out.println(this.result);
    }



    private Double performOperation(String operator, Double operand1, Double operand2) {
        return switch (operator) {
            case "+" -> operand1 + operand2;
            case "-" -> operand1 - operand2;
            case "*" -> operand1 * operand2;
            case "/" -> {
                if (operand2 == 0) {
                    throw new ArithmeticException("Division by zero is not allowed");
                }
                yield operand1 / operand2;
            }
            default -> throw new IllegalArgumentException("Invalid operator: " + operator);
        };
    }


}
