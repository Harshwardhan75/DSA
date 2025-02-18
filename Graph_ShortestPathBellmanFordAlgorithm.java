import java.util.*;

public class Graph_ShortestPathBellmanFordAlgorithm {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int e = sc.nextInt();
        int[][] edges = new int[e][];

        for (int i = 0; i < e; i++)
            edges[i] = new int[] { sc.nextInt(), sc.nextInt(), sc.nextInt() };

        int[] dist = BellmanFord(n, edges, 0);

        for (int i : dist)
            System.out.print(i + " ");
        System.out.println();
    }

    static int[] BellmanFord(int n, int[][] edges, int src) {
        int[] dist = new int[n];
        Arrays.fill(dist, (int) 1e9);
        dist[src] = 0;

        for (int via = 1; via <= n - 1; via++) {
            for (int[] e : edges) {
                int u = e[0];
                int v = e[1];
                int wt = e[2];

                if (dist[u] + wt < dist[v]) {
                    dist[v] = wt + dist[u];
                }
            }
        }

        for (int[] e : edges) {
            int u = e[0];
            int v = e[1];
            int wt = e[2];

            if (dist[u] + wt < dist[v]) {
                return new int[]{-1};
            }
        }

        return dist;
    }
}
