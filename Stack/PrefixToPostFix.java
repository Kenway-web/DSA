import java.util.Stack;

public class PrefixToPostFix {
    public static void main(String[] args) {
        String s="*-A/BC-/AKL";
        System.out.println(ValPostToPreue(s));
    }

    private static String ValPostToPreue(String s) {
        
        Stack<String> st=new Stack<>();
        
        for(int i=s.length()-1;i>=0;i--)
        {
            char ch=s.charAt(i);

            if(Character.isDigit(ch)||Character.isAlphabetic(ch))
            {
                st.push(ch+"");
            } 
            else{
                 String v1=st.pop();
                String v2=st.pop();
              
                st.push(v1+v2+ch);
            }
        }
        return st.peek();
    }

}
