import java.util.*;

public class Heap_ConnectRopesToMinimizeTheCost {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];

        for(int i=0;i<n;i++)
            arr[i]=sc.nextInt();
        
        System.out.println(minimumCost(arr));
    }

    static int minimumCost(int[] arr){
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        for(int i: arr)
            pq.offer(i);
        
        int sum=0;

        while(pq.size()>1){
            int a=pq.poll();
            int b=pq.poll();
            sum+=a+b;
            pq.offer(a+b);
        }
        return sum;
    }
}
