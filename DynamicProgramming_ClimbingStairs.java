import java.util.*;

public class DynamicProgramming_ClimbingStairs {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();

        System.out.println(climbStairsMemoization(n));
        System.out.println(climbStairsTabulation(n));
        System.out.println(climbStairsSapceOptimization(n));
    }

    static int climbStairsSapceOptimization(int n){
        int prev=1,prev2=1;
        for(int i=2;i<=n;i++)
        {
            int curr=prev+prev2;
            prev2=prev;
            prev=curr;
        }
        return prev;
    }

    static int climbStairsTabulation(int n){
        int[] dp=new int[n+1];
        dp[0]=dp[1]=1;

        for(int i=2;i<=n;i++)
            dp[i]=dp[i-1]+dp[i-2];
        return dp[n];
    }

    static int climbStairsMemoization(int n){
        int[] dp=new int[n+1];
        Arrays.fill(dp, -1);
        return find(n,dp);
    }

    static int find(int n,int[] dp){
        if(n<=1)
            return dp[n]=1;
        
        if(dp[n]!=-1)
            return dp[n];
        
        return dp[n]=find(n-1, dp)+find(n-2, dp);
    }
}
