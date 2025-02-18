import java.util.Scanner;

public class SlidingWindow_MaxConsecutiveOnes3 {

    static int Bruteconsecutiveone(int[] arr, int k) {
        int n = arr.length;
        int max = 0;
        for (int i = 0; i < n; i++) {
            int zero = 0;
            for (int j = i; j < n; j++) {
                if (arr[j] == 0)
                    zero++;
                if (zero > k)
                    break;
                else
                    max = Math.max(max, j - i + 1);
            }
        }

        return max;
    }

    static int Optimalconsecutiveone1(int[] arr, int k) {
        int l = 0, r = 0;
        int max = 0, zero = 0;
        int n = arr.length;

        while (r < n) {
            if (arr[r] == 0)
                zero++;

            while (zero > k) {
                if (arr[l] == 0)
                    zero--;
                l++;
            }

            if (zero <= k)
                max = Math.max(max, r - l + 1);
            r++;
        }
        return max;
    }

    static int Optimalconsecutiveone2(int[] arr, int k) {
        int n = arr.length;
        int r = 0, l = 0;
        int max = 0, zero = 0;

        while (r < n) {
            if(arr[r]==0)
                zero++;
            
            if(zero>k){
                if(arr[l]==0)
                    zero--;
                l++;
            }

            if(zero<=k)
                max=Math.max(max,r-l+1);
            r++;
        }
        return max;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        System.out.println(Optimalconsecutiveone2(arr, k));
    }
}