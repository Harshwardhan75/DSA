import java.util.*;

public class LinkedList_SortLL {
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

    static ListNode BruteSortLL(ListNode head){
        if(head==null || head.next==null)
            return head;
        ListNode temp=head;
        ArrayList<Integer> arr=new ArrayList<>();

        while(temp!=null){
            arr.add(temp.data);
            temp=temp.next;
        }

        Collections.sort(arr);
        temp=head;
        int i=0;
        while(temp!=null){
            temp.data=arr.get(i);
            temp=temp.next;
            i++;
        }

        return head;
    }

    static ListNode OptimalSortLL(ListNode head){
        if(head==null || head.next==null)
            return head;
        
        return MergeSort(head);
    }

    static ListNode FindMiddle(ListNode head){
        ListNode slow=head;
        ListNode fast=head;
        fast=fast.next;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }

    static ListNode MergeSort(ListNode head){
        if(head==null || head.next==null)
            return head;
        
        ListNode middle=FindMiddle(head);
        ListNode left=head;
        ListNode right=middle.next;
        middle.next=null;
        left=MergeSort(left);
        right=MergeSort(right);
        return Merge(left,right);
    }

    static ListNode Merge(ListNode left,ListNode right){
        ListNode dummy=new ListNode(-1);
        ListNode temp=dummy;

        while (left!=null && right!=null) {
            if(left.data<right.data){
                temp.next=left;
                left=left.next;
            }
            else{
                temp.next=right;
                right=right.next;
            }
            temp=temp.next;
        }

        if(left!=null)
            temp.next=left;
        if(right!=null)
            temp.next=right;
        
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head;
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];

        for(int i=0;i<n;i++)    arr[i]=sc.nextInt();
        
        head=ArrayToLL(arr);

        TraverseLL(head);
        head=OptimalSortLL(head);
        TraverseLL(head);
    }
}
