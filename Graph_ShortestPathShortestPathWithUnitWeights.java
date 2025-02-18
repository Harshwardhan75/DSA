import java.util.*;

public class Graph_ShortestPathShortestPathWithUnitWeights {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        ArrayList<ArrayList<Integer>> graph=new ArrayList<>();

        for(int i=0;i<n;i++)
            graph.add(new ArrayList<>());
        
        int e=sc.nextInt();
        
        for(int i=0;i<e;i++){
            int u=sc.nextInt();
            int v=sc.nextInt();

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        int[] result=findShortestPath(graph,2);

        for(int i: result)
            System.out.print(i+" ");
        System.out.println("");
    }

    static int[] findShortestPath(ArrayList<ArrayList<Integer>> graph,int src){
        Queue<Integer> que=new LinkedList<>();
        int n=graph.size();
        int[] result=new int[n];
        Arrays.fill(result, -1);

        que.offer(src);
        result[src]=0;

        while(!que.isEmpty()){
            int node=que.poll();

            for(int i: graph.get(node)){
                if(result[i]==-1){
                    result[i]=1+result[node];
                    que.offer(i);
                }
            }
        }

        return result;
    }
}
