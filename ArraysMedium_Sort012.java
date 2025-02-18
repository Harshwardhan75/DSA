import java.util.ArrayList;
import java.util.Scanner;

public class ArraysMedium_Sort012 {
    
    static void sort012(ArrayList<Integer> arr){
        int low=-1,mid=0,high=arr.size()-1;

        while(mid<=high){
            if(arr.get(mid)==0){
                low++;
                int temp=arr.get(mid);
                arr.set(mid,arr.get(low));
                arr.set(low,temp);
                mid++;
            }
            else if(arr.get(mid)==2){
                int temp=arr.get(mid);
                arr.set(mid,arr.get(high));
                arr.set(high,temp);
                high--;
            }
            else mid++;
        }
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        ArrayList<Integer> arr=new ArrayList<>();
        for(int i=0;i<n;i++)    arr.add(sc.nextInt());

        System.out.println(arr);
        sort012(arr);
        System.out.println(arr);
    }
}
