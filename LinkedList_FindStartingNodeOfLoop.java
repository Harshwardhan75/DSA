import java.util.*;

public class LinkedList_FindStartingNodeOfLoop {
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

    static ListNode BruteFindStartMap(ListNode head){
        Map<ListNode,Integer> map=new HashMap<>();
        ListNode temp=head;
        while(temp!=null){
            if(map.containsKey(temp))
                return temp;
            map.put(temp, 1);
            temp=temp.next;
        }

        return null;
    }

    static ListNode BruteFindStartSet(ListNode head){
        Set<ListNode> set=new HashSet<>();
        ListNode temp=head;
        while(temp!=null){
            if(set.contains(temp))
                return temp;
            set.add(temp);
            temp=temp.next;
        }

        return null;
    }

    static ListNode OptimalFindStart(ListNode head){
        ListNode fast=head;
        ListNode slow=head;

        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(fast==slow){
                slow=head;
                while(slow!=fast){
                    slow=slow.next;
                    fast=fast.next;
                }
                return slow;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        ListNode head;
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];

        for(int i=0;i<n;i++)    arr[i]=sc.nextInt();
        
        head=ArrayToLL(arr);
        ListNode tail=head;
        while(tail.next!=null)
            tail=tail.next;
        
        tail.next=head.next;

        System.out.println(OptimalFindStart(head).data);
    }
}