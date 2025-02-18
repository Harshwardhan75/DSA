import java.util.Scanner;

public class LinkedList_DeleteNthNodeFromEnd {
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

    public static ListNode BruteremoveNthFromEnd(ListNode head,int n){
        ListNode temp=head;
        int count=0;
        while(temp!=null){
            count++;
            temp=temp.next;
        }
        if(count==n)
            return head.next;

        int reach=count-n;

        temp=head;
        while(temp!=null){
            reach--;
            if(reach==0)    break;
            temp=temp.next;
        }

        temp.next=temp.next.next;
        return head;
    }

    public static ListNode OptimalremoveNthFromEnd(ListNode head, int n) {
        ListNode fast=head;
        for(int i=0;i<n;i++)
            fast=fast.next;
        
        if(fast==null)   return head.next;

        ListNode slow=head;

        while(fast.next!=null){
            fast=fast.next;
            slow=slow.next;
        }

        slow.next=slow.next.next;
        return head;
    }

    public static void main(String[] args) {
        ListNode head;
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];

        for(int i=0;i<n;i++)    arr[i]=sc.nextInt();
        
        head=ArrayToLL(arr);

        TraverseLL(head);
        head=OptimalremoveNthFromEnd(head,3);
        TraverseLL(head);
    }
}