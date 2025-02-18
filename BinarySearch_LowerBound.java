import java.util.ArrayList;
import java.util.Scanner;

public class BinarySearch_LowerBound {

    static int LowerBound(ArrayList<Integer> arr,int target){
        int result=arr.size();
        int low=0,high=arr.size()-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(arr.get(mid)>=target){
                result=mid;
                high=mid-1;
            }
            else
                low=mid+1;
        }

        return result;
    }
    
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        ArrayList<Integer> arr=new ArrayList<>();

        for(int i=0;i<n;i++)    arr.add(sc.nextInt());
        
        int target=sc.nextInt();
        System.out.println(LowerBound(arr,target));
    }
}