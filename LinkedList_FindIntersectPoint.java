import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class LinkedList_FindIntersectPoint {
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

    static ListNode BruteFindIntersectionMap(ListNode A,ListNode B){
        Map<ListNode,Boolean> map=new HashMap<>();
        ListNode temp=A;

        while(temp!=null){
            map.put(temp,true);
            temp=temp.next;
        }

        temp=B;
        while(temp!=null){
            if(map.containsKey(temp))
                return temp;
            temp=temp.next;
        }
        return null;
    }

    static ListNode BruteFindIntersectionSet(ListNode A,ListNode B){
        Set<ListNode> set=new HashSet<>();
        ListNode temp=A;

        while(temp!=null){
            set.add(temp);
            temp=temp.next;
        }

        temp=B;
        while(temp!=null){
            if(set.contains(temp))
                return temp;
            temp=temp.next;
        }
        return null;
    }

    static ListNode BetterFindIntersection(ListNode A,ListNode B){
        int la=0,lb=0;
        ListNode temp=A;
        while(temp!=null){
            la++;
            temp=temp.next;
        }
        temp=B;
        while(temp!=null){
            lb++;
            temp=temp.next;
        }

        if(la<lb)
            return CollisionPoint(A,B,lb-la);
        else    
            return CollisionPoint(B,A,la-lb);
    }

    static ListNode CollisionPoint(ListNode small,ListNode large,int d){
        while(d>0)
            large=large.next;
        
        while(small!=large){
            small=small.next;
            large=large.next;
        }

        return small;
    }

    static ListNode OptimalFindIntersection(ListNode A,ListNode B){
        ListNode temp1=A;
        ListNode temp2=B;

        while(temp1!=temp2){
            temp1=temp1.next;
            temp2=temp2.next;

            if(temp1==temp2)
                break;
            
            if(temp1==null)
                temp1=B;
            if(temp2==null)
                temp2=A;
        }

        return temp1;
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

        head1.next.next=head2.next.next;
        ListNode node=OptimalFindIntersection(head1,head2);
        System.out.println(node.data);
    }
}