import java.util.Stack;

public class PostFixEvaluation {
      public static void main(String[] args) {
            String s="264*8/+3-";
            System.out.println(Value(s));
      }

    private static int Value(String s) {
        
        Stack<Integer> st=new Stack<>();
        
        for(int i=0;i<s.length();i++)
        {
            char ch=s.charAt(i);

            if(Character.isDigit(ch))
            {
                st.push(ch-'0');
            } 
            else{
                int v2=st.pop();
                int v1=st.pop();
                int ans = opaeration(v2,v1,ch);
                st.push(ans);
            }
        }
        return st.peek();
    }

    private static int opaeration(int v2, int v1, char ch) {
        if(ch=='+'){
            return v2+v1;
        }
             
        else if(ch=='-'){
            return v1-v2;
        }
               
        else if(ch=='*'){
            return v2*v1;
        }
                
        else{
             return v1/v2;   
         }                   
    }
}
