import java.util.ArrayList;
import java.util.Scanner;

public class BinarySearch_SearchInsertPosition {

    static int Position(ArrayList<Integer> arr,int target){
        int low=0,high=arr.size()-1;
        int result=arr.size();

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
        System.out.println(Position(arr,target));
    }
}
