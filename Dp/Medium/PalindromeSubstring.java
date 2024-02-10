
/*
 647. Palindromic Substrings
Medium

Given a string s, return the number of palindromic substrings in it.

A string is a palindrome when it reads the same backward as forward.

A substring is a contiguous sequence of characters within the string.

 

Example 1:

Input: s = "abc"
Output: 3
Explanation: Three palindromic strings: "a", "b", "c".
Example 2:

Input: s = "aaa"
Output: 6
Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".
 
*/

public class PalindromeSubstring {
    public static void main(String[] args) {
        String s= "aaaaa";
        int ans = CountSubstring(s);
        System.out.println(ans);
    }

    // private static int CountSubstring(String s) {
    //     int count=0;
    //    for(int i=0;i<s.length();i++)
    //    {
    //       for(int j=i;j<s.length();j++)
    //       {
    //         String ss=s.substring(i, j+1);
    //         if(isPlaindrome(ss)){
    //             count++;
    //         }
    //       }
    //    }

    //    return count;
    // }

   

    private static boolean isPlaindrome(String ss) {
            int lo=0;
            int hi=ss.length()-1;

            while(lo<hi){
                if(ss.charAt(lo)!=ss.charAt(hi)){
                    return false;
                }
                lo++;
                hi--;
            }
            return true;
    }

// T.C of this is O(N^3)  two for loops and one palindrome while loops


//better approach
// Dp approach




private static int CountSubstring(String s) {
    // TODO Auto-generated method stub
    boolean dp[][] = new boolean[s.length()][s.length()];
    int count=0;

    int n=s.length();

    for(int g=0;g<n;g++)
    {   
        for(int i=0,j=g;j<dp.length;i++,j++)
        {
                if(g==0){
                    dp[i][j]=true;

                }
                else if(g==1){
                    dp[i][j]=s.charAt(i)==s.charAt(j);
                }
                else{
                    if(s.charAt(i)==s.charAt(j)&&dp[i+1][j-1]){
                        dp[i][j]=true;
                    }
                    else dp[i][j]=false;
                }
                if(dp[i][j]){
                    count++;
                }
        }
    }

    

    return count;
}
}