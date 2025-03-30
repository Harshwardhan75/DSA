import java.util.*;

public class DynamicProgramming_CountPartitionsWithGivenDifference {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int d=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++)
            arr[i]=sc.nextInt();
        
        System.out.println(countPartition(arr,d));
    }

    static int countPartition(int[] arr,int d){
        int totalsum=0;
        for(int i: arr) totalsum+=i;

        if(totalsum-d<0 || (totalsum-d)%2==1)
            return 0;
        
        return Tabulation_NumberOfSubsets(arr, (totalsum-d)/2);
    }

    static int Tabulation_NumberOfSubsets(int[] arr, int k) {
        int n=arr.length;
        int[][] dp = new int[n][k + 1];
        if(arr[0]==0)
            dp[0][0]=2;
        else
            dp[0][0]=1;
        
        if(arr[0]!=0 && arr[0]<=k)
            dp[0][arr[0]]=1;

        for(int i=1;i<n;i++){
            for(int j=0;j<=k;j++){
                int notpick=dp[i-1][j];
                int pick =0;
                if(j>=arr[i])
                    pick = dp[i-1][j-arr[i]];
                dp[i][j]=pick+notpick;
            }
        }

        return dp[n-1][k];
    }
}
