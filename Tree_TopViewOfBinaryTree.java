import java.util.*;

public class Tree_TopViewOfBinaryTree {
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

        System.out.println(TopViewOfTree(root));
    }

    static class Pair{
        Node node;
        int line;
        Pair(Node node,int line){
            this.node=node;
            this.line=line;
        }
    }

    static ArrayList<Integer> TopViewOfTree(Node root){
        TreeMap<Integer,Integer> map=new TreeMap<>();
        Queue<Pair> que=new LinkedList<>();
        que.offer(new Pair(root, 0));

        while(!que.isEmpty()){
            Pair p=que.poll();
            map.put(p.line,map.getOrDefault(p.line, p.node.data));

            if(p.node.left!=null)
                que.offer(new Pair(p.node.left, p.line-1));

            if(p.node.right!=null)
                que.offer(new Pair(p.node.right, p.line+1));
        }

        ArrayList<Integer> arr=new ArrayList<>();

        for(int i: map.keySet())
            arr.add(map.get(i));

        return arr;
    }
}
