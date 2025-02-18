import java.util.*;

public class Graph_BFSDFSDetectCycleinDirectedGraph {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int e=sc.nextInt();
        ArrayList<ArrayList<Integer>> graph=new ArrayList<>();

        for(int i=0;i<=n;i++)
            graph.add(new ArrayList<>());

        for(int i=0;i<e;i++){
            int u=sc.nextInt();
            int v=sc.nextInt();

            graph.get(u).add(v);
        }

        System.out.println(isCycle(graph));
    }

    static boolean isCycle(ArrayList<ArrayList<Integer>> graph) {
        int n=graph.size();
        boolean[] visited=new boolean[n];
        boolean[] pathvisited=new boolean[n];

        for(int i=1;i<n;i++){
            if(!visited[i]){
                if(DFS(i,graph,visited,pathvisited))
                    return true;
            }
        }
        return false;
    }

    static boolean DFS(int node,ArrayList<ArrayList<Integer>> graph,boolean[] visited,boolean[] pathvisited){
        visited[node]=pathvisited[node]=true;

        for(int i: graph.get(node)){
            if(!visited[i]){
                if(DFS(i, graph, visited, pathvisited))
                    return true;
            }
            else
            if(pathvisited[i])
                return true;
        }

        return pathvisited[node]=false;
    }
    
}
