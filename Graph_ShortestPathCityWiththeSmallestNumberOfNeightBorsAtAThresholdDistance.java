import java.util.*;

public class Graph_ShortestPathCityWiththeSmallestNumberOfNeightBorsAtAThresholdDistance {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int e = sc.nextInt();
        int[][] edges = new int[e][];

        for (int i = 0; i < e; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int cost = sc.nextInt();

            edges[i] = new int[] { u, v, cost };
        }

        System.out.println(SmallestNumberOfNeightbors(n, edges, 4));
    }

    static int SmallestNumberOfNeightbors(int n, int[][] edges, int threshold) {
        int[][] dist = new int[n][n];
        for (int[] i : dist)
            Arrays.fill(i, Integer.MAX_VALUE);

        for (int[] e : edges) {
            dist[e[0]][e[1]] = e[2];
            dist[e[1]][e[0]] = e[2];
        }

        for (int i = 0; i < n; i++)
            dist[i][i] = 0;

        for (int via = 0; via < n; via++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (dist[i][via] == Integer.MAX_VALUE ||
                            dist[via][j] == Integer.MAX_VALUE)
                            continue;
                        dist[i][j] = Math.min(dist[i][j], dist[i][via] + dist[via][j]);
                }
            }
        }

        int cityNo = -1;
        int max = n;

        for (int i = 0; i < n; i++) {
            int cnt = 0;
            for (int j = 0; j < n; j++) {
                if (dist[i][j] <= threshold)
                    cnt++;
            }
            if (cnt <= max) {
                max = cnt;
                cityNo = i;
            }
        }

        return cityNo;
    }
}
