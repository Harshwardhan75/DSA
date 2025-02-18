import java.util.*;

public class Tree_verticalOrderTraversal {
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

        System.out.println(VerticalOrderTraversal(root));
    }

    static class Tuple {
        int level, line;
        Node node;

        Tuple(Node node, int level, int line) {
            this.node = node;
            this.level = level;
            this.line = line;
        }
    }

    static ArrayList<ArrayList<Integer>> VerticalOrderTraversal(Node root) {
        TreeMap<Integer, TreeMap<Integer,ArrayList<Integer>>> map = new TreeMap<>();
        Queue<Tuple> que = new LinkedList<>();
        addintoMap(que, map, root);

        ArrayList<ArrayList<Integer>> result=new ArrayList<>();

        for(int i: map.keySet()){
            TreeMap<Integer,ArrayList<Integer>> temp=map.get(i);
            ArrayList<Integer> arr=new ArrayList<>();
            for(int key: temp.keySet()){
                ArrayList<Integer> a1=temp.get(key);
                Collections.sort(a1);
                for(int x: a1)  arr.add(x);
            }
            result.add(arr);
        }
        return result;
    }

    private static void addintoMap(Queue<Tuple> que, TreeMap<Integer, TreeMap<Integer,ArrayList<Integer>>> map,Node root) {
        que.offer(new Tuple(root, 0, 0));

        while(!que.isEmpty()){
            Tuple t=que.poll();
            if(t.node.left!=null)
                que.offer(new Tuple(t.node.left, t.level+1, t.line-1));
            
            if(t.node.right!=null)
                que.offer(new Tuple(t.node.right, t.level+1, t.line+1));
            
            TreeMap<Integer,ArrayList<Integer>> tempmap=map.getOrDefault(t.line, new TreeMap<>());

            ArrayList<Integer> arr=tempmap.getOrDefault(t.level, new ArrayList<>());
            arr.add(t.node.data);
            tempmap.put(t.level, arr);
            map.put(t.line,tempmap);
        }
    }
}
