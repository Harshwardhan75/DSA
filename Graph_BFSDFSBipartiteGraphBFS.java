import java.util.*;

public class Graph_BFSDFSBipartiteGraphBFS {
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
                if(!BFS(i,color,graph))
                    return false;
            }
        }

        return true;
    }

    static boolean BFS(int start,int[] color,int[][] graph){
        Queue<Integer> que=new LinkedList<>();
        que.offer(start);
        color[start]=0;

        while(!que.isEmpty()){
            int node=que.poll();

            for(int i: graph[node]){
                if(color[i]==-1){
                    color[i]=1-color[node];
                    que.offer(i);
                }
                else
                if(color[i]==color[node])
                    return false;
            }
        }

        return true;
    }
}
