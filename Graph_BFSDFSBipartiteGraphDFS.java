import java.util.*;

public class Graph_BFSDFSBipartiteGraphDFS {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[][] graph = new int[n + 1][];

        for (int i = 1; i <= n; i++) {
            int e = sc.nextInt();
            int[] arr = new int[e];

            for (int j = 0; j < e; j++)
                arr[j] = sc.nextInt();

            graph[i] = arr;
        }

        System.out.println(isBipartite(graph));
    }

    static boolean isBipartite(int[][] graph){
        int n=graph.length;
        int[] color=new int[n];
        Arrays.fill(color, -1);
        for(int i=1;i<n;i++){
            if(color[i]==-1){   
                if(!DFS(i,color,graph,0))
                    return false;
            }
        }

        return true;
    }

    static boolean DFS(int start,int[] color,int[][] graph,int newColor){
        color[start]=newColor;

        for(int i: graph[start]){
            if(color[i]==-1){
                if(!DFS(i,color,graph,1-color[start]))
                    return false;
            }
            else
            if(color[i]==color[start])
                return false;
        }

        return true;
    }
}
