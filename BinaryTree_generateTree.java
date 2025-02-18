public class BinaryTree_generateTree {
    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
        }
    }

    static void inorder(Node root) {
        if (root == null)
            return;

        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    public static void main(String[] args) {
        int[] arr=new int[]{8, 5, 1, 7, 10, 12};
        // Node root=BruteGenerateTree(arr);
        Node root=OptimalGenerateTree(arr);
        inorder(root);
    }

    static Node OptimalGenerateTree(int[] arr){
        return generateTree(arr,new int[]{0},Integer.MAX_VALUE);
    }

    static Node generateTree(int[] arr,int[] index,int ub){
        if(index[0]==arr.length || arr[index[0]]>ub)
            return null;
        
        Node root=new Node(arr[index[0]++]);
        
        root.left=generateTree(arr, index, root.data);
        root.right=generateTree(arr, index, ub);

        return root;
    }

    static Node BruteGenerateTree(int[] arr){
        Node root=new Node(arr[0]);
        for(int i=1;i<arr.length;i++)
            addNode(root,arr[i]);
        
        return root;
    }

    static void addNode(Node root,int key){
        Node temp=root;
        Node prev=root;

        while(temp!=null){
            prev=temp;
            temp=temp.data<key?temp.right:temp.left;
        }

        if(prev.data<key)
            prev.right=new Node(key);
        else
            prev.left=new Node(key);
    }
}
