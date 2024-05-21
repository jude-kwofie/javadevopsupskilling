package com.jude.stack;

import java.util.ArrayList;
import java.util.Map;
import java.util.Stack;
import java.util.StringTokenizer;

public class Postfix {

    Stack<String> stack;
    StringBuilder postfixExpression;
    Map<String, Integer> precedence = Map.of("-", 1, "+", 1,
            "*", 2,"/",2);
    public Postfix(){
        this.stack = new Stack<String>();
        this.postfixExpression = new StringBuilder();
    }
   public void parseString(String arithmeticExpression){
       for (int i=0; i<arithmeticExpression.length(); i++){

           String ari =  String.valueOf(arithmeticExpression.charAt(i));
           if(precedence.containsKey(ari) && stack.isEmpty()){
               stack.push(ari);
           } else if (precedence.containsKey(ari) && !stack.isEmpty()) {
               while (true){
                   String stackCurrent = stack.peek();
                   int stackCurrentPrecedence = precedence.get(stackCurrent);
                   int ariPrecedence = precedence.get(ari);
                   if (ariPrecedence <= stackCurrentPrecedence) {
                       postfixExpression.append(stack.pop());
                       if(stack.isEmpty()){
                           stack.push(ari);
                           break;
                       }
                   }else {
                       stack.push(ari);
                       break;
                   }
               }

           } else if(isNumeric(ari)){

               this.postfixExpression.append(ari);

           }else {
               System.out.println(" Is not arimatic expression");
               this.postfixExpression  = new StringBuilder(" ");
               return;
           }

        }

        while (!stack.isEmpty()){
            this.postfixExpression.append(stack.pop());
        }
    }

    public  void printPostFix(){
        System.out.println(stack.toString());
        System.out.println(this.postfixExpression);
    }

    public ArrayList<String> convertStringToToken(String value){
      StringTokenizer str =  new StringTokenizer( value, "+*-/");
      ArrayList<String> token =  new ArrayList<>();
      int counter = 0;
//        System.out.println(prev);
        while ( counter < value.length() && str.hasMoreTokens()){
            String ch = String.valueOf(value.charAt(counter));
            if(this.precedence.containsKey(ch)  ){
                token.add(str.nextToken());
                token.add(ch);

            };
            counter++;
        }
        if(str.hasMoreTokens()  ){
            token.add(str.nextToken());
        };
        System.out.print(counter);
            System.out.println(token);

        return  token;
//        prev.append(value.charAt(0));
//        for (int i=1; i<value.length(); i++){
//
//            if(isNumeric(prev)){}
//        }
    }

    private boolean isNumeric(String character) {
        try {
            Double.parseDouble(String.valueOf(character));
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }

}
