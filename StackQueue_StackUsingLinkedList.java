public class StackQueue_StackUsingLinkedList {
    static class Stack{
        static class Node{
            int data;
            Node next;
            public Node(int data){
                this.data=data;
                next=null;
            }
        }
        Node top;
        int size;
        public Stack(){
            top=null;
            size=0;
        }

        void push(int x){
            Node newNode=new Node(x);
            newNode.next=top;
            top=newNode;
            size++;
        }

        int pop(){
            if(top==null){
                System.out.println("UnderFlow");
                return -1;
            }
            int val=top.data;
            top=top.next;
            size--;
            return val;
        }

        int peek(){
            if(top==null){
                System.out.println("UnderFlow");
                return -1;
            }
            return top.data;
        }

        int size(){
            return size;
        }

    }

    public static void main(String[] args) {
        Stack st=new Stack();
        st.push(1);
        st.push(2);
        st.push(3);
        st.push(4);
        st.push(5);
        st.push(6);
        System.out.println(st.peek());
        System.out.println(st.pop());
        System.out.println(st.pop());
        System.out.println(st.pop());
        System.out.println(st.pop());
        System.out.println(st.pop());
        System.out.println(st.pop());
        System.out.println(st.pop());
    }
}
