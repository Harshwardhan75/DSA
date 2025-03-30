import java.util.*;

public class DynamicProgramming_NumberOfSubsetWithSumK {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        System.out.println(Memoization_NumberOfSubsets(arr, k));
        System.out.println(Tabulation_NumberOfSubsets(arr, k));
        System.out.println(SpaceOptimization_NumberOfSubsets(arr, k));
    }

    static int SpaceOptimization_NumberOfSubsets(int[] arr,int k){
        int n=arr.length;
        int[] prev=new int[k+1];
        int[] curr=new int[k+1];
        prev[0]=curr[0]=1;
        if(arr[0]<=k)   prev[arr[0]]=1;
    
        for(int i=1;i<n;i++){
            for(int target=1;target<=k;target++){
                int notpick = prev[target];
                int pick =0;
                if(arr[i]<=target)
                    pick=prev[target-arr[i]];
                
                curr[target]=pick+notpick;
            }
            prev=curr;
        }

        return prev[k];
    }

    static int Tabulation_NumberOfSubsets(int[] arr, int k) {
        int n=arr.length;
        int[][] dp = new int[n][k + 1];
        for(int i=0;i<n;i++)
            dp[i][0]=1;
        
        if(arr[0]<=k)
            dp[0][arr[0]]=1;
        
        for(int i=1;i<n;i++){
            for(int target = 1;target<=k;target++){
                int notpick=dp[i-1][target];
                int pick=0;
                if(arr[i]<=target)
                    pick=dp[i-1][target-arr[i]];
                
                dp[i][target]=pick+notpick;
            }
        }

        return dp[n-1][k];
    }

    static int Memoization_NumberOfSubsets(int[] arr, int k) {
        int n = arr.length;
        int[][] dp = new int[n][k + 1];
        for (int[] i : dp)
            Arrays.fill(i, -1);

        return solve(arr, n - 1, k, dp);
    }

    static int solve(int[] arr, int index, int target, int[][] dp) {
        if (target == 0)
            return 1;
        if (index == 0)
            return target == arr[0] ? 1 : 0;

        if (dp[index][target] != -1)
            return dp[index][target];

        int notpick = solve(arr, index - 1, target, dp);
        int pick = 0;

        if (target >= arr[index])
            pick = solve(arr, index - 1, target - arr[index], dp);

        return dp[index][target] = pick + notpick;
    }
}
