import java.util.ArrayList;
import java.util.Scanner;

public class Sorting_SelectionSort {

    static ArrayList<Integer> SelectionSort(ArrayList<Integer> arr){
        for(int i=0;i<arr.size()-1;i++){
            int min=i;
            for(int j=i+1;j<arr.size();j++)
                if(arr.get(j)<arr.get(min))
                    min=j;
            
            int temp=arr.get(min);
            arr.set(min,arr.get(i));
            arr.set(i,temp);
        }
        return arr;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        ArrayList<Integer> arr=new ArrayList<>();
        for(int i=0;i<n;i++)
            arr.add(sc.nextInt());
        
        System.out.println(arr);

        arr=SelectionSort(arr);

        System.out.println(arr);
    }
}
