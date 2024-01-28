import java.util.Stack;

/**
 * PostFixToInfix
 */
public class PostFixToInfix {

    public static void main(String[] args) {
        String s= "ab*c+";
        System.out.println(PostToInfix(s));
    }

    private static String PostToInfix(String s) {

        Stack<String> st=new Stack<>();
     
        for(int i=0;i<s.length();i++)
        {
            char ch=s.charAt(i);
            if(Character.isDigit(ch)||Character.isAlphabetic(ch)){
                    st.push(ch+"");
            }
            else{
                  String v2=st.pop();
                  String v1=st.pop();
                  st.push("("+v1+ch+v2+")");  
            }
        }
        return st.peek();
    }
}