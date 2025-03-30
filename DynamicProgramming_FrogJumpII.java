import java.util.Arrays;
import java.util.Scanner;

public class DynamicProgramming_FrogJumpII {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] height = new int[n];
        for (int i = 0; i < n; i++)
            height[i] = sc.nextInt();

        System.out.println(Memoization_FrogJump(height, k));
        System.out.println(Tabulation_FrogJump(height, k));
    }

    static int Tabulation_FrogJump(int[] height, int k) {
        int n = height.length;
        int[] dp = new int[n];
        dp[0] = 0;

        for (int i = 1; i < n; i++) {
            int minsteps = Integer.MAX_VALUE;

            for (int j = 1; j <= k; j++) {
                if (i - j >= 0) {
                    int jumps = dp[i - j] + Math.abs(height[i] - height[i - j]);
                    minsteps = Math.min(minsteps, jumps);
                }
            }
            dp[i] = minsteps;
        }

        return dp[n - 1];
    }

    static int Memoization_FrogJump(int[] height, int k) {
        int n = height.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return Solve(height, n - 1, dp, k);
    }

    static int Solve(int[] height, int index, int[] dp,int k) {
        if (index == 0)
            return 0;

        if (dp[index] != -1)
            return dp[index];

        int minsteps=Integer.MAX_VALUE;

        for(int i=1;i<=k;i++){
            if(index-i>=0){
                int jumps=Solve(height, index-i, dp, k)+
                Math.abs(height[index]-height[index-i]);

                minsteps=Math.min(minsteps, jumps);
            }
        }

        return dp[index] = minsteps;
    }
}
