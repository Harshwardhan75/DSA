import java.util.*;

public class DynamicProgramming_RodCutting {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] price=new int[n];
        for(int i=0;i<n;i++)
            price[i]=sc.nextInt();
        
        System.out.println(Memoization_RodCutting(price));
        System.out.println(Tabulation_RodCutting(price));
        System.out.println(SpaceOptimizationUsingTwoArray_RodCutting(price));
        System.out.println(SpaceOptimizationUsingOneArray_RodCutting(price));
    }

    static int SpaceOptimizationUsingOneArray_RodCutting(int[] price){
        int rodlen=price.length;
        int n=price.length;
        int[] dp = new int[rodlen+1];

        for(int t=0;t<=rodlen;t++)
            dp[t]=t*price[0];
        
        for(int index=1;index<n;index++){
            for(int t=0;t<=rodlen;t++){
                int nottake = dp[t];
                int take =Integer.MIN_VALUE;
                int rl=index+1;
                if(rl<=t)
                    take = price[index]+dp[t-rl];
                
                dp[t]=Math.max(take, nottake);
            }
        }
        return dp[rodlen];
    }

    static int SpaceOptimizationUsingTwoArray_RodCutting(int[] price){
        int rodlen=price.length;
        int n=price.length;
        int[] prev = new int[rodlen+1];

        for(int t=0;t<=rodlen;t++)
            prev[t]=t*price[0];
        
        for(int index=1;index<n;index++){
            int[] curr=new int[rodlen+1];
            for(int t=0;t<=rodlen;t++){
                int nottake = prev[t];
                int take =Integer.MIN_VALUE;
                int rl=index+1;
                if(rl<=t)
                    take = price[index]+curr[t-rl];
                
                curr[t]=Math.max(take, nottake);
            }
            prev=curr;
        }
        return prev[rodlen];
    }

    static int Tabulation_RodCutting(int[] price){
        int rodlen=price.length;
        int n=price.length;
        int[][] dp=new int[n][rodlen+1];
        for(int t=0;t<=rodlen;t++)
            dp[0][t]=t*price[0];
        
        for(int index=1;index<n;index++){
            for(int t=0;t<=rodlen;t++){
                int nottake=dp[index-1][t];
                int take=Integer.MIN_VALUE;
                int rl=index+1;
                if(rl<=t)
                    take = price[index]+dp[index][t-rl];
                
                dp[index][t]=Math.max(take, nottake);
            }
        }

        return dp[n-1][rodlen];
    }

    static int Memoization_RodCutting(int[] price){
        int rodlen=price.length;
        int n=price.length;
        int[][] dp=new int[n][rodlen+1];
        for(int[] i: dp)
            Arrays.fill(i, -1);
        
        return solve(price,n-1,rodlen,dp);
    }

    static int solve(int[] price,int index,int rodlen,int[][] dp){
        if(index==0){
            return price[0]*rodlen;
        }

        if(dp[index][rodlen]!=-1)
            return dp[index][rodlen];
        
        int nottake = solve(price,index-1,rodlen,dp);
        int take = Integer.MIN_VALUE;
        int rl=index+1;

        if(rl<=rodlen)
            take = price[index]+solve(price, index, rodlen-rl, dp);
        
        return dp[index][rodlen]=Math.max(take, nottake);
    }
}
