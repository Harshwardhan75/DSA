import java.util.*;

public class DynamicProgramming_KnapsackZeroandOne {
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

        System.out.println(Memoization_Knapsack(wt, val, capacity));
        System.out.println(Tabulation_Knapsack(wt, val, capacity));
        System.out.println(SpaceOptimizationUsingTwoArray_Knapsack(wt, val, capacity));
        System.out.println(SpaceOptimizationUsingOneArray_Knapsack(wt, val, capacity));
    }

    static int SpaceOptimizationUsingOneArray_Knapsack(int[] wt, int[] val, int capacity) {
        int n = wt.length;
        int[] dp = new int[capacity + 1];

        for (int W = wt[0]; W <= capacity; W++)
            dp[W] = val[0];

        for (int i = 1; i < n; i++) {
            for (int W = capacity; W >=0; W--) {
                int notpick = dp[W];
                int pick = Integer.MIN_VALUE;
                if (wt[i] <= W)
                    pick = val[i] + dp[W - wt[i]];

                dp[W] = Math.max(pick, notpick);
            }
        }

        return dp[capacity];
    }

    static int SpaceOptimizationUsingTwoArray_Knapsack(int[] wt, int[] val, int capacity) {
        int n = wt.length;
        int[] prev = new int[capacity + 1];
        int[] curr = new int[capacity + 1];

        for (int W = wt[0]; W <= capacity; W++)
            prev[W] = val[0];

        for (int i = 1; i < n; i++) {
            for (int W = 0; W <= capacity; W++) {
                int notpick = prev[W];
                int pick = Integer.MIN_VALUE;
                if (wt[i] <= W)
                    pick = val[i] + prev[W - wt[i]];

                curr[W] = Math.max(pick, notpick);
            }
            prev = curr;
        }

        return prev[capacity];
    }

    static int Tabulation_Knapsack(int[] wt, int[] val, int capacity) {
        int n = wt.length;
        int[][] dp = new int[n][capacity + 1];

        for (int W = wt[0]; W <= capacity; W++)
            dp[0][W] = val[0];

        for (int i = 1; i < n; i++) {
            for (int W = 0; W <= capacity; W++) {
                int notpick = dp[i - 1][W];
                int pick = Integer.MIN_VALUE;
                if (wt[i] <= W)
                    pick = val[i] + dp[i - 1][W - wt[i]];
                dp[i][W] = Math.max(pick, notpick);
            }
        }

        return dp[n - 1][capacity];
    }

    static int Memoization_Knapsack(int[] wt, int[] val, int capacity) {
        int n = wt.length;
        int[][] dp = new int[n][capacity + 1];
        for (int[] i : dp)
            Arrays.fill(i, -1);

        return solve(wt, val, n - 1, capacity, dp);
    }

    static int solve(int[] wt, int[] val, int index, int W, int[][] dp) {
        if (index == 0) {
            if (wt[0] <= W)
                return val[0];
            return 0;
        }

        if (dp[index][W] != -1)
            return dp[index][W];

        int notpick = solve(wt, val, index - 1, W, dp);
        int pick = Integer.MIN_VALUE;

        if (wt[index] <= W)
            pick = val[index] + solve(wt, val, index - 1, W - wt[index], dp);

        return dp[index][W] = Math.max(pick, notpick);
    }
}
