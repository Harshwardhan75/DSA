import java.util.*;

public class Tree_SerializeandDesrialize {
    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
        }
    }
    static boolean isSameTree(Node root1,Node root2){
        if(root1==null || root2==null)
            return root1==root2;
        
        return root1.data==root2.data &&
            isSameTree(root1.left, root2.left) &&
            isSameTree(root1.right, root2.right);
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

        String str=Serialize(root);
        // System.out.println(str);

        Node newRoot=Deserialize(str);

        System.out.println(isSameTree(root, newRoot));
    }

    static String Serialize(Node root){
        Queue<Node> que=new LinkedList<>();
        StringBuilder result=new StringBuilder();
        que.offer(root);

        while(!que.isEmpty()){
            int size=que.size();
            for(int i=1;i<=size;i++){
                Node temp=que.poll();
                if(temp==null)
                    result.append("#,");
                else{
                    result.append(Integer.toString(temp.data)+",");
                    que.offer(temp.left);
                    que.offer(temp.right);
                }
            }
        }


        return result.toString();
    }

    static Node Deserialize(String str){
        String[] s=str.split(",");
        Queue<Node> que=new LinkedList<>();
        Node root=new Node(Integer.parseInt(s[0]));
        que.offer(root);

        for(int i=1;i<s.length;i++){
            Node temp=que.poll();
            if(!s[i].equals("#")){
                Node left=new Node(Integer.parseInt(s[i]));
                temp.left=left;
                que.offer(left);
            }

            i++;
            if(!s[i].equals("#")){
                Node right=new Node(Integer.parseInt(s[i]));
                temp.right=right;
                que.offer(right);
            }
        }

        return root;
    }
}
