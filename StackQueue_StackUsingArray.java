import java.util.Scanner;

public class StackQueue_StackUsingArray {

    static class Stack{
        static int[] st;
        static int top;
        int size;
        public Stack(int size){
            this.size=size;
            st=new int[size];
            top=-1;
        }

        void push(int x){
            if(isFull()){
                System.out.println("OverFlow");
                return;
            }
            top++;
            st[top]=x;
        }

        int pop(){
            if(isEmpty()){
                System.out.println("UnderFlow");
                return -1;
            }
            int val=st[top];
            top--;
            return val;
        }

        int peek(){
            if(isEmpty()){
                System.out.println("UnderFlow");
                return -1;
            }
            return st[top];
        }

        int size(){
            return top+1;
        }

        boolean isFull(){
            return top==size-1;
        }

        boolean isEmpty(){
            return top==-1;
        }

    }

    public static void main(String[] args) {
        Stack st=new Stack(5);
        st.push(1);
        st.push(2);
        st.push(3);
        st.push(4);
        st.push(5);
        st.push(6);
        System.out.println(st.pop());
        System.out.println(st.pop());
        System.out.println(st.pop());
        System.out.println(st.pop());
        System.out.println(st.pop());
        System.out.println(st.pop());
        System.out.println(st.pop());
    }
}