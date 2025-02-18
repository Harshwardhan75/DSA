import java.util.Scanner;

public class LinkedList_DeleteOccurenceOfKeyinDLL {
    static class Node{
        int data;
        Node next;
        Node prev;

        public Node(int data,Node next,Node prev){
            this.data=data;
            this.next=next;
            this.prev=prev;
        }

        public Node(int data){
            this.data=data;
            this.next=null;
            this.prev=null;
        }
    }

    static Node ConvertArraytoDLL(int[] arr){
        int n=arr.length;
        Node head=new Node(arr[0]);
        Node prev=head;

        for(int i=1;i<n;i++){
            Node newnode=new Node(arr[i], null, prev);
            prev.next=newnode;
            prev=prev.next;
        }
        return head;
    }

    static void TraverseDLL(Node head){
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp=temp.next;
        }
        System.out.println();
    }

    static Node DeleteOccurenceOfkey(Node head,int key){
        Node temp=head;
        while(temp!=null){
            if(temp.data==key){
                if(temp==head)
                    head=head.next;
                Node prevNode=temp.prev;
                Node nextNode=temp.next;
                if(prevNode!=null)  
                    prevNode.next=nextNode;

                if(nextNode!=null)
                    nextNode.prev=prevNode;
            }
            temp=temp.next;
        }
        return head;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];
        int key=sc.nextInt();
        for(int i=0;i<n;i++)    arr[i]=sc.nextInt();

        Node head=ConvertArraytoDLL(arr);
        TraverseDLL(head);
        head=DeleteOccurenceOfkey(head,key);
        TraverseDLL(head);
    }
}