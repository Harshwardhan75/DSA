import java.util.*;

public class Heap_SortKSortedArray {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int k=sc.nextInt();
        int[] arr=new int[n];

        for(int i=0;i<n;i++)
            arr[i]=sc.nextInt();
        
        System.out.println(SortKSorted(arr,k));
    }

    static ArrayList<Integer> SortKSorted(int[] arr,int k){
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        ArrayList<Integer> result=new ArrayList<>();

        for(int i: arr){
            pq.offer(i);
            if(pq.size()>k)
                result.add(pq.poll());
        }

        while(!pq.isEmpty())
            result.add(pq.poll());
        
        return result;
    }
}
