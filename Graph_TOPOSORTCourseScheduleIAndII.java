import java.util.*;

public class Graph_TOPOSORTCourseScheduleIAndII {
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

        System.out.println(CourseScheduleI(graph));
        System.out.println(CourseScheduleII(graph));
    }

    static boolean CourseScheduleI(ArrayList<ArrayList<Integer>> graph){
        int n=graph.size();
        int[] inDegree=new int[n];
        int count=0;
        Queue<Integer> que=new LinkedList<>();

        for(ArrayList<Integer> arr: graph){
            for(int a: arr)
                inDegree[a]++;
        }

        for(int i=0;i<n;i++)
            if(inDegree[i]==0)
                que.offer(i);
            
        while(!que.isEmpty()){
            int node=que.poll();
            count++;
            for(int i: graph.get(node)){
                inDegree[i]--;
                if(inDegree[i]==0)
                    que.offer(i);
            }
        }

        return count==n;
    }

    static ArrayList<Integer> CourseScheduleII(ArrayList<ArrayList<Integer>> graph){
        int n=graph.size();
        int[] inDegree=new int[n];
        Queue<Integer> que=new LinkedList<>();

        for(ArrayList<Integer> arr: graph){
            for(int a: arr)
                inDegree[a]++;
        }

        for(int i=0;i<n;i++)
            if(inDegree[i]==0)
                que.offer(i);
        Stack<Integer> st=new Stack<>();
        while(!que.isEmpty()){
            int node=que.poll();
            st.push(node);
            for(int i: graph.get(node)){
                inDegree[i]--;
                if(inDegree[i]==0)
                    que.offer(i);
            }
        }

        ArrayList<Integer> result=new ArrayList<>(st);

        return result.size()!=n?new ArrayList<>():result;
    }
}
