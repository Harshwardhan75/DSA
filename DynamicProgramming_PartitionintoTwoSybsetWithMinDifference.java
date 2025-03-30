import java.util.*;

public class DynamicProgramming_PartitionintoTwoSybsetWithMinDifference {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        System.out.println(minDifference(arr));
    }

    //it uses tabulation approach can be memonized and further space optimization can also be done
    static int minDifference(int[] arr){
        int sum =0;
        int n=arr.length;
        for(int i: arr) sum+=i;
        boolean[][] dp=new boolean[n][sum+1];
        for(int i=0;i<n;i++)
            dp[i][0]=true;
        
        if(arr[0]<=sum)
            dp[0][arr[0]]=true;
        for(int i=1;i<n;i++){
            for(int j=1;j<=sum;j++){
                boolean notpick=dp[i-1][j];
                boolean pick=false;

                if(arr[i]<=j)
                    pick = dp[i-1][j-arr[i]];
                dp[i][j]=pick|notpick;
            }
        }

        int min =Integer.MAX_VALUE;

        for(int s1=0;s1<=sum;s1++){
            if(dp[n-1][s1]){
                int s2=sum-s1;
                min=Math.min(min, Math.abs(s1-s2));
            }
        }

        return min;
    }
}
