import java.util.Scanner;

public class BinarySearch_FindKthMissingNumber {

    static int BruteFindKth(int[] arr,int k){
        for(int i=0;i<arr.length;i++){
            if(arr[i]<=k)
                k++;
            else
                break;
        }
        return k;
    }

    static int OptimalFindKth(int arr[],int k){
        int low=0,high=arr.length-1;
        while(low<=high){
            int mid=(low+high)/2;
            if(arr[mid]-(mid+1)<k)
                low=mid+1;
            else
                high=mid-1;
        }

        return low+k;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];
        int k=sc.nextInt();
        for(int i=0;i<n;i++)    arr[i]=sc.nextInt();

        System.out.println(OptimalFindKth(arr,k));
    }
}