import java.util.Scanner;
import java.util.concurrent.locks.ReentrantLock;
import javax.naming.spi.DirStateFactory;
import javax.swing.border.EmptyBorder;

public class Trie_MaximizeXOR_I {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        System.out.println(maximizeXOR(arr, x));
    }

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

    static Node root = new Node();

    static void insert(int num) {
        Node temp = root;
        for (int i = 31; i >= 0; i--) {
            int bit = ((num & (1 << i)) !=0)?1:0;
            if (!temp.containsKey(bit))
                temp.put(bit, new Node());
            temp = temp.get(bit);
        }
    }

    static int maximizeXOR(int[] arr, int x) {
        for (int i : arr) {
            insert(i);
        }
        return findTheMaxValue(x);
    }

    static int findTheMaxValue(int target) {
        Node temp = root;
        int result=0;
        for (int i = 31; i >= 0; i--) {
            int bit = ((target & (1 << i))!=0)?1:0;
            int oppositebit = 1-bit;

            if(temp.containsKey(oppositebit)){
                temp=temp.get(oppositebit);
                result = result | (1<<i);
            }
            else{
                temp=temp.get(bit);
            }
        }

        return result;
    }
}
