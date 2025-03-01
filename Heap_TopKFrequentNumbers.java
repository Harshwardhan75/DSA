import java.util.*;

public class Heap_TopKFrequentNumbers {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int k=sc.nextInt();
        int[] arr=new int[n];

        for(int i=0;i<n;i++)
            arr[i]=sc.nextInt();
        
        System.out.println(TopKFrequentNumbers(arr,k));
    }

    static ArrayList<Integer> TopKFrequentNumbers(int[] arr,int k){
        Map<Integer,Integer> map=new HashMap<>();
        for(int i: arr){
            map.compute(i, (key,value)->value==null?1:value+1);
        }

        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->{
            int v= map.get(a)-map.get(b);
            if(v==0)
                v=a-b;
            return v;
        });

        for(int i: map.keySet()){
            pq.offer(i);
            if(pq.size()>k)
                pq.poll();
        }

        return new ArrayList<>(pq);
    }
}
