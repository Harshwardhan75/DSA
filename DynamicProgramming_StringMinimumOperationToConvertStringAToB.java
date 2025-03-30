import java.util.*;

public class DynamicProgramming_StringMinimumOperationToConvertStringAToB {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String A=sc.next();
        String B=sc.next();

        System.out.println(minimumOperation(A,B));
    }

    static int minimumOperation(String A,String B){
        int n=A.length();
        int m=B.length();
        int[][] dp=Tabulation(A,B);

        return n+m-2*(dp[n][m]);
    }

    static int[][] Tabulation(String A,String B){
        char[] a=A.toCharArray();
        char[] b=B.toCharArray();
        int n=a.length;
        int m=b.length;

        int[][] dp=new int[n+1][m+1];
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(a[i-1]==b[j-1])
                    dp[i][j]=1+dp[i-1][j-1];
                else
                    dp[i][j]=Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }
        return dp;
    }
}
