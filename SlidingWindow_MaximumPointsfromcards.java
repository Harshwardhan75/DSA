import java.util.Scanner;

public class SlidingWindow_MaximumPointsfromcards {

    static int MaximumPoint(int[] arr,int k){
        int lsum=0,rsum=0;
        int max=0;
        for(int i=0;i<k;i++)
            lsum+=arr[i];
        
        max=lsum;
        int r=arr.length-1;
        for(int l=k-1;l>=0;l--){
            lsum-=arr[l];
            rsum+=arr[r];
            r--;
            max=Math.max(max,lsum+rsum);
        }
        return max;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int k=sc.nextInt();
        int[] arr=new int[n];

        for(int i=0;i<n;i++)
            arr[i]=sc.nextInt();
        
            
        System.out.println(MaximumPoint(arr,k));
    }    
}
