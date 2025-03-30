import java.util.*;

public class DynamicProgramming_StringShortestCommonSupersequence {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String a=sc.next();
        String b=sc.next();

        System.out.println(ShortestCommonSupersequence(a,b));
    }

    static String ShortestCommonSupersequence(String a,String b){
        char[] s1=a.toCharArray();
        char[] s2=b.toCharArray();
        int n=a.length();
        int m=b.length();
        int[][] dp=new int[n+1][m+1];

        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(s1[i-1]==s2[j-1])
                    dp[i][j]=1+dp[i-1][j-1];
                else    
                    dp[i][j]=Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }

        int i=n,j=m;
        StringBuilder result=new StringBuilder();
        while(i>0 && j>0){
            if(s1[i-1]==s2[j-1]){
                result.append(s1[i-1]);
                i--;
                j--;
            }
            else if(dp[i-1][j]>=dp[i][j-1]){
                result.append(s1[i-1]);
                i--;
            }
            else{
                result.append(s2[j-1]);
                j--;
            }
        }

        while(i>0){
            result.append(s1[i-1]);
            i--;
        }

        while(j>0){
            result.append(s2[j-1]);
            j--;
        }

        return result.reverse().toString();
    }
}
