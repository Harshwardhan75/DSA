import java.util.Scanner;

public class DynamicProgramming_LISNumberOfLIS {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        
        System.out.println(NumberOfLIS(arr));
    }

    static int NumberOfLIS(int[] arr){
        int n=arr.length;
        int[] dp=new int[n];
        int[] cnt=new int[n];
        int max = 0;
        for(int i=0;i<n;i++){
            dp[i]=cnt[i]=1;
            for(int j=0;j<i;j++){
                if(arr[j]<arr[i] && dp[j]+1>dp[i]){
                    dp[i]=dp[j]+1;
                    cnt[i]=cnt[j];
                }
                else if(arr[j]<arr[i] && dp[j]+1==dp[i])    {
                    cnt[i]+=cnt[j];
                }
            }
            
            max=Math.max(max,dp[i]);
        }

        int count = 0;
        for(int i=0;i<n;i++){
            if(dp[i]==max)
                count+=cnt[i];
        }
        
        return count;
    }
}
