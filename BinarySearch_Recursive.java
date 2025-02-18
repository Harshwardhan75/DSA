import java.util.ArrayList;
import java.util.Scanner;

public class BinarySearch_Recursive {

    static int RecursiveBS(ArrayList<Integer> arr,int low,int high,int target){
        if(low>high)
            return -1;
        
        int mid=low+(high-low)/2;
        if(arr.get(mid)==target)
            return mid;
        else if(arr.get(mid)<target)
            return RecursiveBS(arr, mid+1, high, target);
        else
            return RecursiveBS(arr, low, mid-1, target);
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        ArrayList<Integer> arr=new ArrayList<>();

        for(int i=0;i<n;i++)    arr.add(sc.nextInt());
        
        int target=sc.nextInt();
        System.out.println(RecursiveBS(arr,0,arr.size()-1,target));
    }
}
