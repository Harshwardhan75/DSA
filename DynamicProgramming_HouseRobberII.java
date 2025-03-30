import java.util.*;

public class DynamicProgramming_HouseRobberII {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++)
            arr[i]=sc.nextInt();
        
        System.out.println(findMaxHouse(arr));
    }

    static int findMaxHouse(int[] arr){
        int n=arr.length;
        //last is leave
        int[] first=new int[n-1];
        //first is leave
        int[] last=new int[n-1];

        for(int i=0;i<n;i++){
            if(i!=0)
                first[i-1]=arr[i];
            if(i!=n-1)
                last[i]=arr[i];
        }

        int ans1=Memoization_MaxSum(first);
        int ans2=Memoization_MaxSum(last);

        return Math.max(ans1, ans2);
    }


    static int SpaceOptimization_MaxSum(int[] arr) {
        int prev2 = 0, prev1 = arr[0];
        int n = arr.length;

        for (int i = 1; i < n; i++) {
            int pick = arr[i] + prev2;
            int notpick = prev1;
            int curr = Math.max(pick, notpick);
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
    }

    static int Tabulation_MaxSum(int[] arr) {
        int n = arr.length;
        int[] dp = new int[n];
        dp[0] = arr[0];

        for (int i = 1; i < n; i++) {
            int pick = arr[i];
            if (i > 1)
                pick += dp[i - 2];
            int notpick = dp[i - 1];

            dp[i] = Math.max(pick, notpick);
        }

        return dp[n - 1];
    }

    static int Memoization_MaxSum(int[] arr) {
        int n = arr.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);

        return Solve(arr, n - 1, dp);
    }

    static int Solve(int[] arr, int index, int[] dp) {
        if (index == 0)
            return arr[index];

        if (index < 0)
            return 0;

        if (dp[index] != -1)
            return dp[index];

        int pick = arr[index] + Solve(arr, index - 2, dp);
        int notpick = Solve(arr, index - 1, dp);

        return dp[index] = Math.max(pick, notpick);
    }

}
