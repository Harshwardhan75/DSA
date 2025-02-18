import java.util.ArrayList;
import java.util.Scanner;

public class Sorting_MergeSort {

    static ArrayList<Integer> Merge(ArrayList<Integer> arr, int left, int mid, int right) {

        int i = left;
        int j = mid + 1;
        ArrayList<Integer> newarr = new ArrayList<>();
        while (i <= mid && j <= right) {
            if (arr.get(i) < arr.get(j)) {
                newarr.add(arr.get(i)); i++;
            } else {
                newarr.add(arr.get(j)); j++;
            }
        }

        while (i <= mid)
            newarr.add(arr.get(i++));
        while (j <= right)
            newarr.add(arr.get(j++));
        
        for(int x=left;x<=right;x++)
            arr.set(x,newarr.get(x-left));
        return arr;
    }

    static ArrayList<Integer> MergeSort(ArrayList<Integer> arr, int left, int right) {
        if (left >= right)
            return arr;
        int mid = (left + right) / 2;
        arr = MergeSort(arr, left, mid);
        arr = MergeSort(arr, mid + 1, right);
        arr = Merge(arr, left, mid, right);
        return arr;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < n; i++)
            arr.add(sc.nextInt());

        System.out.println(arr);
        arr = MergeSort(arr, 0, arr.size() - 1);
        System.out.println(arr);
    }
}
