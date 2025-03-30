import java.util.*;

public class DynamicProgramming_LISLargestDivisibleSubset {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];

        for(int i=0;i<n;i++)
            arr[i]=sc.nextInt();
        
        System.out.println(largestDivisibleSet(arr));
    }

    static ArrayList<Integer> largestDivisibleSet(int[] arr){
        Arrays.sort(arr);
        int n=arr.length;
        int[] dp=new int[n];
        int[] parent=new int[n];
        int max = 1 , lastIndex=0;

        for(int i=0;i<n;i++){
            parent[i]=i;
            dp[i]=1;
            for(int j=0;j<i;j++){
                if(arr[i]%arr[j]==0 && dp[j]+1>dp[i]){
                    dp[i]=dp[j]+1;
                    parent[i]=j;
                }
            }

            if(dp[i]>max){
                max=dp[i];
                lastIndex=i;
            }
        }
        
        ArrayList<Integer> result=new ArrayList<>();
        result.add(arr[lastIndex]);

        while(lastIndex!=parent[lastIndex]){
            lastIndex=parent[lastIndex];
            result.add(arr[lastIndex]);
        }
        return result;
    }
}
