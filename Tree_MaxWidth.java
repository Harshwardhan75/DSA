import java.util.*;

public class Tree_MaxWidth {
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

        System.out.println(FindMaxWidth(root));
    }

    static class Pair{
        Node node;
        int val;
        Pair(Node node,int val){
            this.node=node;
            this.val=val;
        }
    }

    static int FindMaxWidth(Node root){
        Queue<Pair> que=new LinkedList<>();
        que.offer(new Pair(root,0));
        int maxwidth=0;

        while(!que.isEmpty()){
            int min=que.peek().val;
            int size=que.size();
            int first=que.peek().val;
            int last=0;
            for(int i=1;i<=size;i++){
                Pair p=que.poll();
                int curr=p.val-min;
                last=Math.max(last,p.val);
                if(p.node.left!=null)
                    que.offer(new Pair(p.node.left, 2*curr+1));

                if(p.node.right!=null)
                    que.offer(new Pair(p.node.right, 2*curr+2));
            }

            maxwidth=Math.max(maxwidth, last-first+1);
        }

        return maxwidth;
    }
}
