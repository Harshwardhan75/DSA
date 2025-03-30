import java.util.*;

public class DynamicProgramming_StocksBestTimeToBuyAndSell_III {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] prices = new int[n];
        for (int i = 0; i < n; i++)
            prices[i] = sc.nextInt();

        System.out.println(Memoization_MaxProfit(prices));
        System.out.println(Tabulation_MaxProfit(prices));
        System.out.println(SpaceOptimization_MaxProfit(prices));
    }

    static int SpaceOptimization_MaxProfit(int[] prices){
        int n = prices.length;
        int[][] after = new int[2][3];

        for (int ind = n - 1; ind >= 0; ind--) {
            int[][] curr=new int[2][3];
            for (int buy = 0; buy <= 1; buy++) {
                for (int cap = 1; cap <= 2; cap++) {
                    int profit = 0;

                    if (buy == 1) {
                        int take = -prices[ind] + after[0][cap];
                        int nottake = 0 + after[1][cap];
                        profit = Math.max(take, nottake);
                    } else {
                        int take = prices[ind] + after[1][cap-1];
                        int nottake = 0 + after[0][cap];
                        profit = Math.max(take, nottake);
                    }

                    curr[buy][cap] = profit;
                }
                after = curr;
            }
        }

        return after[1][2];
    }

    static int Tabulation_MaxProfit(int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n + 1][2][3];

        for (int ind = n - 1; ind >= 0; ind--) {
            for (int buy = 0; buy <= 1; buy++) {
                for (int cap = 1; cap <= 2; cap++) {
                    int profit = 0;

                    if (buy == 1) {
                        int take = -prices[ind] + dp[ind+1][0][cap];
                        int nottake = 0 + dp[ind+1][1][cap];
                        profit = Math.max(take, nottake);
                    } else {
                        int take = prices[ind] + dp[ind+1][1][cap-1];
                        int nottake = 0 + dp[ind+1][0][cap];
                        profit = Math.max(take, nottake);
                    }

                    dp[ind][buy][cap] = profit;
                }
            }
        }

        return dp[0][1][2];
    }

    static int Memoization_MaxProfit(int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n][2][3];
        for (int[][] i : dp) {
            for (int[] j : i)
                Arrays.fill(j, -1);
        }

        return solve(prices, 0, 1, 2, dp);
    }

    static int solve(int[] prices, int ind, int buy, int cap, int[][][] dp) {
        if (ind == prices.length || cap == 0)
            return 0;

        if (dp[ind][buy][cap] != -1)
            return dp[ind][buy][cap];

        int profit = 0;

        if (buy == 1) {
            int take = -prices[ind] + solve(prices, ind + 1, 0, cap, dp);
            int nottake = 0 + solve(prices, ind + 1, 1, cap, dp);
            profit = Math.max(take, nottake);
        } else {
            int take = prices[ind] + solve(prices, ind + 1, 1, cap - 1, dp);
            int nottake = 0 + solve(prices, ind + 1, 0, cap, dp);
            profit = Math.max(take, nottake);
        }

        return dp[ind][buy][cap] = profit;
    }
}
