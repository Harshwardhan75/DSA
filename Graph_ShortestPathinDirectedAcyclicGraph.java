import java.util.*;

public class Graph_ShortestPathinDirectedAcyclicGraph {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        ArrayList<ArrayList<int[]>> graph=new ArrayList<>();

        for(int i=0;i<n;i++)
            graph.add(new ArrayList<>());
        
        int e=sc.nextInt();

        for(int i=0;i<e;i++){
            int u=sc.nextInt();
            int v=sc.nextInt();
            int c=sc.nextInt();
            graph.get(u).add(new int[]{v,c});
        }

        int[] result=findShortestPath(graph);
        for(int i: result)
            System.out.print(i+" ");

    }

    static int[] findShortestPath(ArrayList<ArrayList<int[]>> graph){
        int n=graph.size();

        Stack<Integer> st=findTopoSort(graph);

        int[] result=new int[n];
        Arrays.fill(result,(int)1e9);
        result[0]=0;

        while(!st.isEmpty()){
            int node=st.pop();

            for(int[] i: graph.get(node)){
                if(i[1]+result[node]<result[i[0]]){
                    result[i[0]]=i[1]+result[node];
                }
            }
        }

        return result;
    }

    static Stack<Integer> findTopoSort(ArrayList<ArrayList<int[]>> graph){
        int n=graph.size();
        Stack<Integer> stack=new Stack<>();

        boolean[] visited=new boolean[n];
        for(int i=0;i<n;i++){
            if(!visited[i]){
                DFS(graph,visited,i,stack);
            }
        }

        return stack;
    }

    static void DFS(ArrayList<ArrayList<int[]>> graph,boolean[] visited,int node,Stack<Integer> stack){
        visited[node]=true;

        for(int[] i: graph.get(node)){
            if(!visited[i[0]]){
                DFS(graph, visited, i[0], stack);
            }
        }

        stack.push(node);
    }
    
}