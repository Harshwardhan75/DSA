import java.util.Scanner;

public class StackQueue_TrappingRainWater {

    static int BruteTrappingRainWater(int[] arr){
        int n=arr.length;
        int total=0;

        for(int i=0;i<n;i++){
            int leftmax=0,rightmax=0;

            for(int j=i-1;j>=0;j--)
                leftmax=Math.max(leftmax,arr[j]);
            
            for(int j=i+1;j<n;j++)
                rightmax=Math.max(rightmax, arr[j]);
            
            if(leftmax>arr[i] && rightmax>arr[i])
                total+=Math.min(leftmax, rightmax)-arr[i];
        }
        return total;
    }

    static int OptimalTrappingRainWater(int[] arr){
        int total=0;
        int leftmax=0,rightmax=0;
        int n=arr.length;
        int l=0,r=n-1;
        while(l<r){
            if(arr[l]<arr[r]){
                if(leftmax>arr[l])
                    total+=(leftmax-arr[l]);
                else
                    leftmax=arr[l];
                l++;
            }
            else{
                if(rightmax>arr[r])
                    total+=(rightmax-arr[r]);
                else
                    rightmax=arr[r];
                r--;
            }
        }

        return total;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++)
            arr[i]=sc.nextInt();
        
        System.out.println(OptimalTrappingRainWater(arr));
    }
}
