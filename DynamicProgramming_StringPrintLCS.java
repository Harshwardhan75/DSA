import java.util.*;

public class DynamicProgramming_StringPrintLCS {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        String s2 = sc.next();
        System.out.println(Print_LCS(s1, s2));
    }

    static String Print_LCS(String s1, String s2) {
        int[][] dp = Tabulation_LCS(s1, s2);

        int n = s1.length();
        int m = s2.length();
        int i = n, j = m;

        char[] S1 = s1.toCharArray();
        char[] S2 = s2.toCharArray();

        char[] ans = new char[dp[n][m]];

        int index = dp[n][m]-1;

        while (i > 0 && j > 0) {
            if (S1[i - 1] == S2[j - 1]) {
                ans[index--] = S1[i - 1];
                i--;
                j--;
            } else if (dp[i - 1][j] > dp[i][j - 1])
                i--;
            else
                j--;
        }
        return new String(ans);
    }

    static int[][] Tabulation_LCS(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i <= n; i++)
            dp[i][0] = 0;

        for (int j = 0; j <= n; j++)
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

        return dp;
    }
}
