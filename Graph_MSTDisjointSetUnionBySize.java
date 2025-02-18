public class Graph_MSTDisjointSetUnionBySize {

    static class DisjointSet{
        int[] size;
        int[] parent;

        DisjointSet(int n){
            //one based indexing
            size=new int[n+1];
            parent=new int[n+1];

            for(int i=0;i<=n;i++){
                size[i]=1;
                parent[i]=i;
            }
        }

        int findUltimateParent(int node){
            if(node==parent[node])
                return node;
            
            return parent[node]=findUltimateParent(parent[node]);
        }

        void unionBySize(int u,int v){
            int upu=findUltimateParent(u);
            int upv=findUltimateParent(v);

            if(upu==upv)
                return;
            
            if(size[upu]<size[upv]){
                parent[upu]=upv;
                size[upv]+=size[upu];
            }
            else if(size[upu]>size[upv]){
                parent[upv]=upu;
                size[upu]+=size[upv];
            }
            else{
                parent[upv]=upu;
                size[upu]+=size[upv];
            }
        }
    }

    public static void main(String[] args) {
        DisjointSet ds=new DisjointSet(7);
        ds.unionBySize(1, 2);
        ds.unionBySize(2,3 );
        ds.unionBySize(4,5);
        ds.unionBySize(6,7);
        ds.unionBySize(5,6);
        System.out.println(ds.findUltimateParent(1)==ds.findUltimateParent(7));
        ds.unionBySize(3,7);
        System.out.println(ds.findUltimateParent(1)==ds.findUltimateParent(7));
    }
}
