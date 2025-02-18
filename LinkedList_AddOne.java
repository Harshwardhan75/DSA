import java.util.Scanner;

public class LinkedList_AddOne {
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

    static ListNode reverse(ListNode head){
        if(head==null || head.next==null)
            return head;
        
        ListNode newHead=reverse(head.next);
        head.next.next=head;
        head.next=null;
        return newHead;
    }

    static ListNode BruteAddone(ListNode head){
        head=reverse(head);
        int carry=1;
        ListNode temp=head;
        while(temp!=null){
            temp.data+=carry;
            if(temp.data<10){
                carry=0;
                break;
            }
            else{
                temp.data=0;
            }
            temp=temp.next;
        }

        head=reverse(head);
        if(carry==1){
            ListNode newNode=new ListNode(carry);
            newNode.next=head;
            head=newNode;
        }

        return head;
    }

    static ListNode OptimalAddOne(ListNode head){
        if(head==null)
            return null;
        
        int carry=Add(head);
        if(carry==1){
            ListNode newNode=new ListNode(carry);
            newNode.next=head;
            head=newNode;
        }
        return head;
    }

    static int Add(ListNode head){
        if(head==null)
            return 1;
        
        int carry=Add(head.next);
        head.data+=carry;
        if(head.data<10)
            return 0;
        
        head.data=0;
        return 1;
    }

    public static void main(String[] args) {
        ListNode head;
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];

        for(int i=0;i<n;i++)    arr[i]=sc.nextInt();
        
        head=ArrayToLL(arr);

        TraverseLL(head);
        head=OptimalAddOne(head);
        TraverseLL(head);
    }
}