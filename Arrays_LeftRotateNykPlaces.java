import java.util.*;

public class Arrays_LeftRotateNykPlaces {

    static void RotateLeftByK(ArrayList<Integer> arr, int k) {
        int[] temp = new int[k];

        for (int i = 0; i < k; i++)
            temp[i] = arr.get(i);
        for (int i = 0; i < arr.size() - k; i++)
            arr.set(i, arr.get(i + k));

        for (int i = arr.size() - k; i < arr.size(); i++)
            arr.set(i, temp[i - (arr.size() - k)]);
    }

    static void reverse(ArrayList<Integer> arr, int start, int end) {
        while(start<end){
            int temp=arr.get(start);
            arr.set(start++,arr.get(end));
            arr.set(end--,temp);
        }
    }

    static void OptimalRotateByK(ArrayList<Integer> arr, int k) {
        reverse(arr, 0, k-1);
        reverse(arr, k, arr.size()-1);
        reverse(arr, 0, arr.size()-1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> arr = new ArrayList<>();
        ArrayList<Integer> x=new ArrayList<>();
        int k = sc.nextInt();
        for (int i = 0; i < n; i++){
            int c=sc.nextInt();
            arr.add(c);
            x.add(c);
        }
        System.out.println(arr);
        RotateLeftByK(arr, k);
        System.out.println("BruteForce " + arr);

        OptimalRotateByK(x, k);
        System.out.println("Optimal " + x);
    }
}
