import java.util.*;

public class DynamicProgramming_MinimumCoinI {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int amount=sc.nextInt();
        int[] coin=new int[n];

        for(int i=0;i<n;i++)
            coin[i]=sc.nextInt();
        
        System.out.println(Memoization_MinimumCoin(coin,amount));
        System.out.println(Tabulation_MinimumCoin(coin,amount));
        System.out.println(SpaceOptimization_MinimumCoin(coin,amount));
    }

    static int SpaceOptimization_MinimumCoin(int[] coin,int amount){
        int n=coin.length;
        int[] prev=new int[amount+1];
        for(int T=0;T<=amount;T++){
            if(T%coin[0]==0)
                prev[T]=T/coin[0];
            else    
                prev[T]=(int)1e8;
        }

        for(int index=1;index<n;index++){
            int[] curr=new int[amount+1];
            for(int T=0;T<=amount;T++){
                int nottake = prev[T];
                int take=Integer.MAX_VALUE;
                if(coin[index]<=T)
                    take = 1+curr[T-coin[index]];
                
                curr[T]=Math.min(take, nottake);
            }
            prev=curr;
        }
        return prev[amount];
    }

    static int Tabulation_MinimumCoin(int[] coin,int amount){
        int n=coin.length;
        int[][] dp=new int[n][amount+1];
        for(int T=0;T<=amount;T++){
            if(T%coin[0]==0)
                dp[0][T]=T/coin[0];
            else
                dp[0][T]=(int)1e8;
        }

        for(int index=1;index<n;index++){
            for(int T=0;T<=amount;T++){
                int nottake = dp[index-1][T];
                int take=Integer.MAX_VALUE;
                if(coin[index]<=T)
                    take = 1 + dp[index][T-coin[index]];
                
                dp[index][T]=Math.min(take, nottake);
            }
        }

        return dp[n-1][amount];
    }

    static int Memoization_MinimumCoin(int[] coin,int amount){
        int n=coin.length;
        int[][] dp=new int[n][amount+1];
        for(int[] i: dp)
            Arrays.fill(i, -1);
        
        return solve(coin,n-1,amount,dp);
    }

    static int solve(int[] coin,int index,int amount,int[][] dp){
        if(index==0){
            if(amount%coin[0]==0)
                return amount/coin[0];
            
            return (int)1e8;
        }

        if(dp[index][amount]!=-1)
            return dp[index][amount];

        int nottake=solve(coin, index-1, amount, dp);
        int take = Integer.MAX_VALUE;

        if(coin[index]<=amount)
            take = 1+solve(coin, index, amount-coin[index], dp);

        return dp[index][amount]=Math.min(take, nottake);
    }
}
