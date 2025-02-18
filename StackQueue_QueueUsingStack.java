import java.util.*;

public class StackQueue_QueueUsingStack {
    static class Queue1{
        Stack<Integer> st1,st2;
        int size;
        public Queue1(){
            st1=new Stack<>();
            st2=new Stack<>();
            size=0;
        }

        void push(int x){
            while(!st1.isEmpty()){
                st2.push(st1.pop());
            }

            st1.push(x);
            while(!st2.isEmpty())
            st1.push(st2.pop());
            size++;
        }

        int pop(){
            if(st1.isEmpty()){
                System.out.println("UnderFlow");
                return -1;
            }

            return st1.pop();
        }

        int peek(){
            if(st1.isEmpty()){
                System.out.println("UnderFlow");
                return -1;
            }

            return st1.peek();
        }
    }

    static class Queue2{
        Stack<Integer> st1,st2;
        int size;
        public Queue2(){
            st1=new Stack<>();
            st2=new Stack<>();
            size=0;
        }

        void push(int x){
            st1.push(x);
        }

        int pop(){
            if(!st2.isEmpty())
                return st2.pop();
            else{
                while(!st1.isEmpty())
                    st2.push(st1.pop());
                return st2.pop();
            }
        }

        int peek(){
            if(!st2.isEmpty())
                return st2.peek();
            else{
                while(!st1.isEmpty())
                    st2.push(st1.pop());
                return st2.peek();
            }
        }
    }

    public static void main(String[] args) {
        Queue2 que=new Queue2();
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
        que.push(12);
        System.out.println(que.peek());
        System.out.println(que.pop());
        System.out.println(que.pop());
        System.out.println(que.pop());
        System.out.println(que.pop());
    }
}
