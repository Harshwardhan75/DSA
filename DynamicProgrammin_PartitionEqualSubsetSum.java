import java.util.Arrays;
import java.util.Scanner;

public class DynamicProgrammin_PartitionEqualSubsetSum {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++)
            arr[i]=sc.nextInt();
        
        System.out.println(canPartition(arr));
    }

    static boolean canPartition(int[] arr){
        int sum = Arrays.stream(arr).sum();
        if(sum%2==1)
            return false;
        
        return Memoization_SubsetSum(arr,sum/2);
    }

    static boolean Memoization_SubsetSum(int[] arr, int target) {
        int n = arr.length;
        int[][] dp = new int[n][target + 1];
        for (int[] i : dp)
            Arrays.fill(i, -1);

        return solve(arr, n - 1, target, dp) == 1;
    }

    static int solve(int[] arr, int index, int target, int[][] dp) {
        if (target == 0)
            return 1;
        if (index == 0)
            return arr[0] == target ? 1 : 0;

        if (dp[index][target] != -1)
            return dp[index][target];

        int nottake = solve(arr, index - 1, target, dp);
        int take = 0;
        if (target >= arr[index])
            take = solve(arr, index - 1, target - arr[index], dp);
        
        return dp[index][target]=take|nottake;
    }
}