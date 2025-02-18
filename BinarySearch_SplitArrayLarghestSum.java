import java.util.Arrays;
import java.util.Scanner;

//Same as Book Allocation
public class BinarySearch_SplitArrayLarghestSum {

    static int countsubarray(int[] arr,int maxcap){
        int currentsubcount=0;
        int totalsubarray=1;

        for(int i=0;i<arr.length;i++){
            if(currentsubcount+arr[i]<=maxcap)
                currentsubcount+=arr[i];
            else{
                currentsubcount=arr[i];
                totalsubarray++;
            }
        }

        return totalsubarray;
    }

    static int BruteSplitArraySum(int []arr,int k){
        int min=Arrays.stream(arr).max().orElseThrow();
        int max=Arrays.stream(arr).sum();

        for(int i=min;i<=max;i++){
            if(countsubarray(arr,i)==k)
                return i;
        }
        
        return min;
    }

    static int OptimalSplitArraySum(int []arr,int k){
        int min=Arrays.stream(arr).max().orElseThrow();
        int max=Arrays.stream(arr).sum();
        int low=min,high=max;

        while(low<=high){
            int mid=low+(high-low)/2;
            if(countsubarray(arr,mid)<=k)
                high=mid-1;
            else
                low=mid+1;
        }
        return low;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int k=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++)    arr[i]=sc.nextInt();

        System.out.println(OptimalSplitArraySum(arr,k));
    }
}