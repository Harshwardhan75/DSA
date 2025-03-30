import java.util.*;

public class DynamicProgramming_UnboundedKnapsack {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int capacity = sc.nextInt();
        int[] wt = new int[n];
        int[] val = new int[n];

        for (int i = 0; i < n; i++)
            wt[i] = sc.nextInt();
        for (int i = 0; i < n; i++)
            val[i] = sc.nextInt();

        System.out.println(Memoization_unboundKnapsack(val, wt, capacity));
        System.out.println(Tabulation_unboundKnapsack(val, wt, capacity));
        System.out.println(SpaceOptimizationUsingTwoArray_unboundKnapsack(val,wt,capacity));
        System.out.println(SpaceOptimizationUsingOneArray_unboundKnapsack(val,wt,capacity));
    }

    static int SpaceOptimizationUsingOneArray_unboundKnapsack(int[] val, int[] wt, int capacity) {
        int n = val.length;
        int[] prev = new int[capacity + 1];
        for (int W = 0; W <= capacity; W++) {
            prev[W] = (W / wt[0]) * val[0];
        }

        for (int index = 1; index < n; index++) {
            for (int W = capacity; W >=0; W--) {
                int nottake = prev[W];
                int take = 0;
                if (wt[index] <= W)
                    take = prev[W - wt[index]];

                prev[W] = Math.max(nottake, take);
            }
        }
        return prev[capacity];
    }

    static int SpaceOptimizationUsingTwoArray_unboundKnapsack(int[] val, int[] wt, int capacity) {
        int n = val.length;
        int[] prev = new int[capacity + 1];
        for (int W = 0; W <= capacity; W++) {
            prev[W] = (W / wt[0]) * val[0];
        }

        for (int index = 1; index < n; index++) {
            int[] curr = new int[capacity + 1];
            for (int W = 0; W <= capacity; W++) {
                int nottake = prev[W];
                int take = 0;
                if (wt[index] <= W)
                    take = curr[W - wt[index]];

                curr[W] = Math.max(nottake, take);
            }
            prev = curr;
        }
        return prev[capacity];
    }

    static int Tabulation_unboundKnapsack(int[] val, int[] wt, int capacity) {
        int n = val.length;
        int[][] dp = new int[n][capacity + 1];
        for (int W = 0; W <= capacity; W++) {
            dp[0][W] = (W / wt[0]) * val[0];
        }

        for (int index = 1; index < n; index++) {
            for (int W = 0; W <= capacity; W++) {
                int nottake = dp[index - 1][W];
                int take = 0;
                if (wt[index] <= W)
                    take = dp[index][W - wt[index]];

                dp[index][W] = Math.max(take, nottake);
            }
        }

        return dp[n - 1][capacity];
    }

    static int Memoization_unboundKnapsack(int[] val, int[] wt, int capacity) {
        int n = wt.length;
        int[][] dp = new int[n][capacity + 1];
        for (int[] i : dp)
            Arrays.fill(i, -1);

        return solve(val, wt, n - 1, capacity, dp);
    }

    static int solve(int[] val, int[] wt, int index, int W, int[][] dp) {
        if (index == 0) {
            return (W / wt[0]) * val[0];
        }

        if (dp[index][W] != -1)
            return dp[index][W];

        int nottake = solve(val, wt, index - 1, W, dp);
        int take = 0;
        if (wt[index] <= W)
            take = solve(val, wt, index, W - wt[index], dp);

        return dp[index][W] = Math.max(take, nottake);
    }
}
