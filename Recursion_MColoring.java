import java.util.*;

public class Recursion_MColoring {

    static boolean GraphColor(boolean[][] graph,int n,int m){
        int[] color=new int[n];
        if(MColor(0,graph,color,m,n)){
            for(int i: color)
                System.out.print(i+" ");
            System.out.println();
            return true;
        }
        return false;
    }

    static boolean MColor(int node,boolean[][] graph,int[] color,int m,int n){
        if(node==n) return true;
        
        for(int i=1;i<=m;i++){
            if(Possible(node,i,graph,color,n)){
                color[node]=i;
                if(MColor(node+1, graph, color, m, n))
                    return true;
                color[node]=0;
            }
        }
        return false;
    }

    static boolean Possible(int node,int col,boolean[][] graph,int[] color,int n){
        for(int i=0;i<n;i++){
            if(graph[node][i] && color[i]==col)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int e=sc.nextInt();
        boolean[][] graph=new boolean[n][n];
        for(int i=0;i<e;i++){
            int start=sc.nextInt();
            int end=sc.nextInt();
            graph[start][end]=true;
            graph[end][start]=true;
        }

        System.out.println(GraphColor(graph,n,m));
    }
}