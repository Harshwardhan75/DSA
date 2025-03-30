import java.util.Arrays;
import java.util.Scanner;

public class DynamicProgramming_StocksBestTimeToBuyAndSell_V {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] prices = new int[n];
        for (int i = 0; i < n; i++)
            prices[i] = sc.nextInt();

        System.out.println(Memoization_MaxProfit(prices));
        System.out.println(Tabulation_MaxProfit(prices));
    }

    static int Tabulation_MaxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n + 2][2];
        dp[n][0] = dp[n][1] = 0;

        for (int ind = n - 1; ind >= 0; ind--) {
            for (int buy = 0; buy <= 1; buy++) {
                int profit = 0;

                if (buy == 1) {
                    int take = -prices[ind] + dp[ind + 1][0];
                    int nottake = 0 + dp[ind + 1][1];
                    profit = Math.max(take, nottake);
                } else {
                    int take = prices[ind] + dp[ind + 2][1];
                    int nottake = 0 + dp[ind + 1][0];
                    profit = Math.max(take, nottake);
                }
                dp[ind][buy] = profit;
            }
        }

        return dp[0][1];
    }

    static int Memoization_MaxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        for (int[] i : dp)
            Arrays.fill(i, -1);

        return solve(prices, 0, 1, dp);
    }

    static int solve(int[] prices, int ind, int buy, int[][] dp) {
        if (ind >= prices.length)
            return 0;

        if (dp[ind][buy] != -1)
            return dp[ind][buy];

        int profit = 0;

        if (buy == 1) {
            int take = -prices[ind] + solve(prices, ind + 1, 0, dp);
            int nottake = 0 + solve(prices, ind + 1, 1, dp);
            profit = Math.max(take, nottake);
        } else {
            int take = prices[ind] + solve(prices, ind + 2, 1, dp);
            int nottake = 0 + solve(prices, ind + 1, 0, dp);
            profit = Math.max(take, nottake);
        }

        return dp[ind][buy] = profit;
    }
}
