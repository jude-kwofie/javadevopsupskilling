package com.jude.stack;

import java.util.*;

public class Postfix {

    final private Stack<String> stack;
    final private ArrayList<String> postfixExpression;
    private final Map<String, Integer> precedence = Map.of("-", 1, "+", 1, "*", 2, "/", 2);
    ArrayList<String> parsedExpression = new ArrayList<>();
    public Postfix(String arithmeticExpression) {
        this.stack = new Stack<>();
        this.postfixExpression = new ArrayList<>();

        this.parseString(arithmeticExpression);


    }

    public Map<String,Integer> getPrecedence(){
        return this.precedence;
    }
    public ArrayList<String> getPostfixExpression(){
        return this.postfixExpression;
    }

    public void parseString(String arithmeticExpression) {
        ArrayList<String> parsedExpression = this.tokenizeExpression(arithmeticExpression);
        for (String token : parsedExpression) {

            if (precedence.containsKey(token)) {
                while (!stack.isEmpty() && precedence.get(token) <= precedence.get(stack.peek())) {
                    postfixExpression.add(stack.pop());
                }
                stack.push(token);
            } else if (isNumeric(token)) {
                postfixExpression.add(token);
            } else {
                System.out.println("Invalid token in arithmetic expression: " + token);
                this.postfixExpression.clear();
                return ;
            }
        }

        while (!stack.isEmpty()) {
            postfixExpression.add(stack.pop());
        }
    }

    public void printPostFix() {
        System.out.println(this.postfixExpression);
    }

    public ArrayList<String> tokenizeExpression(String expression) {
        StringBuilder operandBuilder = new StringBuilder();
        ArrayList<String> tokens = new ArrayList<>();
        for(int i=0; i<expression.length(); i++){
            String valueOf = String.valueOf(expression.charAt(i));
            if (this.precedence.containsKey(valueOf) && operandBuilder.isEmpty()) {

                operandBuilder.append(valueOf);
            } else if(this.precedence.containsKey(valueOf)){

                tokens.add(String.valueOf(operandBuilder));
                tokens.add(valueOf);
                operandBuilder = new StringBuilder();
            }  else {

                operandBuilder.append(valueOf);
            }
        }

        tokens.add(String.valueOf(operandBuilder));

        return  tokens;
    }

    private boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }


}
