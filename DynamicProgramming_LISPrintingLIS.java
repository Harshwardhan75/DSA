import java.util.*;

public class DynamicProgramming_LISPrintingLIS {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        System.out.println(Best_LIS(arr));
    }

    static ArrayList<Integer> Best_LIS(int[] arr) {
        int n = arr.length;
        int[] dp = new int[n];
        int[] hash = new int[n];
        int max = 1;
        int lastIndex=0;

        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            hash[i] = i;
            for (int prev = 0; prev < i; prev++) {
                if (arr[prev] < arr[i] && dp[prev] + 1 > dp[i]) {
                    dp[i] = 1 + dp[prev];
                    hash[i] = prev;
                }
            }

            if (dp[i] > max) {
                max = dp[i];
                lastIndex=i;
            }
        }

        ArrayList<Integer> result=new ArrayList<>();
        result.add(arr[lastIndex]);

        while(hash[lastIndex]!=lastIndex){
            lastIndex=hash[lastIndex];
            result.add(arr[lastIndex]);
        }

        Collections.reverse(result);
        return result;
    }
}
