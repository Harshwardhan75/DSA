import java.util.*;

public class Graph_MSTNumberOfIslandsII {

    static class DisjointSet {
        int[] size;
        int[] parent;

        DisjointSet(int n) {
            size = new int[n];
            parent = new int[n];

            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        int findUltimateParent(int node) {
            if (node == parent[node])
                return node;

            return parent[node] = findUltimateParent(parent[node]);
        }

        void unionBySize(int u, int v) {
            int upu = findUltimateParent(u);
            int upv = findUltimateParent(v);

            if (upu == upv)
                return;

            if (size[upu] < size[upv]) {
                parent[upu] = upv;
                size[upv] += size[upu];
            } else {
                parent[upv] = upu;
                size[upu] += size[upv];
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();

        int e=sc.nextInt();
        int[][] queries=new int[e][];

        for(int i=0;i<e;i++)
            queries[i]=new int[]{sc.nextInt(),sc.nextInt()};
        
        System.out.println(NumberOFIslands(n,m,queries));
    }

    static ArrayList<Integer> NumberOFIslands(int n,int m,int[][] queries){
        boolean[][] visited=new boolean[n][m];
        int[][] dir=new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
        DisjointSet ds=new DisjointSet(n*m);

        ArrayList<Integer> result=new ArrayList<>();
        int count=0;

        for(int[] q: queries){
            int row=q[0];
            int col=q[1];

            if(visited[row][col]){
                result.add(count);
                continue;
            }

            count++;
            visited[row][col]=true;

            for(int[] d: dir){
                int nexti=row+d[0];
                int nextj=col+d[1];

                if(nexti>=0 && nexti<n && nextj>=0 && nextj<m){
                    if(visited[nexti][nextj]){
                        int nodevalue=(row*m)+col;
                        int nextvalue=(nexti*m)+nextj;
                        int upnode=ds.findUltimateParent(nodevalue);
                        int upnext=ds.findUltimateParent(nextvalue);

                        if(upnode!=upnext){
                            count--;
                            ds.unionBySize(nodevalue, nextvalue);
                        }
                    }
                }
            }

            result.add(count);
        }

        return result;
    }
}
