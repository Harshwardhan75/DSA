import java.util.*;

public class Graph_ShortestPathNoOfWaystoArriveAtDestination {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<ArrayList<int[]>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++)
            graph.add(new ArrayList<>());

        int e = sc.nextInt();

        for (int i = 0; i < e; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int c = sc.nextInt();
            graph.get(u).add(new int[] { v, c });
            graph.get(v).add(new int[] { u, c });
        }

        System.out.println(NumberOfWays(graph, 0, 6));
    }

    static int NumberOfWays(ArrayList<ArrayList<int[]>> graph, int src, int dst) {
        int n = graph.size();
        int[] ways = new int[n];
        int[] dist = new int[n];
        Arrays.fill(dist, (int) 1e9);
        ways[src] = 1;
        dist[src] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.offer(new int[] { src, 0 });

        while (!pq.isEmpty()) {
            int node = pq.peek()[0];
            int d = pq.peek()[1];
            pq.poll();

            for (int[] i : graph.get(node)) {
                int adj = i[0];
                int adjdist = i[1];
                if (d + adjdist < dist[adj]) {
                    dist[adj] = adjdist + d;
                    ways[adj] = ways[node];
                    pq.offer(new int[] { adj, dist[adj] });
                }
                else if(d + adjdist == dist[adj])
                    ways[adj]+=ways[node];
            }
        }

        return ways[dst];
    }
}
