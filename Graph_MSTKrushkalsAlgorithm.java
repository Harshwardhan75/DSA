import java.util.*;

public class Graph_MSTKrushkalsAlgorithm {

    static class DisjointSet {
        int[] size;
        int[] parent;

        DisjointSet(int n) {
            size = new int[n];
            parent = new int[n];

            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        int findUltimateParent(int node) {
            if (node == parent[node])
                return node;

            return parent[node] = findUltimateParent(parent[node]);
        }

        void unionBySize(int u, int v) {
            int upu = findUltimateParent(u);
            int upv = findUltimateParent(v);

            if (upu == upv)
                return;

            if (size[upu] < size[upv]) {
                parent[upu] = upv;
                size[upv] += size[upu];
            } else {
                parent[upv] = upu;
                size[upu] += size[upv];
            }
        }
    }

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

        System.out.println(MinimumSpanningTreeKrushkal(n, graph));
        ArrayList<int[]> result = MinimumSpanningTreeFindPathKrushkal(n, graph);

        for (int[] i : result) {
            System.out.println(i[0] + " " + i[1] + " " + i[2]);
        }
    }

    static ArrayList<int[]> MinimumSpanningTreeFindPathKrushkal(int n, ArrayList<ArrayList<int[]>> graph) {
        ArrayList<int[]> edges = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < graph.get(i).size(); j++) {
                int u = i;
                int v = graph.get(i).get(j)[0];
                int wt = graph.get(i).get(j)[1];

                edges.add(new int[] { u, v, wt });
            }
        }

        Collections.sort(edges, (a, b) -> a[2] - b[2]);

        ArrayList<int[]> result = new ArrayList<>();

        DisjointSet ds = new DisjointSet(n);
        for (int i = 0; i < edges.size(); i++) {
            int u = edges.get(i)[0];
            int v = edges.get(i)[1];
            int w = edges.get(i)[2];

            if (ds.findUltimateParent(u) != ds.findUltimateParent(v)) {
                result.add(new int[] { u, v, w });
                ds.unionBySize(u, v);
            }
        }
        return result;
    }

    static int MinimumSpanningTreeKrushkal(int n, ArrayList<ArrayList<int[]>> graph) {
        ArrayList<int[]> edges = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < graph.get(i).size(); j++) {
                int u = i;
                int v = graph.get(i).get(j)[0];
                int wt = graph.get(i).get(j)[1];

                edges.add(new int[] { u, v, wt });
            }
        }

        Collections.sort(edges, (a, b) -> a[2] - b[2]);
        int sum = 0;

        DisjointSet ds = new DisjointSet(n);
        for (int i = 0; i < edges.size(); i++) {
            int u = edges.get(i)[0];
            int v = edges.get(i)[1];
            int w = edges.get(i)[2];

            if (ds.findUltimateParent(u) != ds.findUltimateParent(v)) {
                sum += w;
                ds.unionBySize(u, v);
            }
        }
        return sum;
    }
}