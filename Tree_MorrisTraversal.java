import java.util.ArrayList;

public class Tree_MorrisTraversal {
    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
        }
    }
    
    static ArrayList<Integer> InorderTraversal(Node root){
        Node temp=root;
        ArrayList<Integer> inorder=new ArrayList<>();
        while(temp!=null){
            if(temp.left==null){
                inorder.add(temp.data);
                temp=temp.right;
            }
            else{
                Node next=temp.left;
                while(next.right!=null && next.right!=temp)
                    next=next.right;
                
                if(next.right==null){
                    next.right=temp;
                    temp=temp.left;
                }
                else{
                    next.right=null;
                    inorder.add(temp.data);
                    temp=temp.right;
                }
            }
        }

        return inorder;
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

        System.out.println(InorderTraversal(root));
        System.out.println(PreorderTraversal(root));
    }

    static ArrayList<Integer> PreorderTraversal(Node root){
        Node curr=root;
        ArrayList<Integer> preorder=new ArrayList<>();
        while(curr!=null){
            if(curr.left==null){
                preorder.add(curr.data);
                curr=curr.right;
            }
            else{
                Node temp=curr.left;
                while(temp.right!=null && temp.right!=curr)
                    temp=temp.right;
                
                if(temp.right==null){
                    preorder.add(curr.data);
                    temp.right=curr;
                    curr=curr.left;
                }
                else{
                    temp.right=null;
                    curr=curr.right;
                }
            }
        }

        return preorder;
    }
}
