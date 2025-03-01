import java.util.*;
import javax.naming.spi.DirStateFactory;

public class Heap_FrequencySort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        
        System.out.println(FrequencySort(arr));
    }

    static ArrayList<Integer> FrequencySort(int[] arr){
        Map<Integer,Integer> map=new HashMap<>();
        for(int i: arr){
            map.compute(i, (key,value)->value==null?1:value+1);
        }

        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->{
            int v=b[1]-a[1];
            if(v==0)
                v=a[0]-b[0];
            return v;
        });

        for(int i: map.keySet()){
            pq.offer(new int[]{i,map.get(i)});
        }

        ArrayList<Integer> result=new ArrayList<>();

        while(!pq.isEmpty()){
            int n=pq.peek()[0];
            int freq=pq.peek()[1];
            pq.poll();

            while(freq-->0)
                result.add(n);
        }
        return result;        
    }
}
