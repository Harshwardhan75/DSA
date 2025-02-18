import java.util.Scanner;

public class LinkedList_RotateinKGroup {
    static class ListNode {
        int data;
        ListNode next;

        ListNode(int data, ListNode next) {
            this.data = data;
            this.next = next;
        }

        ListNode(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static ListNode ArrayToLL(int arr[]) {
        if (arr.length == 0)
            return null;

        ListNode head = new ListNode(arr[0]);
        ListNode temp = head;
        for (int i = 1; i < arr.length; i++) {
            ListNode newnode = new ListNode(arr[i]);
            temp.next = newnode;
            temp = temp.next;
        }
        return head;
    }

    static void TraverseLL(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    static ListNode RotateinKGroup(ListNode head, int k) {
        ListNode prevLast = null;
        ListNode kthNode = null;
        ListNode nextNode = null;
        ListNode temp = head;

        while(temp!=null){
            kthNode=findKthNode(temp,k);
            if(kthNode==null){
                if(prevLast!=null)
                    prevLast.next=temp;
                break;
            }
            nextNode=kthNode.next;
            kthNode.next=null;
            kthNode=reverse(temp);
            if(temp==head)
                head=kthNode;
            else    
                prevLast.next=kthNode;
            prevLast=temp;
            temp=nextNode;
        }

        return head;
    }

    static ListNode findKthNode(ListNode head,int k){
        int count=0;
        while(head!=null){
            count++;
            if(count==k)
                break;
            head=head.next;
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

    public static void main(String[] args) {
        ListNode head;
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        head = ArrayToLL(arr);
        TraverseLL(head);
        head = RotateinKGroup(head, k);
        TraverseLL(head);
    }
}