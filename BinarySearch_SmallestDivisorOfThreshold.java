import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class BinarySearch_SmallestDivisorOfThreshold {

    static boolean possible(ArrayList<Integer> arr,int threshold,int div){
        int totalthreshold=0;
        for(int i=0;i<arr.size();i++)
            totalthreshold+=Math.ceil((double)arr.get(i)/(double)div);
        
        if(totalthreshold<=threshold)
            return true;
        else
            return false;
    }

    static int BruteFindSmallestDivisor(ArrayList<Integer> arr,int threshold){
        for(int i=1;i<=Collections.max(arr);i++){
            if(possible(arr,threshold,i))
                return i;
        }

        return -1;
    }

    static int OptimalFindSmallestDivisor(ArrayList<Integer> arr,int threshold){
        int low=1,high=Collections.max(arr);
        int ans=-1;

        while(low<=high){
            int mid=(low+high)/2;
            if(possible(arr, threshold, mid)){
                ans=mid;
                high=mid-1;
            }
            else
                low=mid+1;
        }

        return ans;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int threshold=sc.nextInt();
        ArrayList<Integer> arr=new ArrayList<>();

        for(int i=0;i<n;i++)    arr.add(sc.nextInt());

        System.out.println(OptimalFindSmallestDivisor(arr,threshold));
    }
}
