import java.util.ArrayList;

public class Tree_LowestCommonAncestor {
    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        Node root = new Node(12);

        // Level 2
        root.left = new Node(10);
        root.right = new Node(14);

        // Level 3
        root.left.left = new Node(8);
        root.left.right = new Node(11);
        root.right.left = new Node(13);
        root.right.right = new Node(16);

        // Level 4
        root.left.left.left = new Node(7);
        root.left.left.right = new Node(9);
        root.left.right.left = new Node(10);
        root.left.right.right = new Node(12);
        root.right.left.left = new Node(15);
        root.right.left.right = new Node(17);
        root.right.right.left = new Node(18);
        root.right.right.right = new Node(20);

        System.out.println(Brute_FindLCA(root, 10, 20));
        System.out.println(Optimal_FindLCA(root, 10, 20));
    }

    static int Optimal_FindLCA(Node root,int p,int q){
        if(root==null)
            return -1;
        
        if(root.data==p || root.data==q)
            return root.data;
        
        int left=Optimal_FindLCA(root.left, p, q);
        int right=Optimal_FindLCA(root.right, p, q);

        if(left!=-1 && right!=-1)
            return root.data;
        
        return left!=-1?left:right;
    }

    static int Brute_FindLCA(Node root, int p, int q) {
        ArrayList<Integer> arr1 = new ArrayList<>();
        ArrayList<Integer> arr2 = new ArrayList<>();

        pathtonode(root, p, arr1);
        pathtonode(root, q, arr2);

        for (int i = 1; i < Math.min(arr1.size(), arr2.size()); i++) {
            if (arr1.get(i) != arr2.get(i))
                return arr1.get(i-1);
        }

        return arr1.size() < arr2.size() ? arr1.get(arr1.size() - 1) : arr2.get(arr2.size() - 1);
    }

    static boolean pathtonode(Node root, int k, ArrayList<Integer> arr) {
        if (root == null)
            return false;

        arr.add(root.data);

        if (root.data == k)
            return true;

        if (pathtonode(root.left, k, arr) || pathtonode(root.right, k, arr))
            return true;

        arr.remove(arr.size() - 1);
        return false;
    }
}
