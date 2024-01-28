/**
 * PostfixEvaluationAndConversions
 */
import java.util.*;;

/*
 
Problem Url: https://www.geeksforgeeks.org/problems/infix-to-postfix-1587115620/1?utm_source=geeksforgeeks&utm_medium=ml_article_practice_tab&utm_campaign=article_practice_tab

*/


public class PostfixEvaluationAndConversions {

    public static void main(String[] args) {
        String s="a+b*(c^d-e)^(f+g*h)-i";

        System.out.println(calculate(s));
    }

    public static  String calculate(String s) {

        Stack<Character> operator = new Stack<>();
        Stack<String> operands = new Stack<>();

        for(int i=0;i<s.length();i++)
        {
            char ch=s.charAt(i);

            if(ch=='(')
                  {
                      operator.push(ch);
                  }
            else if(Character.isAlphabetic(ch)||Character.isDigit(ch)){
                operands.push(ch+""); // converting to int
            }      
            else if(ch==')'){
                while (!operator.isEmpty() && operator.peek() != '(') {
                    String v2 = operands.pop();
                    String v1 = operands.pop();
                    char opr = operator.pop();
                    operands.push(v1 + v2 + opr + "");
                }
                
                   operator.pop();
            }
            else if(ch=='+'||ch=='-'||ch=='*'||ch=='/'||ch=='^')
            {
                while(!operator.isEmpty()&&operator.peek()!='('&&precedence(ch)<=precedence(operator.peek())){
                    String v2=operands.pop();
                    String v1=operands.pop();
                       char opr=operator.pop();
                       
                    operands.push(v1+v2+opr+"");
                }
                operator.push(ch);
            }

        }   

        while(!operator.isEmpty())
                   {
                    String v2=operands.pop();
                    String v1=operands.pop();
                       char opr=operator.pop();      
                    operands.push(v1+v2+opr+"");
                   }  
            
        return operands.peek().toString();
    }

    public static int precedence(char ch)
    {
        if(ch=='+') return 1;
        else if(ch=='-') return 1; 
        else if(ch=='*') return 2;
        else return 2;
    }

   
}


