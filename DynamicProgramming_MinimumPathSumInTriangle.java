import java.util.*;

public class DynamicProgramming_MinimumPathSumInTriangle {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[][] grid=new int[n][];

        for(int i=0;i<n;i++){
            int[] arr=new int[i+1];
            for(int j=0;j<arr.length;j++)
                arr[j]=sc.nextInt();
            grid[i]=arr;
        }

        System.out.println(Memoization_MinimumPathSum(grid));
        System.out.println(Tabulation_MinimumPathSum(grid));
        System.out.println(SpaceOptimization_MinimumPathSum(grid));
    }

    static int SpaceOptimization_MinimumPathSum(int[][] grid){
        int n=grid.length;
        int[] prev=new int[n];
        for(int j=0;j<n;j++)
            prev[j]=grid[n-1][j];
        
        for(int r=n-2;r>=0;r--){
            int[] curr=new int[n];
            for(int c=r;c>=0;c--){
                int down =grid[r][c]+ prev[c];
                int daigonal =grid[r][c]+ prev[c+1];

                curr[c]=Math.min(down, daigonal);
            }
            prev=curr;
        }

        return prev[0];
    }

    static int Tabulation_MinimumPathSum(int[][] grid){
        int n=grid.length;
        int[][] dp=new int[n][n];
        
        for(int j=0;j<n;j++)
            dp[n-1][j]=grid[n-1][j];
        
        for(int r=n-2;r>=0;r--){
            for(int c=r;c>=0;c--){
                int down=grid[r][c]+dp[r+1][c];
                int daigonal=grid[r][c]+dp[r+1][c+1];

                dp[r][c]=Math.min(down, daigonal);
            }
        }

        return dp[0][0];
    }

    static int Memoization_MinimumPathSum(int[][] grid){
        int n=grid.length;
        int[][] dp=new int[n][n];
        for(int[] i: dp)    Arrays.fill(i, -1);

        return solve(grid,0,0,dp);
    }

    static int solve(int[][] grid,int r,int c,int[][] dp){
        int n=grid.length;
        if(r==n-1)
            return grid[r][c];
        
        if(dp[r][c]!=-1)
            return dp[r][c];
        
        int down=grid[r][c]+solve(grid, r+1, c, dp);
        int daigonal=grid[r][c]+solve(grid, r+1, c+1, dp);

        return dp[r][c]=Math.min(down, daigonal);
    }
}
