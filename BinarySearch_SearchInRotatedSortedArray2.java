import java.util.ArrayList;
import java.util.Scanner;

public class BinarySearch_SearchInRotatedSortedArray2 {

    static boolean SearchinRotatedSorted(ArrayList<Integer> arr,int x){
        int low=0,high=arr.size()-1;

        while(low<=high){
            int mid=(low+high)/2;

            if(arr.get(mid)==x)
                return true;
            
            if(arr.get(low)==arr.get(mid) && arr.get(mid)==arr.get(high)){
                low++;
                high--;
                continue;
            }

            //Left is Sorted
            if(arr.get(low)<=arr.get(mid)){
                if(arr.get(low)<=x && x<=arr.get(mid))
                    high=mid-1;
                else
                    low=mid+1;
            }
            else//Right is Sorted
            {
                if(arr.get(mid)<=x && x<=arr.get(high))
                    low=mid+1;
                else
                    high=mid-1;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        ArrayList<Integer> arr=new ArrayList<>();
        int x=sc.nextInt();
        for(int i=0;i<n;i++)    arr.add(sc.nextInt());

        System.out.println(SearchinRotatedSorted(arr,x));
    }
}
