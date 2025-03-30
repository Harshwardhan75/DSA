import java.util.*;

public class DynamicProgramming_MCMMatrixChainMultiplication {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        System.out.println(Memoization_MCM(arr));
        System.out.println(Tabulation_MCM(arr));
    }

    static int Memoization_MCM(int[] arr) {
        int n = arr.length;
        int[][] dp = new int[n][n];
        for (int[] i : dp)
            Arrays.fill(i, -1);

        return solve(arr, 1, n - 1, dp);
    }

    static int solve(int[] arr, int i, int j, int[][] dp) {
        if (i == j)
            return 0;


        if(dp[i][j]!=-1)
            return dp[i][j];

        int minSteps = (int) 1e8;

        for (int k = i; k < j; k++) {
            int step = (arr[i - 1] * arr[k] * arr[j]) +
                    solve(arr, i, k, dp) +
                    solve(arr, k + 1, j, dp);

            minSteps=Math.min(minSteps, step);
        }
        return dp[i][j]=minSteps;
    }

    static int Tabulation_MCM(int[] arr){
        int n=arr.length;
        int[][] dp=new int[n][n];

        for(int i=0;i<n;i++)
            dp[i][i]=0;
        
        for(int i=n-1;i>=1;i--){
            for(int j=i+1;j<=n-1;j++){
                int minSteps=(int)1e8;

                for(int k=i;k<j;k++){
                    int step=(arr[i-1]*arr[k]*arr[j])+dp[i][k]+dp[k+1][j];
                    minSteps=Math.min(minSteps, step);
                }

                dp[i][j]=minSteps;
            }
        }

        return dp[1][n-1];
    }
}
