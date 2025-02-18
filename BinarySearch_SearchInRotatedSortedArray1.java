import java.util.*;

public class BinarySearch_SearchInRotatedSortedArray1 {

    static int SearchinRotatedSorted(ArrayList<Integer> arr,int x){
        int low=0,high=arr.size()-1;

        while(low<=high){
            int mid=low+(high-low)/2;
            if(arr.get(mid)==x)
                return mid;
            else //Check ifLeftisSorted
            if(arr.get(low)<=arr.get(mid)){
                if(arr.get(low)<=x && x<=arr.get(mid))
                    high=mid-1;
                else
                    low=mid+1;
            }
            else{
                if(arr.get(mid)<=x && x<=arr.get(high))
                    low=mid+1;
                else
                    high=mid-1;
            }
        }

        return -1;
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
