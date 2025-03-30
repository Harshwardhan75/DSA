import java.util.*;

public class DynamicProgramming_MCMPalindromePartitioning_II {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();

        System.out.println(Memoization_Partition(s));
        System.out.println(Tabulation_Partition(s));
    }

    static int Tabulation_Partition(String s){
        char[] c=s.toCharArray();
        int n=s.length();
        int[] dp=new int[n+1];

        for(int index=n-1;index>=0;index--){
            int max=Integer.MAX_VALUE;
            for(int i=index;i<c.length;i++){
                if(isPalindrome(c, index, i)){
                    int cost = 1+dp[i+1];
                    max=Math.min(max,cost);
                }
            }
            dp[index]=max;
        }

        return dp[0]-1;
    }

    static int Memoization_Partition(String s) {
        char[] c = s.toCharArray();
        int n = s.length();
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return solve(c, 0, dp) - 1;
    }

    static int solve(char[] s, int index, int[] dp) {
        if (index >= s.length)
            return 0;

        if (dp[index] != -1)
            return dp[index];

        int max = Integer.MAX_VALUE;
        for (int i = index; i < s.length; i++) {
            if (isPalindrome(s, index, i)) {
                int cost = 1 + solve(s, i + 1, dp);
                max = Math.min(max, cost);
            }
        }

        return dp[index] = max;
    }

    static boolean isPalindrome(char[] s, int start, int end) {
        while (start < end) {
            if (s[start] != s[end])
                return false;
            start++;
            end--;
        }
        return true;
    }
}
