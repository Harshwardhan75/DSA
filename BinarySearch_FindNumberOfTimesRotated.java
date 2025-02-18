import java.util.ArrayList;
import java.util.Scanner;

public class BinarySearch_FindNumberOfTimesRotated {

    static int FindRotation(ArrayList<Integer> arr){
        int low=0,high=arr.size()-1;
        int index=-1,minresult=Integer.MAX_VALUE;

        while(low<=high){
            int mid=(low+high)/2;

            if(arr.get(low)<=arr.get(mid)){
                if(arr.get(low)<minresult){
                    minresult=arr.get(low);
                    index=low;
                }
                low=mid+1;
            }
            else{
                if(arr.get(mid)<minresult){
                    minresult=arr.get(mid);
                    index=mid;
                }
                high=mid-1;
            }
        }

        return index;
    }
    
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        ArrayList<Integer> arr=new ArrayList<>();
        for(int i=0;i<n;i++)    arr.add(sc.nextInt());

        System.out.println(FindRotation(arr));
    }
}