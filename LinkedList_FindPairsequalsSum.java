import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class LinkedList_FindPairsequalsSum {
    static class Node{
        int data;
        Node next;
        Node prev;

        public Node(int data,Node next,Node prev){
            this.data=data;
            this.next=next;
            this.prev=prev;
        }

        public Node(int data){
            this.data=data;
            this.next=null;
            this.prev=null;
        }
    }

    static Node ConvertArraytoDLL(int[] arr){
        int n=arr.length;
        Node head=new Node(arr[0]);
        Node prev=head;

        for(int i=1;i<n;i++){
            Node newnode=new Node(arr[i], null, prev);
            prev.next=newnode;
            prev=prev.next;
        }
        return head;
    }

    static void TraverseDLL(Node head){
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp=temp.next;
        }
        System.out.println();
    }

    static ArrayList<ArrayList<Integer>> BrutefindPairsWithGivenSum(Node head,int sum){
        Node temp1=head;
        ArrayList<ArrayList<Integer>> result=new ArrayList<>();
        while(temp1!=null){
            Node temp2=temp1.next;
            while(temp2!=null && temp1.data+temp2.data<=sum){
                if(temp1.data+temp2.data==sum)
                    result.add(new ArrayList<>(Arrays.asList(temp1.data,temp2.data)));
                temp2=temp2.next;
            }
            temp1=temp1.next;
        }

        return result;
    }

    public static ArrayList<ArrayList<Integer>> OptimalfindPairsWithGivenSum(Node head,int target) {
        // code here
        Node first=head;
        Node last=head;
        while(last.next!=null)
            last=last.next;
        
        ArrayList<ArrayList<Integer>> result=new ArrayList<>();
        while(first.data<last.data){
            int sum=first.data+last.data;
            if(sum==target){
                result.add(new ArrayList<>(Arrays.asList(first.data,last.data)));
                first=first.next;
                last=last.prev;
            }
            else if(sum<target)
                first=first.next;
            else
                last=last.prev;
            
        }      
        return result;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];
        int sum=sc.nextInt();
        for(int i=0;i<n;i++)    arr[i]=sc.nextInt();

        Node head=ConvertArraytoDLL(arr);
        TraverseDLL(head);
        ArrayList<ArrayList<Integer>> result=OptimalfindPairsWithGivenSum(head,sum);
        System.out.println(result);
    }
}