import java.util.*;

public class DynamicProgramming_StringWildcardMatching {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String p = sc.next();
        String s = sc.next();

        System.out.println(Memoization_WildcardMatching1(p, s));
        System.out.println(Memoization_WildcardMatching2(p,s));
        System.out.println(Tabulation_WildcardMatching(p,s));
        System.out.println(SpaceOptimization_WildcardMatching(p,s));
    }

    static boolean SpaceOptimization_WildcardMatching(String p,String s){
        char[] pc=p.toCharArray();
        char[] sc=s.toCharArray();
        int n=p.length();
        int m=s.length();

        boolean[] prev=new boolean[m+1];
        prev[0]=true;
        
        for(int j=1;j<=m;j++)
            prev[j]=false;
        
        for(int i=1;i<=n;i++){
            boolean[] curr=new boolean[m+1];
            curr[0]=true;
            for(int ii=1;ii<=i;ii++){
                if(pc[ii-1]!='*'){
                    curr[0]=false;
                    break;
                }
            }
            for(int j=1;j<=m;j++){
                if(pc[i-1]==sc[j-1] || pc[i-1]=='?'){
                    curr[j]=prev[j-1];
                }
                else
                if(pc[i-1]=='*'){
                    curr[j]=prev[j]||curr[j-1];
                }
                else{
                    curr[j]=false;
                }
            }
            prev=curr;
        }
        return prev[m];
    }

    static boolean Tabulation_WildcardMatching(String p,String s){
        char[] pc=p.toCharArray();
        char[] sc=s.toCharArray();
        int n=p.length();
        int m=s.length();

        boolean[][] dp=new boolean[n+1][m+1];
        dp[0][0]=true;
        
        for(int j=1;j<=m;j++)
            dp[0][j]=false;
        
        for(int i=1;i<=n;i++){
            dp[i][0]=true;
            for(int ii=1;ii<=i;ii++){
                if(pc[ii-1]!='*'){
                    dp[i][0]=false;
                    break;
                }
            }
        }

        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(pc[i-1]==sc[j-1] || pc[i-1]=='?'){
                    dp[i][j]=dp[i-1][j-1];
                }
                else
                if(pc[i-1]=='*'){
                    dp[i][j]=dp[i-1][j]||dp[i][j-1];
                }
                else{
                    dp[i][j]=false;
                }
            }
        }
        return dp[n][m];
    }

    static boolean Memoization_WildcardMatching2(String p, String s) {
        int n = p.length();
        int m = s.length();
        int[][] dp = new int[n+1][m+1];
        for (int[] i : dp)
            Arrays.fill(i, -1);

        return solve2(p.toCharArray(), s.toCharArray(), n, m, dp) == 1;
    }

    static int solve2(char[] p, char[] s, int i, int j, int[][] dp) {
        if (i == 0 && j == 0)
            return 1;
        if (i == 0 && j > 0)
            return 0;

        if (j == 0 && i > 0) {
            for (int ii = 1; ii <= i; ii++) {
                if (p[ii-1] != '*')
                    return 0;
            }
            return 1;
        }

        if (dp[i][j] != -1)
            return dp[i][j];

        if (p[i-1] == s[j-1] || p[i-1] == '?')
            return dp[i][j] = solve2(p, s, i - 1, j - 1, dp);

        if (p[i-1] == '*')
            return dp[i][j] = solve2(p, s, i - 1, j, dp) | solve2(p, s, i, j - 1, dp);

        return dp[i][j] = 0;
    }

    static boolean Memoization_WildcardMatching1(String p, String s) {
        int n = p.length();
        int m = s.length();
        int[][] dp = new int[n][m];
        for (int[] i : dp)
            Arrays.fill(i, -1);

        return solve1(p.toCharArray(), s.toCharArray(), n - 1, m - 1, dp) == 1;
    }

    static int solve1(char[] p, char[] s, int i, int j, int[][] dp) {
        if (i < 0 && j < 0)
            return 1;
        if (i < 0 && j >= 0)
            return 0;

        if (j < 0 && i >= 0) {
            for (int ii = 0; ii <= i; ii++) {
                if (p[ii] != '*')
                    return 0;
            }
            return 1;
        }

        // if (dp[i][j] != -1)
        //     return dp[i][j];

        if (p[i] == s[j] || p[i] == '?')
            return dp[i][j] = solve1(p, s, i - 1, j - 1, dp);

        if (p[i] == '*')
            return dp[i][j] = solve1(p, s, i - 1, j, dp) | solve1(p, s, i, j - 1, dp);

        return dp[i][j] = 0;
    }
}
