import java.util.*;

public class Graph_MSTAccountMerge {

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
        ArrayList<ArrayList<String>> account = new ArrayList<>();

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            int t = sc.nextInt();
            ArrayList<String> arr = new ArrayList<>();

            for (int j = 0; j < t; j++)
                arr.add(sc.next());

            account.add(arr);
        }

        ArrayList<ArrayList<String>> result = MergeAccount(account);

        for (ArrayList<String> arr : result)
            System.out.println(arr);
    }

    static ArrayList<ArrayList<String>> MergeAccount(ArrayList<ArrayList<String>> account) {
        int n = account.size();
        Map<String, Integer> map = new HashMap<>();
        DisjointSet ds=new DisjointSet(n);

        for (int i = 0; i < n; i++) {
            int size = account.get(i).size();

            for (int j = 1; j < size; j++) {
                String s = account.get(i).get(j);
                if (!map.containsKey(s))
                    map.put(s, i);
                else
                    ds.unionBySize(i, map.get(s));
            }
        }

        ArrayList<String>[] merged=new ArrayList[n];
        for(int i=0;i<n;i++)
            merged[i]=new ArrayList<>();
        
        for(String s: map.keySet()){
            int ultimateparent=ds.findUltimateParent(map.get(s));
            merged[ultimateparent].add(s);
        }            

        ArrayList<ArrayList<String>> result=new ArrayList<>();

        for(int i=0;i<n;i++){
            int size=merged[i].size();
            if(size==0) continue;

            Collections.sort(merged[i]);
            ArrayList<String> arr=new ArrayList<>();
            arr.add(account.get(i).get(0));

            for(int j=0;j<size;j++){
                arr.add(merged[i].get(j));
            }

            result.add(arr);
        }

        return result;
    }
}


// 6
// 4 john j1@com j2@com j3@com
// 2 john j4@com
// 3 raj r1@com r2@com
// 3 john j1@com j5@com
// 3 raj r2@com r3@com
// 2 mary m1@com