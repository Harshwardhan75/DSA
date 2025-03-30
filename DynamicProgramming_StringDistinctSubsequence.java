import java.util.*;

public class DynamicProgramming_StringDistinctSubsequence {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String A=sc.next();
        String B=sc.next();

        System.out.println(Memoization_DistinctSubsequence1(A,B));
        System.out.println(Memoization_DistinctSubsequence2(A,B));
        System.out.println(Tabulation_DistinctSubsequence(A,B));
        System.out.println(SpaceOptimizationUsingTwoArray_DistinctSubsequence(A,B));
        System.out.println(SpaceOptimizationUsingOneArray_DistinctSubsequence(A,B));
    }

    static int SpaceOptimizationUsingOneArray_DistinctSubsequence(String A,String B){
        int n=A.length();
        int m=B.length();
        int[] dp=new int[m+1];
        dp[0]=1;
        char[] a= A.toCharArray();
        char[] b= B.toCharArray();

        for(int i=1;i<=n;i++){
            for(int j=m;j>0;j--){
                if(a[i-1]==b[j-1])
                    dp[j]=dp[j-1]+dp[j];
                else
                    dp[j]=dp[j];
            }
        }
        return dp[m];
    }
    static int SpaceOptimizationUsingTwoArray_DistinctSubsequence(String A,String B){
        int n=A.length();
        int m=B.length();
        int[] prev=new int[m+1];
        prev[0]=1;
        char[] a= A.toCharArray();
        char[] b= B.toCharArray();

        for(int i=1;i<=n;i++){
            int[] curr=new int[m+1];
            curr[0]=1;
            for(int j=1;j<=m;j++){
                if(a[i-1]==b[j-1])
                    curr[j]=prev[j-1]+prev[j];
                else
                    curr[j]=prev[j];
            }
            prev=curr;
        }
        return prev[m];
    }

    static int Tabulation_DistinctSubsequence(String A,String B){
        int n=A.length();
        int m=B.length();
        int[][] dp=new int[n+1][m+1];

        for(int i=0;i<=n;i++)
            dp[i][0]=1;
            
        char[] a=A.toCharArray();
        char[] b=B.toCharArray();
        
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(a[i-1]==b[j-1])
                    dp[i][j]=dp[i-1][j-1]+dp[i-1][j];
                else
                    dp[i][j]=dp[i-1][j];
            }
        }
        

        return dp[n][m];
    }

    static int Memoization_DistinctSubsequence1(String A,String B){
        int n=A.length();
        int m=B.length();
        int[][] dp=new int[n+1][m+1];
        for(int[] i: dp)    Arrays.fill(i, -1);

        return solve(A.toCharArray(),B.toCharArray(),n,m,dp);
    }

    static int solve(char[] A,char[] B,int i,int j,int[][] dp){
        if(j==0) return 1;
        if(i==0) return 0;

        if(dp[i][j]!=-1)
            return dp[i][j];
        
        if(A[i-1]==B[j-1]){
            return dp[i][j]=solve(A, B, i-1, j-1, dp)+solve(A, B, i-1, j, dp);
        }
        else{
            return dp[i][j]=solve(A, B, i-1, j, dp);
        }
    }
    
    static int Memoization_DistinctSubsequence2(String A,String B){
        int n=A.length();
        int m=B.length();
        int[][] dp=new int[n][m];
        for(int[] i: dp)    Arrays.fill(i, -1);

        return solve2(A.toCharArray(),B.toCharArray(),n-1,m-1,dp);
    }

    static int solve2(char[] A,char[] B,int i,int j,int[][] dp){
        if(j<0) return 1;
        if(i<0) return 0;

        if(dp[i][j]!=-1)
            return dp[i][j];
        
        if(A[i]==B[j]){
            return dp[i][j]=solve2(A, B, i-1, j-1, dp)+solve2(A, B, i-1, j, dp);
        }
        else{
            return dp[i][j]=solve2(A, B, i-1, j, dp);
        }
    }
}
