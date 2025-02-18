import java.util.*;

public class Graph_Traversals {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Map<Integer, ArrayList<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();

            ArrayList<Integer> arr = map.getOrDefault(u, new ArrayList<>());
            arr.add(v);
            map.put(u, arr);

            ArrayList<Integer> arr2 = map.getOrDefault(v, new ArrayList<>());
            arr2.add(u);
            map.put(v, arr2);
        }

        System.out.println(BFS(map));
        System.out.println(DFS(map));
    }

    static ArrayList<Integer> DFS(Map<Integer,ArrayList<Integer>> map){
        ArrayList<Integer> dfs=new ArrayList<>();
        int n=map.size();
        boolean[] visited=new boolean[n+1];
        dfs(map,visited,1,dfs);
        return dfs;
    }

    static void dfs(Map<Integer,ArrayList<Integer>> map,boolean[] visited,int node,ArrayList<Integer> dfs){
        visited[node]=true;
        dfs.add(node);
        for(int i: map.get(node)){
            if(!visited[i]){
                dfs(map, visited, i, dfs);
            }
        }
    }

    static ArrayList<Integer> BFS(Map<Integer, ArrayList<Integer>> map) {
        int n = map.size();
        Queue<Integer> que = new LinkedList<>();
        que.offer(1);
        ArrayList<Integer> bfs = new ArrayList<>();
        boolean[] visited = new boolean[n + 1];
        visited[1] = true;
        while (!que.isEmpty()) {
            int node = que.poll();
            bfs.add(node);

            for (int i : map.get(node)) {
                if (!visited[i]) {
                    visited[i] = true;
                    que.offer(i);
                }
            }
        }

        return bfs;
    }
}