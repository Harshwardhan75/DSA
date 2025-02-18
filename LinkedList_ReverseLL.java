import java.util.*;

public class LinkedList_ReverseLL {
    static class ListNode{
        int data;
        ListNode next;
    
        ListNode(int data,ListNode next){
            this.data=data;
            this.next=next;
        }
    
        ListNode(int data){
            this.data=data;
            this.next=null;
        }
    }

    static ListNode ArrayToLL(int arr[]){
        if(arr.length==0)   return null;

        ListNode head=new ListNode(arr[0]);
        ListNode temp=head;
        for(int i=1;i<arr.length;i++){
            ListNode newnode=new ListNode(arr[i]);
            temp.next=newnode;
            temp=temp.next;
        }
        return head;
    }

    static void TraverseLL(ListNode head){
        ListNode temp=head;
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp=temp.next;
        }
        System.out.println();
    }

    static ListNode BruteReverseLL(ListNode head){
        ListNode temp=head;
        Stack<Integer> st=new Stack<>();
        while(temp!=null){
            st.push(temp.data);
            temp=temp.next;
        }

        temp=head;
        while(temp!=null){
            temp.data=st.pop();
            temp=temp.next;
        }

        return head;
    }

    static ListNode OptimalReverseIterative(ListNode head){
        ListNode prev=null;
        ListNode current=head;
        ListNode front=head;

        while(current!=null){
            front=front.next;
            current.next=prev;
            prev=current;
            current=front;
        }

        return prev;
    }

    static ListNode OptimalReverseLLRecursive(ListNode head){
        if(head==null || head.next==null)
            return head;
        
        ListNode newHead=OptimalReverseLLRecursive(head.next);
        ListNode front=head.next;
        front.next=head;
        head.next=null;
        return newHead;
    }

    public static void main(String[] args) {
        ListNode head;
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];

        for(int i=0;i<n;i++)    arr[i]=sc.nextInt();
        
        head=ArrayToLL(arr);
        TraverseLL(head);
        head=OptimalReverseLLRecursive(head);
        TraverseLL(head);
    }
}