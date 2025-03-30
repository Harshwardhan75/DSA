import java.util.*;

public class DynamicProgramming_LISLongestStringChain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        String[] arr = new String[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.next();

        System.out.println(LongestStringChain(arr));
    }

    static int LongestStringChain(String[] arr) {
        int n = arr.length;
        int[] dp = new int[n];
        int[] hash=new int[n];
        Arrays.sort(arr, (a, b) -> a.length() - b.length());
        int max = 1;
        int lastIndex= 0;

        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            hash[i]=i;
            for (int j = 0; j < i; j++) {
                if (check(arr[i], arr[j]) && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                    hash[i]=j;
                }
            }
            if(max<dp[i]){
                max=dp[i];
                lastIndex=i;
            }
        }

        ArrayList<String> result=new ArrayList<>();
        result.add(arr[lastIndex]);

        while(lastIndex!=hash[lastIndex]){
            lastIndex=hash[lastIndex];
            result.add(arr[lastIndex]);
        }
        Collections.reverse(result);
        System.out.println(result);
        return max;
    }

    static boolean check(String s1, String s2) {
        char[] a = s1.toCharArray();
        char[] b = s2.toCharArray();

        int first = 0, second = 0;

        while (first < a.length) {
            if (second < b.length && a[first] == b[second]) {
                first++;
                second++;
            } else
                first++;
        }

        return first == a.length && second == b.length;
    }
}
