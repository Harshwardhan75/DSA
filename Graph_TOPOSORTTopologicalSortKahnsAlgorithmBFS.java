import java.util.*;

public class Graph_TOPOSORTTopologicalSortKahnsAlgorithmBFS {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int e=sc.nextInt();
        ArrayList<ArrayList<Integer>> graph=new ArrayList<>();

        for(int i=0;i<n;i++)
            graph.add(new ArrayList<>());

        for(int i=0;i<e;i++){
            int u=sc.nextInt();
            int v=sc.nextInt();

            graph.get(u).add(v);
        }

        System.out.println(TopologicalSort(graph));
    }

    static ArrayList<Integer> TopologicalSort(ArrayList<ArrayList<Integer>> graph){
        int n=graph.size();
        int[] inDegree=new int[n];

        for(ArrayList<Integer> arr: graph){
            for(int a: arr){
                inDegree[a]++;
            }
        }

        Queue<Integer> que=new LinkedList<>();

        ArrayList<Integer> result=new ArrayList<>();
        
        for(int i=0;i<n;i++){
            if(inDegree[i]==0)
                que.offer(i);
        }        
        
        while(!que.isEmpty()){
            int node=que.poll();
            result.add(node);

            for(int i: graph.get(node)){
                inDegree[i]--;
                if(inDegree[i]==0)
                    que.offer(i);
            }
        }

        return result;
    }
}
