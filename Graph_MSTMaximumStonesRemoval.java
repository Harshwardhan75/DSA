import java.net.CookieManager;
import java.util.*;

public class Graph_MSTMaximumStonesRemoval {

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

        int[][] stones = new int[n][2];
        for (int i = 0; i < n; i++) {
            stones[i] = new int[] { sc.nextInt(), sc.nextInt() };
        }

        System.out.println(MaximumStonesRemoval(n, stones));
    }

    static int MaximumStonesRemoval(int n, int[][] stones) {
        int maxRow = 0;
        int maxCol = 0;

        for (int[] i : stones) {
            maxRow = Math.max(maxRow, i[0]);
            maxCol = Math.max(maxCol, i[1]);
        }
        DisjointSet ds = new DisjointSet(maxRow + maxCol + 2);

        for (int[] i : stones) {
            int u = i[0];
            int v = maxRow + 1 + i[1];

            ds.unionBySize(u, v);
        }

        int component = 0;
        for (int i = 0; i < n; i++) {
            if (ds.parent[i] == i && ds.size[i] > 1) {
                component++;
            }
        }

        return n - component;
    }
}
