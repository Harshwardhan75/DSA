import java.util.*;

public class LinkedList_FindLengthOfLoopinLL {
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

    static int BruteFindLoopLengthMap(ListNode head){
        Map<ListNode,Integer> map=new HashMap<>();
        ListNode temp=head;
        int i=0;
        while(temp!=null){
            i++;
            if(map.containsKey(temp))
                return i-map.get(temp);
            map.put(temp, i);
            temp=temp.next;
        }

        return 0;
    }

    static int OptimalFindLengthOfLoop(ListNode head){
        ListNode fast=head;
        ListNode slow=head;

        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if(fast==slow){
                int count=1;
                fast=fast.next;
                while(fast!=slow){
                    count++;
                    fast=fast.next;
                }
                return count;
            }
        }

        return 0;
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

        System.out.println(OptimalFindLengthOfLoop(head));
    }
}