import java.util.*;

public class Tree_BuildTreeInorderandPreorder {
    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
        }
    }

    static Node constructTreeHard(int[] preorder,int[] inorder){
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<inorder.length;i++)
            map.put(inorder[i],i);
        Node root=buildHard(preorder,0,preorder.length-1,inorder,0,inorder.length-1,map);
        return root;
    }

    static Node buildHard(int[] pre,int pstart,int pend,int[] in,int istart,int iend,Map<Integer,Integer> map){
        if(istart>iend || pstart>pend)
            return null;
        
        Node root=new Node(pre[pstart]);
        int indexroot=map.get(root.data);
        int left=indexroot-istart;
        root.left=buildHard(pre, pstart+1, pstart+left, in, istart, indexroot-1, map);
        root.right=buildHard(pre, pstart+left+1, pend, in, indexroot+1, iend, map);

        return root;
    }

    public static void main(String[] args) {
        int[] inorder = new int[] { 40, 20, 50, 10, 60, 30 };
        int[] preorder = new int[] { 10, 20, 40, 50, 30, 60 };

        Node root = constructTreeEasy(preorder, inorder);

        ArrayList<Integer> in = new ArrayList<>();
        ArrayList<Integer> pre = new ArrayList<>();
        inorderTraversal(root, in);
        preorderTraversal(root, pre);
        boolean flag = true;
        for (int i = 0; i < in.size(); i++) {
            if (in.get(i) != inorder[i]) {
                flag = false;
                break;
            }
        }

        for (int i = 0; i < pre.size(); i++) {
            if (pre.get(i) != preorder[i]) {
                flag = false;
                break;
            }
        }
        System.out.println(flag);
    }

    static Node constructTreeEasy(int[] preorder,int[] inorder){
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<inorder.length;i++)
            map.put(inorder[i],i);
        int[] pindex=new int[1];
        return buildEasy(preorder,inorder,0,inorder.length-1,map,pindex);
    }

    static Node buildEasy(int[] pre,int[] in,int start,int end,Map<Integer,Integer> map,int[] index){
        if(start>end)
            return null;
        
        Node root=new Node(pre[index[0]++]);
        int indexroot=map.get(root.data);
        root.left=buildEasy(pre, in, start, indexroot-1, map, index);
        root.right=buildEasy(pre, in, indexroot+1, end, map, index);

        return root;
    }

    static void inorderTraversal(Node root, ArrayList<Integer> arr) {
        if (root == null)
            return;

        inorderTraversal(root.left, arr);
        arr.add(root.data);
        inorderTraversal(root.right, arr);
    }

    static void preorderTraversal(Node root, ArrayList<Integer> arr) {
        if (root == null)
            return;

        arr.add(root.data);
        preorderTraversal(root.left, arr);
        preorderTraversal(root.right, arr);
    }
}
