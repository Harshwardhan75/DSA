import java.util.*;

public class Trie_MaxXorQueires {
    static class Node {
        Node[] links = new Node[2];

        void put(int bit, Node node) {
            links[bit] = node;
        }

        Node get(int bit) {
            return links[bit];
        }

        boolean containsKey(int bit) {
            return links[bit] != null;
        }
    }

    static class Trie {
        Node root = new Node();

        void insert(int num) {
            Node temp = root;
            for (int i = 31; i >= 0; i--) {
                int bit = ((num & (1 << i)) != 0) ? 1 : 0;
                if (!temp.containsKey(bit))
                    temp.put(bit, new Node());
                temp = temp.get(bit);
            }
        }

        int getMaximumXor(int target) {
            Node temp = root;
            int result = 0;
            for (int i = 31; i >= 0; i--) {
                int bit = ((target & (1 << i)) != 0) ? 1 : 0;
                int oppositebit = 1 - bit;

                if (temp.containsKey(oppositebit)) {
                    temp = temp.get(oppositebit);
                    result = result | (1 << i);
                } else {
                    if(temp.containsKey(bit))
                        temp=temp.get(bit);
                    else
                        return -1;
                }
            }

            return result;
        }
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int q=sc.nextInt();

        int[] arr=new int[n];
        int[][] queries=new int[q][];

        for(int i=0;i<n;i++)
            arr[i]=sc.nextInt();
        
        for(int i=0;i<q;i++)
            queries[i]=new int[]{sc.nextInt(),sc.nextInt()};
        
        
        int[] result=maxXorQueries(arr,queries);

        for(int i: result)
            System.out.print(i+" ");
    }

    static int[] maxXorQueries(int[] arr,int[][] queries){
        Arrays.sort(arr);
        Trie trie=new Trie();

        ArrayList<int[]> sorted=new ArrayList<>();

        for(int i=0;i<queries.length;i++){
            sorted.add(new int[]{queries[i][0],
                queries[i][1],i});
        }

        Collections.sort(sorted,(a,b)->a[1]-b[1]);

        int[] result=new int[sorted.size()];
        int index=0;

        for(int i=0;i<sorted.size();i++){
            while(index<arr.length && arr[index]<=sorted.get(i)[1]){
                trie.insert(arr[index]);
                index++;
            }

            int max=trie.getMaximumXor(sorted.get(i)[0]);
            result[sorted.get(i)[2]]=max;
        }
        return result;
    }
}
