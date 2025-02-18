import java.util.Scanner;

public class LinkedList_AddTwoNumbers {

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

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy=new ListNode(-1);
        ListNode temp=dummy;
        int carry=0;
        while(l1!=null || l2!=null){
            int sum=carry;
            if(l1!=null){
                sum+=l1.data;
                l1=l1.next;
            }
            if(l2!=null){
                sum+=l2.data;
                l2=l2.next;
            }

            ListNode newNode=new ListNode(sum%10);
            carry=sum/10;
            temp.next=newNode;
            temp=temp.next;
        }

        if(carry==1)
            temp.next=new ListNode(1);
        
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head1,head2;
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int[] arr1=new int[n];
        int[] arr2=new int[m];
        for(int i=0;i<n;i++)    arr1[i]=sc.nextInt();
        for(int i=0;i<m;i++)    arr2[i]=sc.nextInt();
        
        head1=ArrayToLL(arr1);
        head2=ArrayToLL(arr2);

        ListNode head=addTwoNumbers(head1,head2);
        TraverseLL(head);
    }
}
