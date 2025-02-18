import java.util.*;

public class StackQueue_LeastRecentlyUsed {
    static class LRUCache{
        static class Node{
            Node next,prev;
            int key,value;
            Node(int k,int v){
                key=k;
                value=v;
                next=prev=null;
            }
       }
        int capacity;
        Map<Integer,Node> cache;
        Node head,tail;

        public LRUCache(int capacity){
            this.capacity=capacity;
            cache=new HashMap<>();
            head=new Node(-1, -1);
            tail=new Node(-1, -1);

            tail.prev=head;
            head.next=tail;
        }

        public int get(int key){
            if(!cache.containsKey(key))
                return -1;
            Node temp=cache.get(key);
            deleteNode(temp);
            addNode(temp);
            return temp.value;
        }

        public void put(int key,int value){
            if(cache.containsKey(key)){
                Node temp=cache.get(key);
                deleteNode(temp);
                temp.value=value;
                addNode(temp);
            }
            else{
                if(cache.size()==capacity){
                    Node temp=tail.prev;
                    deleteNode(temp);
                    cache.remove(temp.key);
                }
                Node newNode=new Node(key, value);
                cache.put(key, newNode);
                addNode(newNode);
            }
        }

        public void deleteNode(Node temp){
            Node next=temp.next;
            Node prev=temp.prev;
            next.prev=prev;
            prev.next=next;
        }

        public void addNode(Node temp){
            Node next=head.next;
            temp.next=next;
            next.prev=temp;
            temp.prev=head;
            head.next=temp;
        }
    }


    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        LRUCache l=new LRUCache(4);
        l.put(2, 6);
        l.put(24, 7);
        l.put(8, 11);
        l.put(7, 10);
        System.out.println(l.get(2));
        System.out.println(l.get(8));
        l.put(5, 6);
        System.out.println(l.get(7));
        l.put(5, 7);
    }
    
}