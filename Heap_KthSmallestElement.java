import java.util.*;

public class Heap_KthSmallestElement {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int k=sc.nextInt();

        int[] arr=new int[n];

        for(int i=0;i<n;i++)
            arr[i]=sc.nextInt();

        System.out.println(kthSmallest(arr,k));
    }

    static int kthSmallest(int[] arr,int k){
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->b-a);

        for(int i: arr){
            pq.offer(i);
            if(pq.size()>k)
                pq.poll();
        }
        return pq.peek();
    }
}
