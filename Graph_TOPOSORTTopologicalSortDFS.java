import java.util.*;

public class Graph_TOPOSORTTopologicalSortDFS {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int e=sc.nextInt();
        ArrayList<ArrayList<Integer>> graph=new ArrayList<>();

        for(int i=0;i<n;i++)
            graph.add(new ArrayList<>());

        for(int i=0;i<e;i++){
            int u=sc.nextInt();
            int v=sc.nextInt();

            graph.get(u).add(v);
        }

        System.out.println(TopologicalSort(graph));
    }

    static ArrayList<Integer> TopologicalSort(ArrayList<ArrayList<Integer>> graph){
        int n=graph.size();
        boolean[] visited=new boolean[n];
        Stack<Integer> st=new Stack<>();

        for(int i=0;i<n;i++){
            if(!visited[i]){
                DFS(i,graph,visited,st);
            }
        }

        ArrayList<Integer> result=new ArrayList<>(st);
        Collections.reverse(result);
        return result;
    }

    static void DFS(int node,ArrayList<ArrayList<Integer>> graph,boolean[] visited,Stack<Integer> st){
        visited[node]=true;

        for(int i: graph.get(node)){
            if(!visited[i]){
                DFS(i, graph, visited, st);
            }
        }

        st.push(node);
    }
}
