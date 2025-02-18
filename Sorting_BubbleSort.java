import java.util.ArrayList;
import java.util.Scanner;

public class Sorting_BubbleSort {

    static ArrayList<Integer> BubbleSort(ArrayList<Integer> arr) {
        boolean flag = false;
        int count = 0;
        for (int i = 0; i < arr.size() - 1; i++) {
            flag = false;
            for (int j = 1; j < arr.size() - i; j++) {
                if (arr.get(j) < arr.get(j - 1)) {
                    int temp = arr.get(j);
                    arr.set(j, arr.get(j - 1));
                    arr.set(j - 1, temp);
                    flag = true;
                }
                count++;
            }
            if (!flag)
                break;
        }
        System.out.println(count);
        return arr;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr.add(sc.nextInt());
        }

        System.out.println(arr);
        arr = BubbleSort(arr);
        System.out.println(arr);
    }
}
