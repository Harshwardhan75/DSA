import java.util.Scanner;

public class Trie_MaximizeZOR_II {

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
                    temp = temp.get(bit);
                }
            }

            return result;
        }
    }

    static int findMaximumXOR(int[] arr1,int[] arr2) {
        Trie trie=new Trie();
        for(int i: arr1)    trie.insert(i);
        int max=0;
        for(int i: arr2){
            max = Math.max(max,trie.getMaximumXor(i));
        }

        return max;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int[] arr1=new int[n];
        int[] arr2=new int[m];

        for(int i=0;i<n;i++)    arr1[i]=sc.nextInt();
        for(int i=0;i<m;i++)    arr2[i]=sc.nextInt();

        System.out.println(findMaximumXOR(arr1,arr2));
    }
}
