public class BinaryTree_KthSmallestElementandKthLargest {
    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
        }
    }

    static void inorder(Node root){
        if(root==null)
            return;
        
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
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
        
        inorder(root);
        System.out.println();
        System.out.println(Kthsmallest(root,3));
        System.out.println(Kthlargest(root,3));
    }

    static int Kthlargest(Node root,int k){
        Node curr=root;
        int count=0;
        while(curr!=null){
            if(curr.right==null){
                count++;
                if(count==k)
                    return root.data;
                curr=curr.left;
            }
            else{
                Node temp=curr.right;

                while(temp.left!=null && temp.left!=curr)
                    temp=temp.left;
                
                if(temp.left==null){
                    temp.left=curr;
                    curr=curr.right;
                }
                else{
                    temp.left=null;
                    count++;
                    if(count==k)
                        return curr.data;
                    curr=curr.left;
                }
            }
        }

        return -1;
    }

    static int Kthsmallest(Node root,int k){
        Node curr=root;
        int count=0;

        while(curr!=null){
            if(curr.left==null){
                count++;
                if(count==k)
                    return curr.data;
                curr=curr.right;
            }
            else{
                Node temp=curr.left;
                while(temp.right!=null && temp.right!=curr)
                    temp=temp.right;
                
                if(temp.right==null){
                    temp.right=curr;
                    curr=curr.left;
                }
                else{
                    temp.right=null;
                    count++;
                    if(count==k)
                        return curr.data;
                    curr=curr.right;
                }
            }
        }

        return -1;
    }
}
