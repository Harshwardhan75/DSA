import java.util.*;

public class Heap_KClosestNumber {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int k=sc.nextInt();
        int x=sc.nextInt();
        int[] arr=new int[n];

        for(int i=0;i<n;i++)
            arr[i]=sc.nextInt();
        
        System.out.println(KClosest(arr,k,x));
    }

    static ArrayList<Integer> KClosest(int[] arr,int k,int x){
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->{
            int v=b[1]-a[1];
            if(v==0)
                v=a[0]-b[0];
            return v;
        });

        for(int i: arr){
            pq.offer(new int[]{i,Math.abs(i-x)});
            if(pq.size()>k)
                pq.poll();
        }

        ArrayList<Integer> result=new ArrayList<>();

        while(!pq.isEmpty())
            result.add(pq.poll()[0]);
        
        return result;
    }
}
