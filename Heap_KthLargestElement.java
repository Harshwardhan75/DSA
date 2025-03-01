import java.util.*;

public class Heap_KthLargestElement {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int k=sc.nextInt();

        int[] arr=new int[n];

        for(int i=0;i<n;i++)
            arr[i]=sc.nextInt();

        System.out.println(kthLargest(arr,k));
    }

    static int kthLargest(int[] arr,int k){
        PriorityQueue<Integer> pq=new PriorityQueue<>();

        for(int i: arr){
            pq.offer(i);
            if(pq.size()>k)
                pq.poll();
        }
        return pq.peek();
    }
}
