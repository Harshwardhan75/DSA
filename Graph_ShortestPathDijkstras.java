import java.util.*;

public class Graph_ShortestPathDijkstras {
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

        int[] result = DijkstraUsingPriorityQueue(graph, 0);
        for (int i : result)
            System.out.print(i + " ");
        System.out.println();
        int[] result1 = DijkstraUsingSet(graph, 0);
        for (int i : result1)
            System.out.print(i + " ");
    }

    static int[] DijkstraUsingSet(ArrayList<ArrayList<int[]>> graph, int src) {
        int n = graph.size();
        int[] dist = new int[n];
        Arrays.fill(dist, (int) 1e9);
        TreeSet<int[]> set = new TreeSet<>((a, b) -> {
            int v = a[1] - b[1];
            if (v == 0)
                v = a[0] - b[0];
            return v;
        });
        set.add(new int[] { src, 0 });
        dist[src] = 0;

        while (!set.isEmpty()) {
            int node = set.first()[0];
            int d = set.first()[1];
            set.pollFirst();

            for (int[] i : graph.get(node)) {
                if (d + i[1] < dist[i[0]]) {
                    if (dist[i[0]] != (int) 1e9)
                        set.remove(new int[] { i[1], dist[i[0]] });
                    dist[i[0]] = d + i[1];
                    set.add(new int[] { i[0], dist[i[0]] });
                }
            }
        }

        return dist;
    }

    static int[] DijkstraUsingPriorityQueue(ArrayList<ArrayList<int[]>> graph, int src) {
        int n = graph.size();

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);

        pq.offer(new int[] { src, 0 });
        int[] dist = new int[n];
        Arrays.fill(dist, (int) 1e9);
        dist[src] = 0;

        while (!pq.isEmpty()) {
            int node = pq.peek()[0];
            int d = pq.peek()[1];
            pq.poll();

            for (int[] i : graph.get(node)) {
                if (i[1] + d < dist[i[0]]) {
                    dist[i[0]] = d + i[1];
                    pq.offer(new int[] { i[0], d + i[1] });
                }
            }
        }

        return dist;
    }
}
