import java.util.*;

public class LinkedList_SortLL012 {

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

    static ListNode BruteSortLL012(ListNode head){
        ListNode temp=head;
        int cnt0=0,cnt1=0,cnt2=0;

        while(temp!=null){
            if(temp.data==0)
                cnt0++;
            else if(temp.data==1)
                cnt1++;
            else
                cnt2++;
            temp=temp.next;
        }

        temp=head;

        while(temp!=null){
            if(cnt0!=0){
                temp.data=0;
                cnt0--;
            }
            else if(cnt1!=0){
                temp.data=1;
                cnt1--;
            }
            else{
                temp.data=2;
                cnt2--;
            }
            temp=temp.next;
        }

        return head;
    }

    static ListNode OptimalSortLL012(ListNode head){
        ListNode zeroHead=new ListNode(-1);
        ListNode oneHead=new ListNode(-1);
        ListNode twoHead=new ListNode(-1);
        ListNode zero=zeroHead;
        ListNode one=oneHead;
        ListNode two=twoHead;
        ListNode temp=head;

        while(temp!=null){
            if(temp.data==0){
                zero.next=temp;
                zero=zero.next;
                // zero=temp;
            }
            else if(temp.data==1){
                one.next=temp;
                one=one.next;
                // one=temp;
            }
            else{
                two.next=temp;
                two=two.next;
                // two=temp;
            }
            temp=temp.next;
        }

        two.next=null;
        one.next=twoHead.next;
        zero.next=oneHead.next;

        return zeroHead.next;
    }

    public static void main(String[] args) {
        ListNode head;
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];

        for(int i=0;i<n;i++)    arr[i]=sc.nextInt();
        
        head=ArrayToLL(arr);

        TraverseLL(head);
        head=OptimalSortLL012(head);
        TraverseLL(head);
    }
}