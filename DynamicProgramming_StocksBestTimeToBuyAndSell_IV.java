import java.util.*;

public class DynamicProgramming_StocksBestTimeToBuyAndSell_IV {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] prices = new int[n];
        for (int i = 0; i < n; i++)
            prices[i] = sc.nextInt();

        Solution1 s1 = new Solution1();
        Solution2 s2 = new Solution2();

        System.out.println(s1.Memoization_MaxProfit(prices, k));
        System.out.println(s1.Tabulation_MaxProfit(prices, k));
        System.out.println(s1.SpaceOptimization_MaxProfit(prices, k));
        System.out.println();
        System.out.println(s2.Memoization_MaxProfit(prices, k));
        System.out.println(s2.Tabulation_MaxProfit(prices, k));
        System.out.println(s2.SpaceOptimization_MaxProfit(prices, k));
    }

    static class Solution2 {

        int SpaceOptimization_MaxProfit(int[] price,int k){
            int n=price.length;
            int[] ahead=new int[2*k+1];
            for (int ind = n - 1; ind >= 0; ind--) {
                int[] curr=new int[2*k+1];

                for (int tranNo = 2 * k - 1; tranNo >= 0; tranNo--) {
                    int profit = 0;

                    if (tranNo % 2 == 0) {// Buy
                        int take = -price[ind] + ahead[tranNo + 1];
                        int nottake = ahead[tranNo];
                        profit = Math.max(take, nottake);
                    } else {// Sell
                        int take = price[ind] + ahead[tranNo + 1];
                        int nottake = ahead[tranNo];
                        profit = Math.max(take, nottake);
                    }

                    curr[tranNo] = profit;
                }
                ahead=curr;
            }

            return ahead[0];
        }

        int Tabulation_MaxProfit(int[] price, int k) {
            int n = price.length;
            int[][] dp = new int[n+1][2 * k + 1];

            for (int ind = n - 1; ind >= 0; ind--) {
                for (int tranNo = 2 * k - 1; tranNo >= 0; tranNo--) {
                    int profit = 0;

                    if (tranNo % 2 == 0) {// Buy
                        int take = -price[ind] + dp[ind + 1][tranNo + 1];
                        int nottake = dp[ind + 1][tranNo];
                        profit = Math.max(take, nottake);
                    } else {// Sell
                        int take = price[ind] + dp[ind + 1][tranNo + 1];
                        int nottake = dp[ind + 1][tranNo];
                        profit = Math.max(take, nottake);
                    }

                    dp[ind][tranNo] = profit;
                }
            }

            return dp[0][0];
        }

        int Memoization_MaxProfit(int[] price, int k) {
            int n = price.length;
            int[][] dp = new int[n][2 * k];
            for (int[] i : dp)
                Arrays.fill(i, -1);
            return solve(price, 0, 0, k, dp);
        }

        int solve(int[] price, int ind, int tranNo, int k, int[][] dp) {
            if (ind == price.length || tranNo == 2 * k)
                return 0;

            if (dp[ind][tranNo] != -1)
                return dp[ind][tranNo];

            int profit = 0;

            if (tranNo % 2 == 0) {// Buy
                int take = -price[ind] + solve(price, ind + 1, tranNo + 1, k, dp);
                int nottake = solve(price, ind + 1, tranNo, k, dp);
                profit = Math.max(take, nottake);
            } else {// Sell
                int take = price[ind] + solve(price, ind + 1, tranNo + 1, k, dp);
                int nottake = solve(price, ind + 1, tranNo, k, dp);
                profit = Math.max(take, nottake);
            }

            return dp[ind][tranNo] = profit;
        }
    }

    static class Solution1 {
        int SpaceOptimization_MaxProfit(int[] prices, int k) {
            int n = prices.length;
            int[][] after = new int[2][k + 1];

            for (int ind = n - 1; ind >= 0; ind--) {
                int[][] curr = new int[2][k + 1];
                for (int buy = 0; buy <= 1; buy++) {
                    for (int cap = 1; cap <= k; cap++) {
                        int profit = 0;

                        if (buy == 1) {
                            int take = -prices[ind] + after[0][cap];
                            int nottake = 0 + after[1][cap];
                            profit = Math.max(take, nottake);
                        } else {
                            int take = prices[ind] + after[1][cap - 1];
                            int nottake = 0 + after[0][cap];
                            profit = Math.max(take, nottake);
                        }

                        curr[buy][cap] = profit;
                    }
                }
                after = curr;
            }

            return after[1][k];
        }

        int Tabulation_MaxProfit(int[] prices, int k) {
            int n = prices.length;
            int[][][] dp = new int[n + 1][2][k + 1];

            for (int ind = n - 1; ind >= 0; ind--) {
                for (int buy = 0; buy <= 1; buy++) {
                    for (int cap = 1; cap <= k; cap++) {
                        int profit = 0;

                        if (buy == 1) {
                            int take = -prices[ind] + dp[ind + 1][0][cap];
                            int nottake = 0 + dp[ind + 1][1][cap];
                            profit = Math.max(take, nottake);
                        } else {
                            int take = prices[ind] + dp[ind + 1][1][cap - 1];
                            int nottake = 0 + dp[ind + 1][0][cap];
                            profit = Math.max(take, nottake);
                        }

                        dp[ind][buy][cap] = profit;
                    }
                }
            }

            return dp[0][1][k];
        }

        int Memoization_MaxProfit(int[] prices, int k) {
            int n = prices.length;
            int[][][] dp = new int[n][2][k];
            for (int[][] i : dp) {
                for (int[] j : i)
                    Arrays.fill(j, -1);
            }

            return solve(prices, 0, 1, k - 1, dp);
        }

        static int solve(int[] prices, int ind, int buy, int cap, int[][][] dp) {
            if (ind == prices.length || cap == -1)
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
}
