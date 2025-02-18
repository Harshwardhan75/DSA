public class LinkedList_CreateDeepCopy {
    static class Node {
        int data;
        Node next;
        Node random;
    
        Node() {
            this.data = 0;
            this.next = null;
            this.random = null;
        }
    
        Node(int x) {
            this.data = x;
            this.next = null;
            this.random = null;
        }
    
        Node(int x, Node nextNode, Node randomNode) {
            this.data = x;
            this.next = nextNode;
            this.random = randomNode;
        }
    }

    static void insertCopyBetween(Node head){
        Node temp=head;
        while(temp!=null){
            Node newNode=new Node(temp.data);
            newNode.next=temp.next;
            temp.next=newNode;
            temp=temp.next.next;
        }
    }

    static void connectRandomPointer(Node head){
        Node temp=head;
        while(temp!=null){
            Node copy=temp.next;
            if(temp.random!=null)
                copy.random=temp.random.next;
            temp=temp.next.next;
        }
    }

    static Node connectNextPointer(Node head){
        Node dummy=new Node(-1);
        Node temp=head;
        Node res=dummy;

        while(temp!=null){
            res.next=temp.next;
            temp.next=temp.next.next;
            temp=temp.next;
            res=res.next;
        }
        return dummy.next;
    }

    static Node DeepCopy(Node head){
        insertCopyBetween(head);
        connectRandomPointer(head);
        Node newHead=connectNextPointer(head);
        return newHead;
    }

    static void printClonedLinkedList(Node head) {
        while (head != null) {
            System.out.print("Data: " + head.data);
            if (head.random != null) {
                System.out.print(", Random: " + head.random.data);
            } else {
                System.out.print(", Random: null");
            }
            System.out.println();
            head = head.next;
        }
    }
    
    public static void main(String[] args) {
        Node head = new Node(7);
        head.next = new Node(14);
        head.next.next = new Node(21);
        head.next.next.next = new Node(28);
    
        head.random = head.next.next;
        head.next.random = head;
        head.next.next.random = head.next.next.next;
        head.next.next.next.random = head.next;
    
        System.out.println("Original Linked List with Random Pointers:");
        printClonedLinkedList(head);
    
        Node clonedList = DeepCopy(head);
    
        System.out.println("\nCloned Linked List with Random Pointers:");
        printClonedLinkedList(clonedList);
    }
}
