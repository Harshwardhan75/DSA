import java.util.*;

public class Graph_BridgeInGraphArticulationPoint {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        ArrayList<Integer>[] graph=new ArrayList[n];
        for(int i=0;i<n;i++)
            graph[i]=new ArrayList<>();

        int e=sc.nextInt();
        for(int i=0;i<e;i++){
            int u=sc.nextInt();
            int v=sc.nextInt();
            graph[u].add(v);
            graph[v].add(u);
        }

        System.out.println(ArticulationPoint(graph));
    }

    static ArrayList<Integer> ArticulationPoint(ArrayList<Integer>[] graph){
        int n=graph.length;
        int[] tin=new int[n];
        int[] low=new int[n];
        boolean[] visited=new boolean[n];
        Set<Integer> set=new HashSet<>();

        DFS(graph,tin,low,visited,0,-1,set);

        ArrayList<Integer> arr=new ArrayList<>(set);
        Collections.sort(arr);
        return arr;
    }

    static int time=1;

    static void DFS(ArrayList<Integer>[] graph,int[] tin,
    int[] low,boolean[] visited,int node,int parent,Set<Integer> set){
        tin[node]=low[node]=time++;
        visited[node]=true;
        int child=0;
        for(int i: graph[node]){
            if(!visited[i]){
                DFS(graph, tin, low, visited, i, node, set);

                low[node]=Math.min(low[node],low[i]);
                child++;
                if(tin[node]<=low[node]){
                    set.add(node);
                }
            }
            else{
                low[node]=Math.min(low[node],tin[i]);
            }
        }

        if(child>1 && parent!=-1)
            set.add(node);
    }
}
