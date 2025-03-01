import java.util.*;

public class Heap_KClosestPointsToOrigin {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int k=sc.nextInt();
        int[][] points=new int[n][];

        for(int i=0;i<n;i++)    
            points[i]=new int[]{sc.nextInt(),sc.nextInt()};
        
        System.out.println(kClosestPoints(points,k));
    }

    static ArrayList<List<Integer>> kClosestPoints(int[][] points,int k){
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->{
            int ad=a[0]*a[0]+a[1]*a[1];
            int bd=b[0]*b[0]+b[1]*b[1];
            return bd-ad;
        });

        for(int[] p: points)
        {
            pq.offer(p);
            if(pq.size()>k)
                pq.poll();
        }

        ArrayList<List<Integer>> result=new ArrayList<>();

        while(!pq.isEmpty()){
            int[] p=pq.poll();

            result.add(Arrays.asList(p[0],p[1]));
        }
        return result;
    }
}
