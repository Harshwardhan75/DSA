import java.util.Scanner;

public class DynamicProgramming_StringLongestPalindromicSubsequence {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.next();

        System.out.println(longestPalindrome(s));
    }

    static int longestPalindrome(String s){
        String reverse = new StringBuilder(s).reverse().toString();
        int n=s.length();
        char[] A=s.toCharArray();
        char[] B=reverse.toCharArray();

        int[][] dp=new int[n+1][n+1];
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                if(A[i-1]==B[j-1]){
                    dp[i][j]=1+dp[i-1][j-1];
                }
                else{
                    dp[i][j]=Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[n][n];
    }
    
}
