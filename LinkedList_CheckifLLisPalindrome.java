import java.nio.file.OpenOption;
import java.util.Scanner;

public class LinkedList_CheckifLLisPalindrome {
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
    
    static ListNode reverse(ListNode head){
        if(head==null || head.next==null)
            return head;
        
        ListNode newHead=reverse(head.next);
        head.next.next=head;
        head.next=null;
        return newHead;
    }

    static boolean compare(ListNode first,ListNode second){
        while(first!=null && second!=null){
            if(first.data!=second.data)
                return false;
            first=first.next;
            second=second.next;
        }
        return true;
    }

    public static boolean OptimalisPalindrome(ListNode head) {
        ListNode slow=head;
        ListNode fast=head;

        while(fast.next!=null && fast.next.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }

        ListNode newHead=reverse(slow.next);
        boolean status=compare(head,newHead);
        reverse(newHead);
        return status;
    }

    public static void main(String[] args) {
        ListNode head;
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];

        for(int i=0;i<n;i++)    arr[i]=sc.nextInt();
        
        head=ArrayToLL(arr);

        System.out.println(OptimalisPalindrome(head));
    }
}