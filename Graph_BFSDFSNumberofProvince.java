import java.util.*;

public class Graph_BFSDFSNumberofProvince {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        Map<Integer,ArrayList<Integer>> map=new HashMap<>();
        for(int i=0;i<n;i++){
            int u=sc.nextInt();
            int v=sc.nextInt();

            ArrayList<Integer> arr1=map.getOrDefault(u, new ArrayList<>());
            arr1.add(v);
            map.put(u,arr1);

            ArrayList<Integer> arr2=map.getOrDefault(v, new ArrayList<>());
            arr2.add(u);
            map.put(v,arr2);
        }

        System.out.println(NumberOfProvincesBFS(map));
        System.out.println(NumberOfProvincesDFS(map));
    }

    static int NumberOfProvincesDFS(Map<Integer,ArrayList<Integer>> map){
        int n=map.size();
        boolean[] visited=new boolean[n+1];
        int count=0;
        for(int i=1;i<=n;i++){
            if(!visited[i]){
                count++;
                dfs(map,i,visited);
            }
        }

        return count;
    }

    static void dfs(Map<Integer,ArrayList<Integer>> map,int node,boolean[] visited){
        visited[node]=true;

        for(int i: map.get(node)){
            if(!visited[i])
                dfs(map, i, visited);
        }
    }

    static int NumberOfProvincesBFS(Map<Integer,ArrayList<Integer>> map){
        int n=map.size();
        boolean[] visited=new boolean[n+1];
        int count=0;
        for(int i=1;i<=n;i++){
            if(!visited[i]){
                count++;
                bfs(map,i,visited);
            }
        }

        return count;
    }

    static void bfs(Map<Integer,ArrayList<Integer>> map,int node,boolean[] visited){
        Queue<Integer> que=new LinkedList<>();
        que.offer(node);
        visited[node]=true;
        while(!que.isEmpty()){
            int n=que.poll();
            for(int i: map.get(n)){
                if(!visited[i]){
                    visited[i]=true;
                    que.offer(i);
                }
            }
        }
    }
}
