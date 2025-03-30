import java.util.*;

public class DynamicProgramming_StringLongestCommonSubsequence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        String s2 = sc.next();

        System.out.println(Memoization_LCS(s1, s2));
        System.out.println(Tabulation_LCS(s1, s2));
        System.out.println(SpaceOptimization_LCS(s1, s2));
    }

    static int SpaceOptimization_LCS(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int[] prev = new int[m + 1];
        for (int j = 0; j <= m; j++)
            prev[j] = 0;

        char[] S1 = s1.toCharArray();
        char[] S2 = s2.toCharArray();

        for (int ind1 = 1; ind1 <= n; ind1++) {
            int[] curr=new int[m+1];
            for (int ind2 = 1; ind2 <= m; ind2++) {
                if (S1[ind1 - 1] == S2[ind2 - 1])
                    curr[ind2] = 1 + prev[ind2 - 1];
                else {
                    int one = prev[ind2];
                    int two = curr[ind2 - 1];
                    curr[ind2] = Math.max(one, two);
                }
            }
            prev=curr;
        }
        return prev[m];
    }

    static int Tabulation_LCS(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i <= n; i++)
            dp[i][0] = 0;

        for (int j = 0; j <= m; j++)
            dp[0][j] = 0;

        char[] S1 = s1.toCharArray();
        char[] S2 = s2.toCharArray();

        for (int ind1 = 1; ind1 <= n; ind1++) {
            for (int ind2 = 1; ind2 <= m; ind2++) {
                if (S1[ind1 - 1] == S2[ind2 - 1])
                    dp[ind1][ind2] = 1 + dp[ind1 - 1][ind2 - 1];
                else {
                    int one = dp[ind1 - 1][ind2];
                    int two = dp[ind1][ind2 - 1];
                    dp[ind1][ind2] = Math.max(one, two);
                }
            }
        }

        return dp[n][m];
    }

    static int Memoization_LCS(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int[][] dp = new int[n][m];
        for (int[] i : dp)
            Arrays.fill(i, -1);

        return solve(s1.toCharArray(), s2.toCharArray(),
                n - 1, m - 1, dp);
    }

    static int solve(char[] s1, char[] s2, int ind1, int ind2, int[][] dp) {
        if (ind1 < 0 || ind2 < 0)
            return 0;

        if (dp[ind1][ind2] != -1)
            return dp[ind1][ind2];

        if (s1[ind1] == s2[ind2])
            return dp[ind1][ind2] = 1 +
                    solve(s1, s2, ind1 - 1, ind2 - 1, dp);
        else {
            int one = solve(s1, s2, ind1 - 1, ind2, dp);
            int two = solve(s1, s2, ind1, ind2 - 1, dp);

            return dp[ind1][ind2] = Math.max(one, two);
        }
    }
}
