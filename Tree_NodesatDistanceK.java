import java.util.*;

public class Tree_NodesatDistanceK {
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
        System.out.println(findatk(root,10,2));
    }

    static void addParentPointer(Node root,Map<Node,Node> map){
        Queue<Node> que=new LinkedList<>();
        que.offer(root);

        while(!que.isEmpty()){
            Node temp=que.poll();

            if(temp.left!=null)
            {
                map.put(temp.left, temp);
                que.offer(temp.left);
            }

            if(temp.right!=null)
            {
                map.put(temp.right, temp);
                que.offer(temp.right);
            }
        }
    }

    static ArrayList<Integer> findatk(Node root,int start,int k){
        Map<Node,Node> map=new HashMap<>();
        addParentPointer(root,map);
        Queue<Node> que=new LinkedList<>();
        Set<Node> set=new HashSet<>();
        que.offer(findtopath(root,start));
        set.add(findtopath(root, start));
        while(!que.isEmpty()){
            int size=que.size();
            for(int i=1;i<=size;i++){
                Node temp=que.poll();

                if(map.get(temp)!=null && !set.contains(map.get(temp))){
                    que.offer(map.get(temp));
                    set.add(map.get(temp));
                }

                if(temp.left!=null && !set.contains(temp.left)){
                    que.offer(temp.left);
                    set.add(temp.left);
                }

                if(temp.right!=null && !set.contains(temp.right)){
                    que.offer(temp.right);
                    set.add(temp.right);
                }

            }
            k--;
            if(k==0)
                break;
        }

        ArrayList<Integer> arr=new ArrayList<>();
        while(!que.isEmpty())
            arr.add(que.poll().data);
        
        return arr;
    }

    static Node findtopath(Node root,int start){
        if(root==null)
            return null;
        
        if(root.data==start)
            return root;
        
        Node left=findtopath(root.left, start);
        Node right=findtopath(root.right, start);

        return left!=null?left:right;
    }

}
