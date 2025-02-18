import java.util.*;

public class LinkedList_DetectLoop {
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

    static boolean BruteDetectLoopMap(ListNode head){
        Map<ListNode,Boolean> map=new HashMap<>();
        ListNode temp=head;

        while(temp!=null){
            if(map.containsKey(temp))
                return true;
            
            map.put(temp, true);
            temp=temp.next;
        }
        return false;
    }

    static boolean BruteDetectLoopSet(ListNode head){
        Set<ListNode> map=new HashSet();
        ListNode temp=head;

        while(temp!=null){
            if(map.contains(temp))
                return true;
            
            map.add(temp);
            temp=temp.next;
        }
        return false;
    }

    static boolean OptimalDetectLoop(ListNode head){
        ListNode fast=head;
        ListNode slow=head;

        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if(slow==fast)
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        ListNode head;
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];

        for(int i=0;i<n;i++)    arr[i]=sc.nextInt();
        
        head=ArrayToLL(arr);
        System.out.println(BruteDetectLoopMap(head));
    }
}