import java.util.*;

public class DynamicProgramming_MCMBurstBalloon {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        System.out.println(Memoization_MaxCoin(arr));
        System.out.println(Tabulation_MaxCoin(arr));
    }

    static int Tabulation_MaxCoin(int[] arr) {
        int n = arr.length;
        int[] arr1 = new int[n + 2];
        for (int i = 0; i < n; i++)
            arr1[i + 1] = arr[i];

        arr1[0] = arr1[n + 1] = 1;
        arr = arr1;
        int[][] dp = new int[n + 2][n + 2];

        for (int i = n; i >= 1; i--) {
            for (int j = 1; j <= n; j++) {

                if(i>j) continue;
                
                int max = Integer.MIN_VALUE;

                for (int ind = i; ind <= j; ind++) {
                    int cost = (arr[i - 1] * arr[ind] * arr[j + 1])+dp[i][ind-1]+dp[ind+1][j];

                    max = Math.max(max, cost);
                }

                dp[i][j] = max;
            }
        }

        return dp[1][n];
    }

    static int Memoization_MaxCoin(int[] arr) {
        int n = arr.length;
        int[] arr1 = new int[n + 2];
        for (int i = 0; i < n; i++)
            arr1[i + 1] = arr[i];

        arr1[0] = arr1[n + 1] = 1;
        arr = arr1;
        int[][] dp = new int[n + 1][n + 1];
        for (int[] i : dp)
            Arrays.fill(i, -1);

        return solve(arr, 1, n, dp);
    }

    static int solve(int[] arr, int i, int j, int[][] dp) {
        if (i > j)
            return 0;

        if (dp[i][j] != -1)
            return dp[i][j];

        int max = Integer.MIN_VALUE;

        for (int ind = i; ind <= j; ind++) {
            int cost = (arr[i - 1] * arr[ind] * arr[j + 1])
                    + solve(arr, i, ind - 1, dp)
                    + solve(arr, ind + 1, j, dp);

            max = Math.max(max, cost);
        }

        return dp[i][j] = max;
    }
}
