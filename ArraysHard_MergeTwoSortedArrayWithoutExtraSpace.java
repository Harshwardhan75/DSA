import java.util.*;

public class ArraysHard_MergeTwoSortedArrayWithoutExtraSpace {

    static void Brutesort(int[] arr1, int[] arr2) {
        int[] arr3 = new int[arr1.length + arr2.length];

        int i = 0, j = 0, k = 0;

        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] < arr2[j])
                arr3[k++] = arr1[i++];
            else
                arr3[k++] = arr2[j++];
        }

        while (i < arr1.length)
            arr3[k++] = arr1[i++];
        while (j < arr2.length)
            arr3[k++] = arr2[j++];

        for (i = 0; i < arr3.length; i++) {
            if (i < arr1.length)
                arr1[i] = arr3[i];
            else
                arr2[i - arr1.length] = arr3[i];
        }
    }

    static void OptimalSort(int[] arr1, int[] arr2) {
        int left = arr1.length - 1;
        int right = 0;

        while (left >= 0 && right < arr2.length) {
            if (arr1[left] >= arr2[right]) {
                int temp = arr1[left];
                arr1[left] = arr2[right];
                arr2[right] = temp;
            } else
                break;
            left--;
            right++;
        }

        Arrays.sort(arr1);
        Arrays.sort(arr2);
    }

    static void SwapIfGreater(int[] arr1, int[] arr2, int i, int j) {
        if (arr1[i] > arr2[j]) {
            int temp = arr1[i];
            arr1[i] = arr2[j];
            arr2[j] = temp;
        }
    }

    static void Optimal2Sort(int[] arr1, int[] arr2) {
        int n = arr1.length;
        int m = arr2.length;
        int length = n + m;
        int gap = length / 2 + length % 2;

        while (gap > 0) {
            int left = 0, right = left + gap;
            while (right < length) {
                //You are in arr1 and arr2
                if (left < n && right >= n) {
                    SwapIfGreater(arr1, arr2, left, right - n);
                } 
                else//You are in arr2 and arr2 
                if (left >= n) {
                    SwapIfGreater(arr2, arr2, left - n, right - n);
                } 
                else //you are in arr1 and arr1
                {
                    SwapIfGreater(arr1, arr1, left, right);
                }
                left++;
                right++;
            }
            if (gap == 1)
                break;
            gap = gap / 2 + gap % 2;
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[] arr1 = new int[m];
        int[] arr2 = new int[n];
        for (int i = 0; i < m; i++)
            arr1[i] = sc.nextInt();

        for (int i = 0; i < n; i++)
            arr2[i] = sc.nextInt();

        Optimal2Sort(arr1, arr2);

        for (int var : arr1)
            System.out.print(var + " ");

        for (int var : arr2)
            System.out.print(var + " ");
    }
}
