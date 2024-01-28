import java.util.Stack;

/**
 * PostFixToPrefix
 */
public class PostFixToPrefix {

    public static void main(String[] args) {
        String s= "ab*c+";
        System.out.println(PostToPrefix(s));
    }

    private static String PostToPrefix(String s) {
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
                  st.push(ch+v1+v2+"");  
            }
        }
        return st.peek();
    }
}