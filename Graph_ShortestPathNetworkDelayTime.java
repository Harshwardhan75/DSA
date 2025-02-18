import java.util.*;

public class Graph_ShortestPathNetworkDelayTime {
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
        }

        System.out.println(networkDelayTime(graph,2));
    }

    static int networkDelayTime(ArrayList<ArrayList<int[]>> graph,int k){
        int n=graph.size();
        int[] dist=new int[n];
        Arrays.fill(dist, (int)1e9);
        Queue<int[]> que=new LinkedList<>();
        que.offer(new int[]{k,0});
        dist[k]=0;
        int max=0;

        while(!que.isEmpty()){
            int node=que.peek()[0];
            int cost=que.peek()[1];
            que.poll();
            max=Math.max(max,cost);

            for(int[] i: graph.get(node)){
                int adj=i[0];
                int adjCost=i[1];

                if(cost+adjCost<dist[adj]){
                    dist[adj]=cost+adjCost;
                    que.offer(new int[]{adj,cost+adjCost});
                }
            }
        }

        return max!=(int)1e9?max:-1;
    }
}
