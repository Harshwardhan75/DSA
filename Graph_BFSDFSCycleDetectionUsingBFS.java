import java.util.*;

public class Graph_BFSDFSCycleDetectionUsingBFS {
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

    static boolean isCycle(Map<Integer,ArrayList<Integer>> map){
        int n=map.size();
        boolean[] visited=new boolean[n+1];

        for(int i=1;i<=n;i++){
            if(visited[i])  continue;
            
            if(BFS(map,i,visited))
                return true;
        }

        return false;
    }

    static boolean BFS(Map<Integer,ArrayList<Integer>> map,int vertex,boolean[] visited){
        int n=map.size();

        Queue<int[]> que=new LinkedList<>();
        que.offer(new int[]{vertex,-1});
        visited[vertex]=true;
        while(!que.isEmpty()){
            int node=que.peek()[0];
            int parent=que.peek()[1];
            que.poll();

            for(int i: map.get(node)){
                if(!visited[i]){
                    visited[i]=true;
                    que.offer(new int[]{i,node});
                }
                else if(i!=parent)
                    return true;
            }
        }

        return false;
    }
}
