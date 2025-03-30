import java.util.*;

public class DynamicProgramming_SubsetSumEqualsTarget {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int target = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        System.out.println(Memoization_SubsetSum(arr, target));
        System.out.println(Tabulation_SubsetSum(arr, target));
        System.out.println(SpaceOptimization_SubsetSum(arr, target));
    }

    static boolean SpaceOptimization_SubsetSum(int[] arr,int k){
        boolean[] prev=new boolean[k+1];
        boolean[] curr=new boolean[k+1];
        prev[0]=curr[0]=true;
        prev[arr[0]]=true;
        int n=arr.length;

        for(int i=1;i<n;i++){
            for(int target=1;target<=k;target++){
                boolean nottake=prev[target];
                boolean take=false;
                if(target>=arr[i])
                    take=prev[target-arr[i]];
                curr[target]=take||nottake;
            }
            prev=curr;
        }

        return prev[k];
    }

    static boolean Tabulation_SubsetSum(int[] arr,int k){
        int n=arr.length;
        boolean[][] dp=new boolean[n][k+1];
        for(int i=0;i<n;i++)
            dp[i][0]=true;
        dp[0][arr[0]]=true;

        for(int i=1;i<n;i++){
            for(int target=1;target<=k;target++){
                boolean nottake=dp[i-1][target];
                boolean take=false;
                if(target>=arr[i])
                    take=dp[i-1][target-arr[i]];
                
                dp[i][target]=take||nottake;
            }
        }

        return dp[n-1][k];
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
