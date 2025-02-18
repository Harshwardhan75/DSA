import java.util.ArrayList;
import java.util.Scanner;

public class BinarySearch {

    static int BinarySearch(ArrayList<Integer> arr,int target){
        int low=0,high=arr.size()-1;

        while(low<=high){
            int mid=low+(high-low)/2;

            if(arr.get(mid)==target)
                return mid;
            else if(arr.get(mid)<target)
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
        
        int target=sc.nextInt();
        System.out.println(BinarySearch(arr,target));
    }
}
