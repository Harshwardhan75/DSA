import java.util.*;

public class Graph_ShortestPathShortestPathinWeightedUndirected {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        ArrayList<ArrayList<int[]>> graph=new ArrayList<>();
        for(int i=0;i<=n;i++)   
            graph.add(new ArrayList<>());
        
        int e=sc.nextInt();

        for(int i=0;i<e;i++){
            int u=sc.nextInt();
            int v=sc.nextInt();
            int c=sc.nextInt();
            graph.get(u).add(new int[]{v,c});
            graph.get(v).add(new int[]{u,c});
        }

        System.out.println(ShortestPath(graph,1,n));
    }

    static ArrayList<Integer> ShortestPath(ArrayList<ArrayList<int[]>> graph,int src,int dest){
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[1]-b[1]);
        int n=graph.size();
        pq.offer(new int[]{src,0});
        int[] parent=new int[n];
        int[] dist=new int[n];
        for(int i=0;i<n;i++)
            parent[i]=i;
        Arrays.fill(dist,(int)1e9);
        dist[src]=0;
        while(!pq.isEmpty()){
            int node=pq.peek()[0];
            int d=pq.peek()[1];
            pq.poll();

            for(int[] i: graph.get(node)){
                if(i[1]+d<dist[i[0]]){
                    dist[i[0]]=i[1]+d;
                    parent[i[0]]=node;
                    pq.offer(new int[]{i[0],i[1]+d});
                }
            }
        }

        ArrayList<Integer> result=new ArrayList<>();

        int node=dest;

        while(parent[node]!=node){
            result.add(node);
            node=parent[node];
        }
        result.add(node);
        Collections.reverse(result);
        return result;
    }
}
