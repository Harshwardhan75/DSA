import java.util.Scanner;


public class LinkedList_DoublyLL {

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

    static Node DeleteHead(Node head){
        if(head==null)
            return head;
        
        head=head.next;
        head.prev.next=null;
        head.prev=null;
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

    static Node DeleteTail(Node head){
        if(head==null || head.next==null)
            return null;
        
        Node temp=head;
        while(temp.next!=null)
            temp=temp.next;
        
        temp.prev.next=null;
        temp.prev=null;
        return head;
    }

    static Node DeleteK(Node head,int k){
        if(head==null)
            return null;
         
        int count=0;
        Node temp=head;

        while(temp!=null){
            count++;
            if(count==k){
                break;
            }
            temp=temp.next;
        }

        if(temp==null)
            return head;

        Node prev=temp.prev;
        Node next=temp.next;

        if(prev==null && next==null)
            return null;
        else if(prev==null)
            return DeleteHead(head);
        else if(next==null)
            return DeleteTail(head);
        else{
            prev.next=next;
            next.prev=prev;
            temp.next=null;
            temp.prev=null;
        }
        
        return head;
    }
    
    static void deleteNode(Node temp){
        Node prev=temp.prev;
        Node next=temp.next;

        if(next==null){
            prev.next=null;
            temp.prev=null;
            return;
        }
        prev.next=next;
        next.prev=prev;
        temp.next=null;
        temp.prev=null;
    }

    static Node InsertBeforeHead(Node head,int data){
        Node newNode=new Node(data,head,null);
        head.prev=newNode;
        head=head.prev;
        return head;
    }

    static Node InsertBeforeTail(Node head,int data){
        if(head==null)
            return null;
        if(head.next==null)
            return InsertBeforeHead(head, data);

        Node temp=head;
        while(temp.next!=null)
            temp=temp.next;
        
        Node prev=temp.prev;
        Node newNode=new Node(data,temp,prev);
        prev.next=newNode;
        temp.prev=newNode;
        return head;
    }

    static Node InsertBeforeK(Node head,int data,int k){
        if(head==null)  return null;
        if(k==1)    return InsertBeforeHead(head, data);
        int count=0;
        Node temp=head;
        while(temp!=null){
            count++;
            if(count==k)
                break;
            temp=temp.next;
        }

        Node prev=temp.prev;
        Node newNode=new Node(data,temp,prev);
        prev.next=newNode;
        temp.prev=newNode;

        return head;
    }

    static void InsertBeforeNode(Node temp,int data){
        Node prev=temp.prev;
        Node newNode=new Node(data,temp,prev);
        prev.next=newNode;
        temp.prev=newNode;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++)    arr[i]=sc.nextInt();

        Node head=ConvertArraytoDLL(arr);
        TraverseDLL(head);
        InsertBeforeNode(head.next.next.next, 12);
        TraverseDLL(head);
    }
}