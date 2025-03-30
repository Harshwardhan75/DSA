import java.util.*;

public class DynamicProgramming_coinChangeII {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int target = 4;
        int[] coin = new int[n];
        for (int i = 0; i < n; i++)
            coin[i] = sc.nextInt();

        System.out.println(Memoization_coinChange(coin, target));
        System.out.println(Tabulation_coinChange(coin, target));
        System.out.println(SpaceOptimization_coinChange(coin, target));
    }

    static int SpaceOptimization_coinChange(int[] coin, int target) {
        int n = coin.length;
        int[] prev = new int[target + 1];
        for (int T = 0; T <= target; T++)
            prev[T] = T % coin[0] == 0 ? 1 : 0;

        for (int ind = 1; ind < n; ind++) {
            int[] curr = new int[target + 1];
            for (int T = 0; T <= target; T++) {
                int notpick = prev[T];
                int pick = 0;

                if (coin[ind] <= T)
                    pick = curr[T - coin[ind]];

                curr[T] = pick + notpick;
            }
            prev = curr;
        }
        return prev[target];
    }

    static int Tabulation_coinChange(int[] coin, int target) {
        int n = coin.length;
        int[][] dp = new int[n][target + 1];

        for (int T = 0; T <= target; T++)
            dp[0][T] = T % coin[0] == 0 ? 1 : 0;

        for (int ind = 1; ind < n; ind++) {
            for (int T = 0; T <= target; T++) {
                int notpick = dp[ind - 1][T];
                int pick = 0;
                if (coin[ind] <= T)
                    pick = dp[ind][T - coin[ind]];

                dp[ind][T] = pick + notpick;
            }
        }
        return dp[n - 1][target];
    }

    static int Memoization_coinChange(int[] coin, int target) {
        int n = coin.length;
        int[][] dp = new int[n][target + 1];

        for (int[] i : dp)
            Arrays.fill(i, -1);

        return solve(coin, n - 1, target, dp);
    }

    static int solve(int[] coin, int index, int T, int[][] dp) {
        if (index == 0)
            return T % coin[0] == 0 ? 1 : 0;

        if (dp[index][T] != -1)
            return dp[index][T];

        int notpick = solve(coin, index - 1, T, dp);
        int pick = 0;

        if (coin[index] <= T)
            pick = solve(coin, index, T - coin[index], dp);

        return dp[index][T] = pick + notpick;
    }
}
