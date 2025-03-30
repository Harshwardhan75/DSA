import java.util.*;
import javax.print.attribute.standard.RequestingUserName;

public class DynamicProgramming_MCMMinCostToCutTheStick {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int c = sc.nextInt();
        int[] cut = new int[n];
        for (int i = 0; i < n; i++)
            cut[i] = sc.nextInt();

        System.out.println(Memoization_MinimumCut(cut, c));
        System.out.println(Tabulation_MinimumCut(cut, c));
    }

    static int Tabulation_MinimumCut(int[] cut, int c) {
        int n = cut.length;
        int[] arr = new int[n + 2];
        for (int i = 0; i < n; i++)
            arr[i] = cut[i];
        arr[n] = c;
        Arrays.sort(arr);
        cut=arr;
        int[][] dp = new int[n + 2][n + 2];

        for (int i = n; i >= 1; i--) {
            for (int j = 1; j <= n; j++) {
                if (i > j)
                    continue;

                int min = Integer.MAX_VALUE;

                for (int ind = i; ind <= j; ind++) {
                    int cost = cut[j + 1] - cut[i - 1] + dp[i][ind - 1] + dp[ind + 1][j];
                    min = Math.min(min, cost);
                }

                dp[i][j] = min;
            }
        }

        return dp[1][n];
    }

    static int Memoization_MinimumCut(int[] cut, int c) {
        int n = cut.length;
        int[] arr = new int[n + 2];
        for (int i = 0; i < n; i++)
            arr[i] = cut[i];
        arr[n] = c;
        Arrays.sort(arr);
        int[][] dp = new int[n + 2][n + 2];
        for (int[] i : dp)
            Arrays.fill(i, -1);

        return solve(arr, 1, n, dp);
    }

    static int solve(int[] cut, int i, int j, int[][] dp) {
        if (i > j)
            return 0;

        if (dp[i][j] != -1)
            return dp[i][j];

        int min = Integer.MAX_VALUE;

        for (int ind = i; ind <= j; ind++) {
            int cost = cut[j + 1] - cut[i - 1] + solve(cut, i, ind - 1, dp) + solve(cut, ind + 1, j, dp);
            min = Math.min(min, cost);
        }

        return dp[i][j] = min;
    }
}
