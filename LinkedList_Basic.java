import java.util.*;

public class LinkedList_Basic {
    static class Node{
        int data;
        Node next;
    
        Node(int data,Node next){
            this.data=data;
            this.next=next;
        }
    
        Node(int data){
            this.data=data;
            this.next=null;
        }
    }

    static Node ConvertArraytoLL(int[] arr){
        if(arr.length==0)   return null;

        Node head=new Node(arr[0]);
        Node temp=head;
        for(int i=1;i<arr.length;i++){
            Node newnode=new Node(arr[i]);
            temp.next=newnode;
            temp=temp.next;
        }
        return head;
    }

    static void TraverseLL(Node head){
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp=temp.next;
        }
        System.out.println();
    }

    static int Length(Node head){
        Node temp=head;
        int count=0;
        while(temp!=null){
            count++;
            temp=temp.next;
        }
        return count;
    }

    static boolean Search(Node head,int data){
        Node temp=head;

        while(temp!=null){
            if(temp.data==data)
                return true;
            temp=temp.next;
        }
        return false;
    }

    static Node DeleteHead(Node head){
        if(head==null)  return null;
        
        return head.next;
    }

    static Node DeleteTail(Node head){
        if(head==null || head.next==null)
            return null;

        Node temp=head;
        while(temp.next.next!=null)
            temp=temp.next;
        temp.next=null;
        
        return head;
    }

    static Node DeleteK(Node head,int k){
        if(head==null)  return null;
        if(k==1)    return head.next;

        Node temp=head;
        int count=1;
        while(temp!=null && count!=k-1){
            count++;
            temp=temp.next;
        }

        if(temp==null)
            return head;
        
        if(temp.next==null)
            return head;

        temp.next=temp.next.next;
        return head;
    }

    static Node DeleteValue(Node head,int data){
        if(head==null)
            return null;
        
        if(head.data==data)
            return head.next;
        Node temp=head.next;
        Node prev=head;

        while(temp!=null){
            if(temp.data==data){
                prev.next=temp.next;
                break;
            }
            prev=temp;
            temp=temp.next;
        }

        return head;
    }

    static Node InsertFirst(Node head,int data){
        Node newnode=new Node(data,head);
        return newnode;
    }

    static Node InsertLast(Node head,int data){
        Node newNode=new Node(data);
        Node temp=head;
        while(temp.next!=null)
            temp=temp.next;
        temp.next=newNode;
        return head;
    }

    static Node Insertk(Node head,int data,int k){
        if(head==null){
            if(k==1)
                return new Node(data);
            else
                return null;
        }
        
        if(k==1)
            return new Node(data,head);

        Node temp=head; 
        int count=0;

        while(temp!=null){
            count++;
            if(count==k-1){
                Node newNode=new Node(data,temp.next);
                temp.next=newNode;
                break;
            }
            temp=temp.next;
        }
        return head;
    }

    static Node InsertBeforeValue(Node head,int data,int value){
        if(head==null)
            return null;
        
        if(head.data==value)
            return new Node(data, head);
        
        Node temp=head;
        boolean found=false;
        while(temp.next!=null){

            if(temp.next.data==value){
                temp.next=new Node(data,temp.next);
                found=true;
                break;
            }
            temp=temp.next;
        }

        if(!found)
            System.out.println("Not Found");
        return head;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++)    arr[i]=sc.nextInt();

        Node head=ConvertArraytoLL(arr);
        TraverseLL(head);
        System.out.println(Length(head));

        System.out.println(Search(head, 1));

        head=InsertBeforeValue(head,100,1000000);
        TraverseLL(head);
    }
}