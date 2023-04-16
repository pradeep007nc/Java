package practice;

import java.util.*;
class StackCheckValidity {

    public static boolean checkExpression(String input){
        try {
            Stack<Character> stack = new Stack<>();
            char val;
            for (int i = 0; i < input.length(); i++) {
                if (input.charAt(i) == '[' || input.charAt(i) == '{' || input.charAt(i) == '(') {
                    stack.push(input.charAt(i));
                } else if (input.charAt(i) == ']' || input.charAt(i) == '}' || input.charAt(i) == ')') {
                    if (input.charAt(i) == ')') {
                        val = stack.pop();
                        if (val != '(') {
                            return false;
                        }
                    } else if (input.charAt(i) == ']') {
                        val = stack.pop();
                        if (val != '[') {
                            return false;
                        }
                    } else if (input.charAt(i) == '}') {
                        val = stack.pop();
                        if (val != '{') {
                            return false;
                        }
                    }
                }
            }
        }catch (Exception e){
            return false;
        }


        if(input.length()%2==0){
            return true;
        }
        return false;
    }

    public static void main(String []argh)
    {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String input=sc.next();
            boolean ans=checkExpression(input);
            if (ans) {
                System.out.println("true");
            }else{
                System.out.println("false");
            }
        }
    }
}


