public class StackQueue_QueueUsingLinkedList {
    static class Queue{
        static class Node{
            int data;
            Node next;
            public Node(int data){
                this.data=data;
                next=null;
            }
        }
        Node start,end;
        int size;
        public Queue(){
            size=0;
            start=end=null;
        }

        void push(int x){
            Node newNode=new Node(x);
            if(start==null)
                start=end=newNode;
            else{
                end.next=newNode;
                end=end.next;
            }
            size++;
        }

        int pop(){
            if(size==0){
                System.out.println("UnderFlow");
                return -1;
            }
            int val=start.data;
            start=start.next;
            size--;
            return val;
        }

        int peek(){
            if(start==null){
                System.out.println("UnderFlow");
                return -1;
            }

            return start.data;
        }

        int size(){
            return size;
        }

    }

    public static void main(String[] args) {
        Queue que=new Queue();

        que.push(1);
        que.push(2);
        que.push(3);
        que.push(4);
        que.push(5);
        que.push(6);
        System.out.println(que.peek());
        System.out.println(que.pop());
        System.out.println(que.pop());
        System.out.println(que.pop());
        System.out.println(que.pop());
        System.out.println(que.pop());
        System.out.println(que.pop());
        System.out.println(que.pop());
        System.out.println(que.pop());
        System.out.println(que.pop());
        que.push(12);
        System.out.println(que.peek());
    }
}
