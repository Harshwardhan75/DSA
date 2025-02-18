import java.util.Arrays;
import java.util.Scanner;

public class BinarySearch_AggresiveCows {

    static boolean canweplace(int[] arr,int cows,int dist){
        int cow=1,lastp=arr[0];

        for(int i=1;i<arr.length;i++){
            if(arr[i]-lastp>=dist){
                cow++;
                lastp=arr[i];
            }
        }

        if(cow>=cows)
            return true;
        else
            return false;
    }

    static int BruteAggresiveCows(int[] arr,int cows){
        Arrays.sort(arr);
        int x=Arrays.stream(arr).max().orElseThrow()-Arrays.stream(arr).min().orElseThrow();
        for(int i=1;i<=x;i++){
            if(canweplace(arr,cows,i))
                continue;
            else
                return i-1;
        }
        return -1;
    }

    static int OptimalAggresiveCows(int[] arr,int cows){
        int low=1,high=Arrays.stream(arr).max().orElseThrow()-Arrays.stream(arr).min().orElseThrow();

        while(low<=high){
            int mid=(low+high)/2;
            if(canweplace(arr, cows, mid))
                low=mid+1;
            else
                high=mid-1;
        }

        return high;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int cows=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++)    arr[i]=sc.nextInt();

        System.out.println(OptimalAggresiveCows(arr,cows));
    }
}