import java.util.*;

public class Graph_ShortestPathCheapestFlightwithKstops {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<ArrayList<int[]>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++)
            graph.add(new ArrayList<>());
        
        int e=sc.nextInt();

        for(int i=0;i<e;i++)
            graph.get(sc.nextInt())
            .add(new int[]{sc.nextInt(),sc.nextInt()});

        System.out.println(CheapestFlightWithKstops(graph,0,3,1));
    }

    static int CheapestFlightWithKstops(ArrayList<ArrayList<int[]>> graph,int src,int dst,int k){
        int n=graph.size();
        int[] dest=new int[n];
        Arrays.fill(dest, (int)1e9);
        dest[src]=0;
        Queue<int[]> que=new LinkedList<>();
        que.offer(new int[]{src,0,0});

        while(!que.isEmpty()){
            int node=que.peek()[0];
            int stop=que.peek()[1];
            int d=que.peek()[2];

            que.poll();
            if(stop>k)  continue;

            for(int[] i: graph.get(node)){
                if(d+i[1]<dest[i[0]]){
                    dest[i[0]]=i[1]+d;
                    que.offer(new int[]{i[0],stop+1,dest[i[0]]});
                }
            }
        }        

        return dest[dst]==(int)1e9?-1:dest[dst];
    }
}
