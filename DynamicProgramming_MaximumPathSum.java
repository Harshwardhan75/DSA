import java.util.*;

public class DynamicProgramming_MaximumPathSum {
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

        System.out.println(Memoization_MaxPathSum(grid));
        System.out.println(Tabulation_MaxPathSum(grid));
        System.out.println(SpaceOptimization_MaxPathSum(grid));
    }

    static int SpaceOptimization_MaxPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[] prev = new int[m];
        
        for (int i = 0; i < m; i++)
        prev[i] = grid[0][i];
        
        for (int i = 1; i < n; i++) {
            int[] curr = new int[m];
            for (int j = 0; j < m; j++) {
                int left = (int) -(1e8);
                int up = (int) -(1e8);
                int right = (int) -(1e8);

                if (j > 0)
                    left = grid[i][j] + prev[j - 1];

                up = grid[i][j] + prev[j];

                if (j + 1 < m)
                    right = grid[i][j] + prev[j + 1];

                curr[j] = Math.max(up, Math.max(left, right));
            }
            prev = curr;
        }
        int max = 0;

        for (int i = 0; i < m; i++)
            max = Math.max(max, prev[i]);

        return max;
    }

    static int Tabulation_MaxPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] dp = new int[n][m];

        for (int i = 0; i < m; i++)
            dp[0][i] = grid[0][i];

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int left = (int) -(1e8);
                int up = (int) -(1e8);
                int right = (int) -(1e8);

                if (j > 0)
                    left = grid[i][j] + dp[i - 1][j - 1];

                up = grid[i][j] + dp[i - 1][j];

                if (j + 1 < m)
                    right = grid[i][j] + dp[i - 1][j + 1];

                dp[i][j] = Math.max(up, Math.max(left, right));
            }
        }
        int max = 0;

        for (int i = 0; i < m; i++)
            max = Math.max(max, dp[n - 1][i]);

        return max;
    }

    static int Memoization_MaxPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[][] dp = new int[n][m];
        for (int[] i : dp)
            Arrays.fill(i, -1);

        int max = 0;
        for (int i = 0; i < m; i++) {
            max = Math.max(max, solve(grid, n - 1, i, dp));
        }
        return max;
    }

    static int solve(int[][] grid, int r, int c, int[][] dp) {
        int n = grid.length;
        int m = grid[0].length;

        if (c < 0 || c >= m)
            return (int) -1e8;
        if (r == 0)
            return grid[r][c];

        if (r < 0 || c < 0)
            return (int) -1e8;

        int left = grid[r][c] + solve(grid, r - 1, c - 1, dp);
        int up = grid[r][c] + solve(grid, r - 1, c, dp);
        int right = grid[r][c] + solve(grid, r - 1, c + 1, dp);

        return dp[r][c] = Math.max(left, Math.max(up, right));
    }
}
