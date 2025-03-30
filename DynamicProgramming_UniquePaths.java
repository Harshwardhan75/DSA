import java.util.*;

public class DynamicProgramming_UniquePaths {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();

        System.out.println(Memoization_UniquePath(n,m));
        System.out.println(Tabulation_UniquePath(n,m));
        System.out.println(SpaceOptimization_UniquePath(n,m));
    }

    static int SpaceOptimization_UniquePath(int n,int m){
        int[] prev=new int[m];
        for(int r=0;r<n;r++){
            int[] curr=new int[m];
            for(int c=0;c<m;c++){
                if(r==0 && c==0)
                    curr[c]=1;
                else{
                    int up=prev[c];
                    int left=c>0?curr[c-1]:0;
                    curr[c]=up+left;
                }
            }
            prev=curr;
        }

        return prev[m-1];
    }

    static int Tabulation_UniquePath(int n,int m){
        int[][] dp=new int[n][m];
        for(int r=0;r<n;r++){
            for(int c=0;c<m;c++){
                if(r==0 && c==0)
                    dp[r][c]=1;
                else{
                    int up=r>0?dp[r-1][c]:0;
                    int left=c>0?dp[r][c-1]:0;
                    dp[r][c]=up+left;
                }
            }
        }

        return dp[n-1][m-1];
    }

    static int Memoization_UniquePath(int n,int m){
        int[][] dp=new int[n][m];
        for(int[] i: dp)    Arrays.fill(i, -1);

        return solve(dp,n-1,m-1);
    }

    static int solve(int[][] dp,int r,int c){
        if(r==0 && c==0)
            return 1;
        if(r<0 || c<0)
            return 0;

        if(dp[r][c]!=-1)
            return dp[r][c];
        
        int up=solve(dp, r-1, c);
        int left=solve(dp, r, c-1);

        return dp[r][c]=up+left;
    }
}
