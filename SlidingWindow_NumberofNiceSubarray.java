import java.util.*;

public class SlidingWindow_NumberofNiceSubarray {

    static int smallerequalsubarray(int[] arr, int k) {
        if (k < 0)
            return 0;
        int l = 0, r = 0, odd = 0, count = 0;
        int n = arr.length;

        while (r < n) {
            odd += arr[r]%2;
            while (l <= r && odd > k)
                odd -= arr[l++]%2;
            count += (r - l + 1);
            r++;
        }

        return count;
    }

    static int OptimalSubarraywithgoal(int[] arr, int k) {
        return smallerequalsubarray(arr, k) - smallerequalsubarray(arr, k - 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        System.out.println(OptimalSubarraywithgoal(arr, k));
    }
}
