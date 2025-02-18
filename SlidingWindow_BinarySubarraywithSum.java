import java.util.*;

public class SlidingWindow_BinarySubarraywithSum {

    static int smallerequalsubarray(int[] arr,int goal){
        if(goal<0)  return 0;
        int l=0,r=0,sum=0,count=0;
        int n=arr.length;

        while(r<n){
            sum+=arr[r];
            while(l<=r && sum>goal)
                sum-=arr[l++];
            
            count+=(r-l+1);
            r++;
        }

        return count;
    }


    static int OptimalSubarraywithgoal(int[] arr,int goal){
        return smallerequalsubarray(arr,goal)-smallerequalsubarray(arr,goal-1);
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int goal=sc.nextInt();
        int[] arr=new int[n];

        for(int i=0;i<n;i++)
            arr[i]=sc.nextInt();

        System.out.println(OptimalSubarraywithgoal(arr,goal));
    }
}
