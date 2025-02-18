import java.util.*;

public class Graph_BridgeInGraphStronglyConnectedComponents_KosarajuAlgorithm {

    static class Count {

        static void fullStack(ArrayList<Integer>[] graph,
                int node, boolean[] visited, Stack<Integer> st) {
            visited[node] = true;

            for (int i : graph[node]) {
                if (!visited[i]) {
                    fullStack(graph, i, visited, st);
                }
            }
            st.push(node);
        }

        static int CountStronglyConnectedComponents(ArrayList<Integer>[] graph) {
            int n = graph.length;
            boolean[] visited = new boolean[n];

            Stack<Integer> st = new Stack<>();

            for (int i = 0; i < n; i++) {
                if (!visited[i]) {
                    fullStack(graph, i, visited, st);
                }
            }

            ArrayList<Integer>[] reverseGraph = new ArrayList[n];

            for (int i = 0; i < n; i++)
                reverseGraph[i] = new ArrayList<>();

            for (int u = 0; u < n; u++) {
                for (int v : graph[u]) {
                    reverseGraph[v].add(u);
                }
            }

            Arrays.fill(visited, false);
            int count = 0;
            while (!st.isEmpty()) {
                int node = st.pop();

                if (!visited[node]) {
                    count++;
                    DFS(reverseGraph, node, visited);
                }
            }
            return count;
        }

        static void DFS(ArrayList<Integer>[] reverseGraph, int node, boolean[] visited) {
            visited[node] = true;

            for (int i : reverseGraph[node]) {
                if (!visited[i]) {
                    DFS(reverseGraph, i, visited);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int e = sc.nextInt();

        ArrayList<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++)
            graph[i] = new ArrayList<>();

        for (int i = 0; i < e; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();

            graph[u].add(v);
        }

        System.out.println(Count.CountStronglyConnectedComponents(graph));
        System.out.println(Component.ComponentStronglyConnectedComponents(graph));
    }

    static class Component {

        static void fullStack(ArrayList<Integer>[] graph,
                int node, boolean[] visited, Stack<Integer> st) {
            visited[node] = true;

            for (int i : graph[node]) {
                if (!visited[i]) {
                    fullStack(graph, i, visited, st);
                }
            }
            st.push(node);
        }

        static ArrayList<ArrayList<Integer>> ComponentStronglyConnectedComponents(ArrayList<Integer>[] graph) {
            int n = graph.length;
            boolean[] visited = new boolean[n];

            Stack<Integer> st = new Stack<>();

            for (int i = 0; i < n; i++) {
                if (!visited[i]) {
                    fullStack(graph, i, visited, st);
                }
            }

            ArrayList<Integer>[] reverseGraph = new ArrayList[n];

            for (int i = 0; i < n; i++)
                reverseGraph[i] = new ArrayList<>();

            for (int u = 0; u < n; u++) {
                for (int v : graph[u]) {
                    reverseGraph[v].add(u);
                }
            }

            Arrays.fill(visited, false);
            ArrayList<ArrayList<Integer>> result = new ArrayList<>();
            while (!st.isEmpty()) {
                int node = st.pop();

                if (!visited[node]) {
                    ArrayList<Integer> arr = new ArrayList<>();
                    DFS(reverseGraph, node, visited, arr);
                    Collections.sort(arr);
                    result.add(arr);
                }
            }
            return result;
        }

        static void DFS(ArrayList<Integer>[] reverseGraph, int node, boolean[] visited, ArrayList<Integer> arr) {
            visited[node] = true;

            for (int i : reverseGraph[node]) {
                if (!visited[i]) {
                    DFS(reverseGraph, i, visited, arr);
                }
            }

            arr.add(node);
        }
    }

}
