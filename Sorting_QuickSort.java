import java.util.ArrayList;
import java.util.Scanner;

public class Sorting_QuickSort {

    static int Quick(ArrayList<Integer> arr,int low,int high){
        int pivot=arr.get(low);
        int l=low;
        int r=high;
        while(l<=r){
            while(l<=r && arr.get(l)<=pivot) l++;
            while(l<=r && arr.get(r)>pivot) r--;

            if(l<r){
                int temp=arr.get(l);
                arr.set(l,arr.get(r));
                arr.set(r,temp);
            }
        }
        arr.set(low,arr.get(r));
        arr.set(r,pivot);

        return r;
    }

    static void QuickSort(ArrayList<Integer> arr,int low,int high){
        if(low>=high)   return ;

        int pivot=Quick(arr,low,high);
        QuickSort(arr,low,pivot-1);
        QuickSort(arr, pivot+1, high);

        return;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        ArrayList<Integer> arr=new ArrayList<>();

        for(int i=0;i<n;i++)    arr.add(sc.nextInt());

        System.out.println(arr);

        QuickSort(arr,0,arr.size()-1);

        System.out.println(arr);
    }
}
