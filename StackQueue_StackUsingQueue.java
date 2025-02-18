import java.util.*;
public class StackQueue_StackUsingQueue {
    static class Stack{
        Queue<Integer> que;
        int size;
        Stack(){
            que=new LinkedList<>();
            size=0;
        }

        void push(int x){
            int n=que.size();
            que.offer(x);
            for(int i=0;i<n;i++)
                que.offer(que.poll());
            size++;
        }

        int pop(){
            if(size==0){
                System.out.println("UnderFlow");
                return -1;
            }
            size--;
            return que.poll();
        }

        int peek(){
            if(size==0){
                System.out.println("UnderFlow");
                return -1;
            }
            return que.peek();
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
        st.push(1);
        System.out.println(st.peek());
    }
}