import java.util.*;

public class Graph_TOPOSORTEventualSafeStates {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        int n = sc.nextInt();

        for (int i = 0; i < n; i++)
            graph.add(new ArrayList<>());

        int e = sc.nextInt();

        for (int i = 0; i < e; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            graph.get(u).add(v);
        }

        System.out.println(EventualSafeStatesBFS(graph));
        System.out.println(EventualSafeStatesDFS(graph));
    }

    static ArrayList<Integer> EventualSafeStatesDFS(ArrayList<ArrayList<Integer>> graph) {
        int n = graph.size();
        boolean[] visited = new boolean[n];
        ArrayList<Integer> result = new ArrayList<>();
        boolean[] pathvisited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!visited[i])
                DFS(graph, i, visited, pathvisited, result);
        }

        Collections.sort(result);
        return result;
    }

    static boolean DFS(ArrayList<ArrayList<Integer>> graph, int node, boolean[] visited, boolean[] pathvisited,
            ArrayList<Integer> result) {
        visited[node] = pathvisited[node] = true;

        for (int i : graph.get(node)) {
            if (!visited[i]) {
                if (DFS(graph, i, visited, pathvisited, result))
                    return true;
            } else if (pathvisited[i])
                return true;
        }

        result.add(node);
        return pathvisited[node] = false;
    }

    static ArrayList<Integer> EventualSafeStatesBFS(ArrayList<ArrayList<Integer>> graph) {
        int n = graph.size();

        ArrayList<ArrayList<Integer>> copyGraph = new ArrayList<>();

        for (int i = 0; i < n; i++)
            copyGraph.add(new ArrayList<>());

        int[] inDegree = new int[n];
        for (int v = 0; v < n; v++) {
            for (int u : graph.get(v)) {
                copyGraph.get(u).add(v);
                inDegree[v]++;
            }
        }

        Queue<Integer> que = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0)
                que.offer(i);
        }

        ArrayList<Integer> result = new ArrayList<>();

        while (!que.isEmpty()) {
            int node = que.poll();
            result.add(node);
            for (int i : copyGraph.get(node)) {
                inDegree[i]--;
                if (inDegree[i] == 0)
                    que.offer(i);
            }
        }

        Collections.sort(result);
        return result;
    }
}
