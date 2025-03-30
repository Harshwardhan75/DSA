import java.util.*;

public class DynamicProgramming_FrogJumpI {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] height = new int[n];
        for (int i = 0; i < n; i++)
            height[i] = sc.nextInt();

        System.out.println(Memoization_FrogJump(height));
        System.out.println(Tabulation_FrogJump(height));
        System.out.println(SpaceOptimization_FrogJump(height));
    }

    static int SpaceOptimization_FrogJump(int[] height) {
        int n = height.length;
        int prev2 = 0, prev1 = 0;

        for (int i = 1; i < n; i++) {
            int left = prev1 + Math.abs(height[i] - height[i - 1]);
            int right = i > 1 ? prev2 + Math.abs(height[i] - height[i - 2]) : Integer.MAX_VALUE;
            int curr = Math.min(left, right);
            prev2 = prev1;
            prev1 = curr;
        }

        return prev1;
    }

    static int Tabulation_FrogJump(int[] height) {
        int n = height.length;
        int[] dp = new int[n];
        dp[0] = 0;

        for (int i = 1; i < n; i++) {
            int left = dp[i - 1] + Math.abs(height[i] - height[i - 1]);
            int right = i > 1 ? dp[i - 2] + Math.abs(height[i] - height[i - 2]) : Integer.MAX_VALUE;
            dp[i] = Math.min(left, right);
        }

        return dp[n - 1];
    }

    static int Memoization_FrogJump(int[] height) {
        int n = height.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return Solve(height, n-1, dp);
    }

    static int Solve(int[] height, int index, int[] dp) {
        if (index == 0)
            return 0;

        if (dp[index] != -1)
            return dp[index];

        int left = Solve(height, index - 1, dp) + Math.abs(height[index] - height[index - 1]);

        int right = index > 1 ? Solve(height, index - 2, dp) + Math.abs(height[index] - height[index - 2])
                : Integer.MAX_VALUE;

        return dp[index] = Math.min(left, right);
    }
}