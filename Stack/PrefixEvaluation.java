import java.util.Stack;

/**
 * PrefixEvaluation
 */
public class PrefixEvaluation {

    public static void main(String[] args) {
        // In prefix we are travesing in exact opposite order
        
            String s="-+2/*6483";
            System.out.println(Valuation(s));
        
    }

    private static int Valuation(String s) {

        Stack<Integer> st =new Stack<>();
             for(int i=s.length()-1;i>=0;i--){
                char ch=s.charAt(i);

                if(Character.isDigit(ch)){
                    st.push(ch-'0');
                }
                else{
                    int v1=st.pop();
                    int v2=st.pop();
                    int ans=opaeration(v1, v2, ch);
                    st.push(ans);
                }
             } 

             return st.peek();
    }
    private static int opaeration(int v1, int v2, char ch) {
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