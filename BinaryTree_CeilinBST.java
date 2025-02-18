public class BinaryTree_CeilinBST {
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
        root.left = new Node(8);
        root.right = new Node(16);

        // Level 3
        root.left.left = new Node(7);
        root.left.right = new Node(10);
        root.right.left = new Node(14);
        root.right.right = new Node(18);

        // Level 4
        root.left.right.left = new Node(9);
        root.left.right.right = new Node(11);
        root.right.left.left = new Node(13);
        root.right.right.right = new Node(20);
        
        System.out.println(iterativeFindCeil(root,11));
        System.out.println(recursiveFindCeil(root,11));
    }

    static int recursiveFindCeil(Node root,int key){
        int res=find(root,key);
        return res==Integer.MAX_VALUE?-1:res;
    }

    static int find(Node root,int key){
        if(root==null)
            return Integer.MAX_VALUE;
            
        if(root.data<key)
            return find(root.right, key);
        else
            return Math.min(root.data,find(root.left, key));
    }

    static int iterativeFindCeil(Node root,int key){
        int ans=-1;
        while(root!=null){
            if(root.data<key)
                root=root.right;
            else{
                ans=root.data;
                root=root.left;
            }
        }

        return ans;
    }

}
