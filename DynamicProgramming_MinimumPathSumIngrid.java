import java.util.*;

public class DynamicProgramming_MinimumPathSumIngrid {
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

        System.out.println(Memoization_MinimPathSum(grid));
        System.out.println(Tabulation_MinimPathSum(grid));
        System.out.println(SpaceOptimization_MinimPathSum(grid));
    }

    static int SpaceOptimization_MinimPathSum(int[][] grid){
        int n=grid.length;
        int m=grid[0].length;
        int[] prev=new int[m];
        Arrays.fill(prev, (int)1e9);
        for(int r=0;r<n;r++){
            int[] curr=new int[m];
            for(int c=0;c<m;c++){
                if(r==0 && c==0)
                    curr[c]=grid[r][c];
                else{
                    int up = grid[r][c] + prev[c];
                    int left = c>0?grid[r][c]+curr[c-1]:Integer.MAX_VALUE;
                    curr[c]=Math.min(up, left);
                }
            }
            prev=curr;
        }
        return prev[m-1];
    }

    static int Tabulation_MinimPathSum(int[][] grid){
        int n=grid.length;
        int m=grid[0].length;
        int[][] dp=new int[n][m];

        for(int r=0;r<n;r++){
            for(int c=0;c<m;c++){
                if(r==0 && c==0)
                    dp[r][c]=grid[r][c];
                else{
                    int up=r>0?grid[r][c]+dp[r-1][c]:Integer.MAX_VALUE;
                    int left=c>0?grid[r][c]+dp[r][c-1]:Integer.MAX_VALUE;

                    dp[r][c]=Math.min(up, left);
                }
            }
        }

        return dp[n-1][m-1];
    }

    static int Memoization_MinimPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] dp = new int[n][m];
        for (int[] i : dp)
            Arrays.fill(i, -1);

        return solve(grid, n - 1, m - 1, dp);
    }

    static int solve(int[][] grid, int r, int c, int[][] dp) {
        if (r == 0 && c == 0)
            return grid[r][c];

        if (r < 0 || c < 0)
            return (int)1e9;

        if (dp[r][c] != -1)
            return dp[r][c];

        int up = grid[r][c] + solve(grid, r - 1, c, dp);
        int left = grid[r][c] + solve(grid, r, c - 1, dp);

        return dp[r][c] = Math.min(up, left);
    }
}
