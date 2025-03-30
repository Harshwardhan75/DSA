import java.util.*;

public class DynamicProgramming_FibonacciNumbers {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] dp=new int[n+1];
        Arrays.fill(dp,-1);

        System.out.println(fibonacci_Memoization(n,dp));
        System.out.println(fibonacci_Tabulation(n));
        System.out.println(fibonacci_SpaceOptimization(n));
    }

    static int fibonacci_SpaceOptimization(int n){
        int prev2=0;
        int prev=1;

        for(int i=2;i<=n;i++){
            int curr=prev+prev2;
            prev2=prev;
            prev=curr;
        }
        return prev;
    }

    static int fibonacci_Tabulation(int n){
        int[] dp=new int[n+1];
        dp[0]=0;
        dp[1]=1;
        for(int i=2;i<=n;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];
    }

    static int fibonacci_Memoization(int n,int[] dp){
        if(n<=1)
            return dp[n]=n;
        
        if(dp[n]!=-1)
            return dp[n];
        
        return dp[n]=fibonacci_Memoization(n-1, dp)+fibonacci_Memoization(n-2, dp);
    }
}
