import java.util.Scanner;

public class LinkedList_RotateRightBykLL {
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


    static ListNode findTail(ListNode head,int d){
        while(head!=null){
            d--;
            if(d==0)
                return head;
            head=head.next;
        }
        return null;
    }
    public static ListNode RotateRight(ListNode head, int k) {
        if(head==null)  return null;
        int size=1;
        ListNode tail=head;
        while(tail.next!=null){
            size++;
            tail=tail.next;
        }
        tail.next=head;
        k=k%size;
        tail=findTail(head,size-k);
        head=tail.next;
        tail.next=null;
        return head;
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
        head = RotateRight(head, k);
        TraverseLL(head);
    }
}