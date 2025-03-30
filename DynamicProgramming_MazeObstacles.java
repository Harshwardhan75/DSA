import java.util.*;

public class DynamicProgramming_MazeObstacles {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int[][] grid=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                grid[i][j]=sc.nextInt();
            }
        }
        System.out.println(Memoization_UniquePath(grid));
        System.out.println(Tabulation_UniquePath(grid));
        System.out.println(SpaceOptimization_UniquePath(grid));
    }

    static int SpaceOptimization_UniquePath(int[][] grid){
        int n=grid.length;
        int m=grid[0].length;
        int[] prev=new int[m];

        for(int r=0;r<n;r++){
            int[] curr=new int[m];
            for(int c=0;c<m;c++){
                if(grid[r][c]==-1)
                    curr[c]=0;
                else if(r==0 && c==0)
                    curr[c]=1;
                else{
                    int up=prev[c];
                    int left = c>0?curr[c-1]:0;
                    curr[c]=up+left;
                }
            }
            prev=curr;
        }

        return prev[m-1];
    }

    static int Tabulation_UniquePath(int[][] grid){
        int n=grid.length;
        int m=grid[0].length;
        int[][] dp=new int[n][m];

        for(int r=0;r<n;r++){
            for(int c=0;c<m;c++){
                if(grid[r][c]==-1)
                    dp[r][c]=0;
                else if(r==0 && c==0)
                    dp[r][c]=1;
                else{
                    int up = r>0?dp[r-1][c]:0;
                    int left= c>0?dp[r][c-1]:0;
                    dp[r][c]=up+left;
                }
            }
        }

        return dp[n-1][m-1];
    }

    static int Memoization_UniquePath(int[][] grid){
        int n=grid.length;
        int m=grid[0].length;
        int[][] dp=new int[n][m];
        for(int[] i: dp)    Arrays.fill(i, -1);

        return solve(grid,n-1,m-1,dp);
    }

    static int solve(int[][] grid,int r,int c,int[][] dp){
        if(r>=0 && c>=0 && grid[r][c]==-1)
            return 0;
        
        if(r==0 && c==0)    return 1;

        if(r<0 || c<0)  return 0;

        if(dp[r][c]!=-1)    return dp[r][c];

        int up=solve(grid, r-1, c, dp);
        int left=solve(grid, r, c-1, dp);

        return dp[r][c]=up+left;
    }
}
