import java.util.*;

public class Graph_MSTMakingALargeIslands {

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

        int[][] grid=new int[n][m];

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                grid[i][j]=sc.nextInt();
            }
        }

        System.out.println(largestIsland(grid));
    }

    static int largestIsland(int[][] grid){
        int n=grid.length;
        int m=grid[0].length;
        DisjointSet ds=new DisjointSet(n*m);
        int[][] dir=new int[][]{{0,1},{1,0},{0,-1},{-1,0}};

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==0)   continue;

                for(int[] d: dir){
                    int nexti=i+d[0];
                    int nextj=j+d[1];

                    if(nexti>=0 && nexti<n && nextj>=0 && nextj<m){
                        if(grid[nexti][nextj]==1){
                            int a=(i*m)+j;
                            int b=(nexti*m)+nextj;
                            ds.unionBySize(a, b);
                        }
                    }
                }
            }
        }

        int max=0;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1)    continue;
                
                Set<Integer> set=new HashSet<>();

                for(int[] d: dir){
                    int nexti=i+d[0];
                    int nextj=j+d[1];

                    if(nexti>=0 && nexti<n && nextj>=0 && nextj<m){
                        if(grid[nexti][nextj]==1){
                            set.add(ds.findUltimateParent((nexti*m)+nextj));
                        }
                    }
                }
                int sum=0;
                for(int s: set) sum+=ds.size[s];
                max=Math.max(max, sum+1);
            }
        }

        for(int i: ds.size) max=Math.max(max, i);

        return max;
    }
}
