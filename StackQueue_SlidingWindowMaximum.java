import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Scanner;

public class StackQueue_SlidingWindowMaximum {

    static ArrayList<Integer> BrutemaxSlidingWindow(int[] arr,int k){
        ArrayList<Integer> result=new ArrayList<>();
        for(int i=0;i<=arr.length-k;i++){
            int max=-1;
            for(int j=i;j<i+k;j++)
                max=Math.max(max,arr[j]);
            result.add(max);
        }
        return result;
    }
    static ArrayList<Integer> OptimalmaxSlidingWindow(int[] arr,int k){
        ArrayList<Integer> result=new ArrayList<>();
        Deque<Integer> dq=new ArrayDeque<>();
        for(int i=0;i<arr.length;i++){
            if(!dq.isEmpty() && i-dq.peekFirst()>=k)
                dq.pollFirst();
            while(!dq.isEmpty() && arr[dq.peekLast()]<=arr[i])
                dq.pollLast();
            dq.offerLast(i);
            if(i>=k-1)
                result.add(arr[dq.peekFirst()]);
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int k=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++)
            arr[i]=sc.nextInt();
        
        System.out.println(BrutemaxSlidingWindow(arr,k));
        System.out.println(OptimalmaxSlidingWindow(arr,k));
    }
}
