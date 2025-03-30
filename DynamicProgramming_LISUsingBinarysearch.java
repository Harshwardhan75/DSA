import java.util.ArrayList;
import java.util.Scanner;

public class DynamicProgramming_LISUsingBinarysearch {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++)
            arr[i]=sc.nextInt();
        
        System.out.println(LongestIncreasingSubsequence(arr));
    }

    static int LongestIncreasingSubsequence(int[] arr){
        int n=arr.length;
        ArrayList<Integer> temp=new ArrayList<>();
        temp.add(arr[0]);

        for(int i=1;i<n;i++){
            if(temp.get(temp.size()-1)<arr[i])
                temp.add(arr[i]);
            else{
                int index = lower_bound(temp,arr[i]);
                temp.set(index, arr[i]);
            }
        }
        return temp.size();
    }

    static int lower_bound(ArrayList<Integer> temp,int key){
        int low = 0 ,high = temp.size()-1;

        while(low<=high){
            int mid=(low+high)>>1;

            if(temp.get(mid)>=key)
                high=mid-1;
            else
                low=mid+1;
        }
        return low;
    }
}
