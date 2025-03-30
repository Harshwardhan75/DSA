import java.util.Scanner;

public class DynamicProgramming_ShapeTotalSquares {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] grid = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++)
                grid[i][j] = sc.nextInt();
        }

        System.out.println(TotalSquares(grid));
    }

    static int TotalSquares(int[][] grid){
        int n=grid.length;
        int m=grid[0].length;
        int[][] dp=new int[n][m];

        for(int i=0;i<n;i++)
            dp[i][0]=grid[i][0];
        for(int j=0;j<m;j++)
            dp[0][j]=grid[0][j];

        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++){
                if(grid[i][j]==1){
                    dp[i][j]=1+Math.min(dp[i-1][j],Math.min(dp[i][j-1], dp[i-1][j-1]));
                }   
                else{
                    dp[i][j]=0;
                }
            }
        }
        
        int sum = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                sum+=dp[i][j];
            }
        }

        return sum;
    }
}
