import java.util.*;

public class DynamicProgramming_StringLongestCommonSubstring {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s1=sc.next();
        String s2=sc.next();

        System.out.println(Tabulation_LCS(s1,s2));
        System.out.println(SpaceOptimization_LCS(s1,s2));
    }

    static int SpaceOptimization_LCS(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int[] prev = new int[m + 1];
        for (int j = 0; j <= m; j++)
            prev[j] = 0;

        char[] S1 = s1.toCharArray();
        char[] S2 = s2.toCharArray();
        int max = 0;
        for (int ind1 = 1; ind1 <= n; ind1++) {
            int[] curr=new int[m+1];
            for (int ind2 = 1; ind2 <= m; ind2++) {
                if (S1[ind1 - 1] == S2[ind2 - 1])
                    curr[ind2] = 1 + prev[ind2 - 1];
                max=Math.max(max,curr[ind2]);
            }
            prev=curr;
        }
        return max;
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
        int max =0;
        for (int ind1 = 1; ind1 <= n; ind1++) {
            for (int ind2 = 1; ind2 <= m; ind2++) {
                if (S1[ind1 - 1] == S2[ind2 - 1])
                    dp[ind1][ind2] = 1 + dp[ind1 - 1][ind2 - 1];
                max=Math.max(max,dp[ind1][ind2]);
            }
        }

        return max;
    }
}
