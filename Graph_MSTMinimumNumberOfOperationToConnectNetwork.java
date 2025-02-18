import java.util.Scanner;

public class Graph_MSTMinimumNumberOfOperationToConnectNetwork {

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
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int e = sc.nextInt();

        int[][] connections = new int[e][];

        for (int i = 0; i < e; i++)
            connections[i] = new int[] { sc.nextInt(), sc.nextInt() };
        
        System.out.println(MinimumNumberOfOperation(n,connections));
    }

    static int MinimumNumberOfOperation(int n,int[][] connections){
        int extra=0;
        DisjointSet ds=new DisjointSet(n);
        for(int[] i: connections){
            int u=i[0];
            int v=i[1];

            int upu=ds.findUltimateParent(u);
            int upv=ds.findUltimateParent(v);

            if(upu!=upv){
                ds.unionBySize(u, v);
            }
            else{
                extra++;
            }
        }

        int components=0;

        for(int i=0;i<n;i++){
            if(ds.parent[i]==i)
                components++;
        }

        int ans=components-1;

        return extra<ans?-1:ans;
    }
}
