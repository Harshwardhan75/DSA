import java.util.ArrayList;
import java.util.Scanner;

public class Sorting_InsertionSort {

    static ArrayList<Integer> InsertionSort(ArrayList<Integer> arr) {
        boolean swap=false;
        int count=0;
        for (int i = 1; i < arr.size(); i++) {
            swap=false;
            int key = arr.get(i);            

            int j = i - 1;
            while (j >= 0 && key < arr.get(j)) {
                arr.set(j + 1, arr.get(j));
                j--;
                swap=true;
                count++;
            }
            arr.set(j+1, key);
            if(!swap)   break;
        }
        System.out.println(count);

        return arr;
    } 

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < n; i++)
            arr.add(sc.nextInt());

        System.out.println(arr);
        arr = InsertionSort(arr);
        System.out.println(arr);
    }
}
