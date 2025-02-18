import java.util.*;

import org.w3c.dom.Node;

public class LinkedList_FindMiddleNode {
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
    
    static ListNode BruteFindMiddle(ListNode head){
        ListNode temp=head;
        int count=0;
        while(temp!=null){
            count++;
            temp=temp.next; 
        }

        int middleNode=(count/2)+1;

        temp=head;
        while(temp!=null){
            middleNode--;
            if(middleNode==0)
                break;
            temp=temp.next;
        }

        return temp;
    }

    static ListNode OptimalFindMiddle(ListNode head){
        ListNode slow=head;
        ListNode fast=head;

        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        ListNode head;
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];

        for(int i=0;i<n;i++)    arr[i]=sc.nextInt();
        
        head=ArrayToLL(arr);
        System.out.println(OptimalFindMiddle(head).data);
    }
}