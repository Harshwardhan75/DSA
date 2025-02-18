import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Graph_BFSDFSCycleDetectionUsingDFS {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<Integer, ArrayList<Integer>> map = new HashMap<>();

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();

            ArrayList<Integer> arr1 = map.getOrDefault(u, new ArrayList<>());
            arr1.add(v);
            map.put(u, arr1);

            ArrayList<Integer> arr2 = map.getOrDefault(v, new ArrayList<>());
            arr2.add(u);
            map.put(v, arr2);
        }

        System.out.println(isCycle(map));
    }

    static boolean isCycle(Map<Integer, ArrayList<Integer>> map) {
        int n = map.size();
        boolean[] visited = new boolean[n+1];

        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                if (DFS(i, -1, visited, map))
                    return true;
            }
        }

        return false;
    }

    static boolean DFS(int node, int parent, boolean[] visited, Map<Integer, ArrayList<Integer>> map) {
        visited[node]=true;

        for(int i: map.get(node)){
            if(!visited[i]){
                if(DFS(i, node, visited, map))
                    return true;
            }
            else
            if(i!=parent)
                return true;
        }

        return false;
    }
}
