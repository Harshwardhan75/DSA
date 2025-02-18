import java.util.ArrayList;
import java.util.Scanner;

public class LinkedList_OddEvenList {
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

    public static ListNode BruteoddEvenList(ListNode head){
        ArrayList<Integer> arr=new ArrayList<>();
        ListNode temp=head;
        while(temp!=null && temp.next!=null){
            arr.add(temp.data);
            temp=temp.next.next;
        }
        if(temp!=null)
            arr.add(temp.data);
        
        temp=head.next;
        while(temp!=null && temp.next!=null){
            arr.add(temp.data);
            temp=temp.next.next;
        }
        if(temp!=null)
            arr.add(temp.data);
        
        temp=head;
        int i=0;
        while(temp!=null){
            temp.data=arr.get(i++);
            temp=temp.next;
        }
        return head;
    }
    
    public static ListNode OptimaloddEvenList(ListNode head) {
        if(head==null || head.next==null)   return head;
        ListNode odd=head;
        ListNode even=head.next;
        ListNode evenHead=even;
        while((even!=null && even.next!=null)){
            odd.next=odd.next.next;
            even.next=even.next.next;
            odd=odd.next;
            even=even.next;
        }
        odd.next=evenHead;
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
        head=OptimaloddEvenList(head);
        TraverseLL(head);
    }
}