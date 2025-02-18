import java.util.List;
import java.util.Scanner;

public class LinkedList_DeleteMiddleNode {
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

    static ListNode BruteRemoveMiddle(ListNode head){
        if(head==null || head.next==null)
            return null;
        int count=0;
        ListNode temp=head;
        while(temp!=null){
            count++;
            temp=temp.next;
        }
        int res=count/2;
        temp=head;
        while(temp!=null){
            res--;
            if(res==0){
                temp.next=temp.next.next;
                break;
            }
            temp=temp.next;
        }
        return head;
    }

    static ListNode OptimalRemoveMiddle(ListNode head){
        if(head==null || head.next==null)
            return null;
        
        ListNode slow=head;
        ListNode fast=head;
        fast=fast.next.next;

        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
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
        head=OptimalRemoveMiddle(head);
        TraverseLL(head);
    }
}