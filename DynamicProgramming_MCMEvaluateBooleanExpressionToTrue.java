import java.util.*;

public class DynamicProgramming_MCMEvaluateBooleanExpressionToTrue {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.next();

        System.out.println(Memoization_Evaluate(s));
    }

    static int Memoization_Evaluate(String s){
        int n=s.length();
        int[][][] dp=new int[n][n][2];
        for(int[][] i: dp)
            for(int[] j: i)
                Arrays.fill(j,-1);
            
        return solve(s.toCharArray(),0,n-1,1,dp);
    }

    static int solve(char[] s,int i,int j,int isTrue,int[][][] dp){
        if(i>j)
            return 0;
        
        if(i==j){
            if(isTrue==1)
                return s[i]=='T'?1:0;
            else
                return s[i]=='F'?1:0;
        }

        if(dp[i][j][isTrue]!=-1)
            return dp[i][j][isTrue];
        
        int ways = 0;

        for(int ind = i+1;ind<=j-1;ind+=2){
            int LT=solve(s, i, ind-1, 1, dp);
            int LF=solve(s, i, ind-1, 0, dp);
            int RT=solve(s, ind+1, j, 1, dp);
            int RF=solve(s, ind+1, j, 0, dp);

            if(s[ind]=='&'){
                if(isTrue==1){
                    ways += (LT*RT);
                }else{
                    ways += (LT*RF)+(LF*RT)+(LF*RF);
                }
            }
            else if(s[ind]=='|'){
                if(isTrue==1){
                    ways += (LT*RT)+(LT*RF)+(LF*RT);
                }else{
                    ways += (LF*RF);
                }
            }
            else{
                if(isTrue==1){
                    ways += (LT*RF)+(LF*RT);
                }else{
                    ways += (LT*RT)+(LF*RF);
                }
            }
        }

        return dp[i][j][isTrue]=ways;
    }
}
