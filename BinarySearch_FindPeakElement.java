import java.util.ArrayList;
import java.util.Scanner;

public class BinarySearch_FindPeakElement {

    static int PeakElement(ArrayList<Integer> arr){
        int n=arr.size();
        if(n==1)   return 0;
        if(arr.get(0)>arr.get(1))   return 0;
        if(arr.get(n-1)>arr.get(n-2))   return n-1;
        int low=1,high=n-2;

        while(low<=high){
            int mid=low+(high-low)/2;
            if(arr.get(mid-1)<arr.get(mid) && arr.get(mid)>arr.get(mid+1))      
                return mid;
            else if(arr.get(mid)<arr.get(mid+1))
                low=mid+1;
            else
                high=mid-1;
        }

        return -1;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        ArrayList<Integer> arr=new ArrayList<>();
        for(int i=0;i<n;i++)    arr.add(sc.nextInt());

        System.out.println(PeakElement(arr));
    }
}