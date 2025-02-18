import java.util.*;

public class Graph_MSTPrimsAlgorithm {
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
            int wt = sc.nextInt();
            graph.get(u).add(new int[] { v, wt });
            graph.get(v).add(new int[] { u, wt });
        }

        System.out.println(MinimumSpanningTree(n, graph));
        ArrayList<int[]> result = MinimumSpanningTreeFindPath(n, graph);

        for (int[] i : result) {
            System.out.println(i[0] + " " + i[1] + " " + i[2]);
        }
    }

    static ArrayList<int[]> MinimumSpanningTreeFindPath(int n, ArrayList<ArrayList<int[]>> graph) {
        boolean[] visited = new boolean[n];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        ArrayList<int[]> result = new ArrayList<>();

        pq.offer(new int[] { 0, -1, 0 });
        while (!pq.isEmpty()) {
            int node = pq.peek()[0];
            int parent = pq.peek()[1];
            int weight = pq.peek()[2];
            pq.poll();

            if (visited[node])
                continue;

            visited[node] = true;

            if (parent != -1)
                result.add(new int[] { parent, node, weight });

            for (int[] i : graph.get(node)) {
                int adj = i[0];
                int adjWeight = i[1];
                if (!visited[adj])
                    pq.offer(new int[] { adj, node, adjWeight });
            }
        }
        return result;
    }

    static int MinimumSpanningTree(int n, ArrayList<ArrayList<int[]>> graph) {
        boolean[] visited = new boolean[n];

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        int sum = 0;
        pq.offer(new int[] { 0, 0 });

        while (!pq.isEmpty()) {
            int node = pq.peek()[0];
            int weight = pq.peek()[1];
            pq.poll();
            if (visited[node])
                continue;

            visited[node] = true;
            sum += weight;
            for (int[] i : graph.get(node)) {
                int adj = i[0];
                int adjWeight = i[1];
                if (!visited[adj])
                    pq.offer(new int[] { adj, adjWeight });
            }
        }
        return sum;
    }
}
