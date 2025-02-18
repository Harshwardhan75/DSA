import java.util.*;

public class Graph_BridgeInGraphCriticalConnectsionInGraph {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int e = sc.nextInt();
        int[][] connections = new int[e][];

        for (int i = 0; i < e; i++) {
            connections[i] = new int[] { sc.nextInt()-1,
                    sc.nextInt()-1 };
        }

        System.out.println(CriticalConnections(n,connections));
    }

    static ArrayList<List<Integer>> CriticalConnections(int n,int[][] connections){
        int[] tin=new int[n];
        int[] low=new int[n];
        boolean[] visited=new boolean[n];
        ArrayList<Integer>[] graph=new ArrayList[n];
        for(int i=0;i<n;i++)
            graph[i]=new ArrayList<>();

        for(int[] i: connections){
            graph[i[0]].add(i[1]);
            graph[i[1]].add(i[0]);
        }
        
        ArrayList<List<Integer>> result=new ArrayList<>();

        DFS(graph,tin,low,0,-1,result,visited);
        return result;
    }

    static int time=1;

    static void DFS(ArrayList<Integer>[] graph,int[] tin,
    int[] low,int node,int parent,ArrayList<List<Integer>> result,boolean[] visited){
        tin[node]=low[node]=time;
        visited[node]=true;
        time++;

        for(int i: graph[node]){
            if(i==parent)   continue;

            if(!visited[i]){
                DFS(graph, tin, low, i, node, result, visited);
                low[node]=Math.min(low[node], low[i]);
                
                if(tin[node]<low[i]){
                    result.add(Arrays.asList(node+1,i+1));
                }
            }
            else{
                low[node]=Math.min(low[node], low[i]);
            }
        }
    }
}
