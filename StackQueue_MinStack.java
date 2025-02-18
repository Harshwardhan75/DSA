import java.util.*;
public class StackQueue_MinStack {
    static class MinStack{
        static class Pair{
            int key;
            int value;
            public Pair(int k,int v){
                key=k;
                value=v;
            }
        }
        Stack<Pair> st;
        int min=Integer.MAX_VALUE;
        
        public MinStack(){
            st=new Stack<>();
        }

        void push(int x){
            if(st.isEmpty()){
                st.push(new Pair(x, x));
            }
            else{
                st.push(new Pair(x,Math.min(x,st.peek().value)));
            }
        }

        int pop(){
            return st.pop().key;
        }

        int peek(){
            return st.peek().key;
        }

        int getmin(){
            return st.peek().value;
        }
    }

    public static void main(String[] args) {
        MinStack st=new MinStack();
        st.push(1);
        st.push(2);
        st.push(3);
        st.push(4);
        st.push(5);
        st.push(0);
        System.out.println(st.getmin());
        System.out.println(st.pop());
        System.out.println(st.peek());
    }
}