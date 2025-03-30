import java.util.*;

public class DynamicProgramming_StringEditDistance {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String t = sc.next();

        System.out.println(Memoization_EditDistance1(s, t));
        System.out.println(Memoization_EditDistance2(s, t));
        System.out.println(Tabulation_EditDistance(s, t));
        System.out.println(SpaceOptimization_EditDistance(s,t));
    }

    static int SpaceOptimization_EditDistance(String s,String t){
        int n=s.length();
        int m=t.length();
        char[] a=s.toCharArray();
        char[] b=t.toCharArray();
        
        int[] prev=new int[m+1];

        for(int j=0;j<=m;j++)
            prev[j]=j;
        
        for(int i=1;i<=n;i++){
            int[] curr=new int[m+1];
            curr[0]=i;

            for(int j=1;j<=m;j++){
                if(a[i-1]==b[j-1])
                    curr[j]=prev[j-1];
                else{
                    int insert = 1+curr[j-1];
                    int delete = 1+prev[j];
                    int replace = 1+prev[j-1];

                    curr[j]=Math.min(insert, Math.min(delete, replace));
                }
            }
            prev=curr;
        }

        return prev[m];
    }

    static int Tabulation_EditDistance(String s, String t) {
        int n = s.length();
        int m = t.length();

        int[][] dp = new int[n + 1][m + 1];

        for (int i = 0; i <= n; i++)
            dp[i][0] = i;

        for (int j = 0; j <= m; j++)
            dp[0][j] = j;

        char[] a = s.toCharArray();
        char[] b = t.toCharArray();

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (a[i - 1] == b[j - 1])
                    dp[i][j] = dp[i - 1][j - 1];
                else {
                    int insert = 1 + dp[i][j - 1];
                    int delete = 1 + dp[i - 1][j];
                    int replace = 1 + dp[i - 1][j - 1];

                    dp[i][j] = Math.min(insert, Math.min(delete, replace));
                }
            }
        }

        return dp[n][m];
    }

    static int Memoization_EditDistance2(String s, String t) {
        int n = s.length();
        int m = t.length();
        int[][] dp = new int[n + 1][m + 1];
        for (int[] i : dp)
            Arrays.fill(i, -1);

        return solve2(s.toCharArray(), t.toCharArray(), n, m, dp);
    }

    static int solve2(char[] s, char[] t, int i, int j, int[][] dp) {
        if (i == 0)
            return j;
        if (j == 0)
            return i;

        if (dp[i][j] != -1)
            return dp[i][j];

        if (s[i - 1] == t[j - 1])
            return dp[i][j] = solve2(s, t, i - 1, j - 1, dp);
        else {
            int insert = 1 + solve2(s, t, i, j - 1, dp);
            int delete = 1 + solve2(s, t, i - 1, j, dp);
            int replace = 1 + solve2(s, t, i - 1, j - 1, dp);

            return dp[i][j] = Math.min(insert, Math.min(delete, replace));
        }
    }

    static int Memoization_EditDistance1(String s, String t) {
        int n = s.length();
        int m = t.length();
        int[][] dp = new int[n][m];
        for (int[] i : dp)
            Arrays.fill(i, -1);

        return solve(s.toCharArray(), t.toCharArray(), n - 1, m - 1, dp);
    }

    static int solve(char[] s, char[] t, int i, int j, int[][] dp) {
        if (i < 0)
            return j + 1;
        if (j < 0)
            return i + 1;

        if (dp[i][j] != -1)
            return dp[i][j];

        if (s[i] == t[j])
            return dp[i][j] = solve(s, t, i - 1, j - 1, dp);
        else {
            int insert = 1 + solve(s, t, i, j - 1, dp);
            int delete = 1 + solve(s, t, i - 1, j, dp);
            int replace = 1 + solve(s, t, i - 1, j - 1, dp);

            return dp[i][j] = Math.min(insert, Math.min(delete, replace));
        }
    }
}
