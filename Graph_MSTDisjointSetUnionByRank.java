public class Graph_MSTDisjointSetUnionByRank {

    static class DisjointSet{
        int[] rank;
        int[] parent;

        DisjointSet(int n){
            //one based indexing
            rank=new int[n+1];
            parent=new int[n+1];
            for(int i=0;i<=n;i++){
                rank[i]=0;
                parent[i]=i;
            }
        }

        int findUltimateParent(int node){
            if(node==parent[node])
                return node;
            
            return parent[node]=findUltimateParent(parent[node]);
        }

        void unionByRank(int u,int v){
            int upu=findUltimateParent(u);
            int upv=findUltimateParent(v);

            if(upu==upv)  return;

            if(rank[upu]<rank[upv]){
                parent[upu]=upv;
            }
            else if(rank[upu]>rank[upv]){
                parent[upv]=upu;
            }
            else{
                parent[upv]=upu;
                rank[upu]+=1;
            }
        }
    }

    public static void main(String[] args) {
        DisjointSet ds=new DisjointSet(7);
        ds.unionByRank(1, 2);
        ds.unionByRank(2,3 );
        ds.unionByRank(4,5);
        ds.unionByRank(6,7);
        ds.unionByRank(5,6);
        System.out.println(ds.findUltimateParent(1)==ds.findUltimateParent(7));
        ds.unionByRank(3,7);
        System.out.println(ds.findUltimateParent(1)==ds.findUltimateParent(7));
    }
}
