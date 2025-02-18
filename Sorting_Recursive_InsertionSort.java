import java.util.*;

public class Sorting_Recursive_InsertionSort {
    static int count=0;
    static ArrayList<Integer> InsertionSort(ArrayList<Integer> arr,int i,int j){
        if(i==arr.size()) return arr;

        if(j<0) return InsertionSort(arr, i+1, i);

        if(arr.get(j)>arr.get(j+1)){
            int temp=arr.get(j);
            arr.set(j,arr.get(j+1));
            arr.set(j+1,temp);
        }

        return InsertionSort(arr, i, j-1);
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        ArrayList<Integer> arr=new ArrayList<>();
        for(int i=0;i<n;i++) arr.add(sc.nextInt());

        System.out.println(arr);

        arr=InsertionSort(arr,1,0);
        System.out.println(count);
        System.out.println(arr);
    }
}
