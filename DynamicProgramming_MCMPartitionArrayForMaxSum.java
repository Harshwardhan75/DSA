import java.util.*;

public class DynamicProgramming_MCMPartitionArrayForMaxSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        System.out.println(Memoization_ArrayPartition(arr, k));
        System.out.println(Tabulation_ArrayPartition(arr, k));
    }

    static int Tabulation_ArrayPartition(int[] arr, int k) {
        int n = arr.length;
        int[] dp = new int[n + 1];
        dp[n] = 0;

        for (int index = n - 1; index >= 0; index--) {
            int max = 0;
            int maxSum = 0;
            int len = 0;

            for (int i = index; i < arr.length && i < index + k; i++) {
                len++;
                max = Math.max(max, arr[i]);
                int sum = len * max + solve(arr, i + 1, k, dp);

                maxSum = Math.max(maxSum, sum);
            }

            dp[index] = maxSum;
        }

        return dp[0];
    }

    static int Memoization_ArrayPartition(int[] arr, int k) {
        int n = arr.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);

        return solve(arr, 0, k, dp);
    }

    static int solve(int[] arr, int index, int k, int[] dp) {
        if (index >= arr.length)
            return 0;

        if (dp[index] != -1)
            return dp[index];

        int max = 0;
        int maxSum = 0;
        int len = 0;

        for (int i = index; i < arr.length && i < index + k; i++) {
            len++;
            max = Math.max(max, arr[i]);
            int sum = len * max + solve(arr, i + 1, k, dp);

            maxSum = Math.max(maxSum, sum);
        }

        return dp[index] = maxSum;
    }
}
