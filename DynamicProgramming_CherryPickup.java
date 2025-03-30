import java.util.*;

public class DynamicProgramming_CherryPickup {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] grid = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        System.out.println(Memoization_CherryPickup(grid));
        System.out.println(Tabulation_CherryPickup(grid));
    }

    static int Tabulation_CherryPickup(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][][] dp = new int[n][m][m];

        for (int j1 = 0; j1 < m; j1++) {
            for (int j2 = 0; j2 < m; j2++) {
                if (j1 == j2)
                    dp[n - 1][j1][j2] = grid[n - 1][j1];
                else
                    dp[n - 1][j1][j2] = grid[n - 1][j1] + grid[n - 1][j2];
            }
        }

        for (int i = n - 2; i >= 0; i--) {
            for (int j1 = 0; j1 < m; j1++) {
                for (int j2 = 0; j2 < m; j2++) {
                    int max = (int) -1e8;
                    for (int del1 = -1; del1 <= 1; del1++) {
                        for (int del2 = -1; del2 <= 1; del2++) {
                            if (j1 + del1 >= 0 && j1 + del1 < m && j2 + del2 >= 0 && j2 + del2 < m)
                                max = Math.max(max, dp[i + 1][j1 + del1][j2 + del2]);
                        }
                    }
                    if (j1 == j2)
                        dp[i][j1][j2] = max + grid[i][j1];
                    else
                        dp[i][j1][j2] = max + grid[i][j1] + grid[i][j2];
                }
            }
        }

        return dp[0][0][m - 1];
    }

    static int Memoization_CherryPickup(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][][] dp = new int[n][m][m];
        for (int[][] i : dp)
            for (int[] j : i)
                Arrays.fill(j, -1);

        return solve(grid, 0, 0, m - 1, dp);
    }

    static int solve(int[][] grid, int i, int j1, int j2, int[][][] dp) {
        int n = grid.length;
        int m = grid[0].length;
        if (j1 < 0 || j1 >= m || j2 < 0 || j2 >= m)
            return (int) -1e8;

        if (i == n - 1) {
            if (j1 == j2)
                return grid[i][j1];

            return grid[i][j1] + grid[i][j2];
        }

        if (dp[i][j1][j2] != -1)
            return dp[i][j1][j2];

        int max = 0;
        for (int del1 = -1; del1 <= 1; del1++) {
            for (int del2 = -1; del2 <= 1; del2++) {
                int cherry = solve(grid, i + 1, j1 + del1, j2 + del2, dp);
                max = Math.max(max, cherry);
            }
        }

        if (j1 == j2)
            return dp[i][j1][j2] = grid[i][j1] + max;
        else
            return dp[i][j1][j2] = grid[i][j1] + grid[i][j2] + max;
    }
}