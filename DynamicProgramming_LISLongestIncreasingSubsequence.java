import java.util.*;

public class DynamicProgramming_LISLongestIncreasingSubsequence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        System.out.println(Memoization_LIS(arr));
        System.out.println(Tabulation_LIS(arr));
        System.out.println(SpaceOptimization_LIS(arr));
        System.out.println(Best_LIS(arr));
    }

    static int Best_LIS(int[] arr) {
        int n = arr.length;
        int[] dp = new int[n];
        int max = 1;
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            for (int prev = 0; prev < i; prev++) {
                if (arr[prev] < arr[i])
                    dp[i] = Math.max(dp[i], 1 + dp[prev]);
            }
            max = Math.max(max, dp[i]);

        }

        return max;
    }

    static int SpaceOptimization_LIS(int[] arr) {
        int n = arr.length;
        int[] next = new int[n + 1];

        for (int ind = n - 1; ind >= 0; ind--) {
            int[] curr = new int[n + 1];
            for (int prev = ind - 1; prev >= -1; prev--) {
                int nottake = next[prev + 1];
                int take = 0;
                if (prev == -1 || arr[prev] < arr[ind])
                    take = 1 + next[ind + 1];

                curr[prev + 1] = Math.max(take, nottake);
            }
            next = curr;
        }

        return next[-1 + 1];
    }

    static int Tabulation_LIS(int[] arr) {
        int n = arr.length;
        int[][] dp = new int[n + 1][n + 1];

        for (int ind = n - 1; ind >= 0; ind--) {
            for (int prev = ind - 1; prev >= -1; prev--) {
                int nottake = dp[ind + 1][prev + 1];
                int take = 0;
                if (prev == -1 || arr[prev] < arr[ind])
                    take = 1 + dp[ind + 1][ind + 1];

                dp[ind][prev + 1] = Math.max(take, nottake);
            }
        }

        return dp[0][-1 + 1];
    }

    static int Memoization_LIS(int[] arr) {
        int n = arr.length;
        int[][] dp = new int[n][n + 1];
        for (int[] i : dp)
            Arrays.fill(i, -1);

        return solve(arr, 0, -1, dp);
    }

    static int solve(int[] arr, int ind, int prev_ind, int[][] dp) {
        if (ind == arr.length)
            return 0;

        if (dp[ind][prev_ind + 1] != -1)
            return dp[ind][prev_ind + 1];

        int nottake = solve(arr, ind + 1, prev_ind, dp);
        int take = 0;

        if (prev_ind == -1 || arr[prev_ind] < arr[ind])
            take = 1 + solve(arr, ind + 1, ind, dp);

        return dp[ind][prev_ind + 1] = Math.max(take, nottake);
    }
}
