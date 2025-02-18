import java.util.ArrayList;
import java.util.Scanner;

public class Sorting_Recursive_BubbleSort {
    static int count=0;
    static ArrayList<Integer> BubbleSort(ArrayList<Integer> arr,int i,int j,boolean isSwap){
        if(i==arr.size()-1 || !isSwap) return arr;

        if(j==arr.size()-i-1){
            if(!isSwap)
                return arr;
            else
                return BubbleSort(arr,i+1,0,false);
        }
        if(arr.get(j)>arr.get(j+1)){
            int temp=arr.get(j);
            arr.set(j,arr.get(j+1));
            arr.set(j+1,temp);
            isSwap=true;
        }
        count++;
        return BubbleSort(arr, i, j+1,isSwap);
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        ArrayList<Integer> arr=new ArrayList<>();
        for(int i=0;i<n;i++)    arr.add(sc.nextInt());

        System.out.println(arr);

        arr=BubbleSort(arr,0,0,true);
        System.out.println(count);
        System.out.println(arr);
    }
}