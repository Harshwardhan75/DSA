import java.util.*;

public class StackQueue_StockSpanProblem {
    static class StockSpanner{
        static class Pair{
            int key;
            int val;
            Pair(int k,int v){
                this.key=k;
                this.val=v;
            }
        }

        static Stack<Pair> st;
        static int index=-1;
        StockSpanner(){
            st=new Stack<>();
        }
        
        ArrayList<Integer> arr=new ArrayList<>();
        int Brutenext(int val){
            int count=0;
            arr.add(val);
            int i=arr.size()-1;
            while(i>=0 && arr.get(i--)<=val)
                count++;
            return count;
        }

        int next(int val){
            index++;
            while(!st.isEmpty() && st.peek().val<=val)
                st.pop();
            int ans=index-(st.isEmpty()?-1:st.peek().key);
            st.push(new Pair(index,val));
            return ans;
        }
    }

    public static void main(String[] args) {
        StockSpanner ss=new StockSpanner();
        System.out.println(ss.Brutenext(7));
        System.out.println(ss.Brutenext(2));
        System.out.println(ss.Brutenext(1));
        System.out.println(ss.Brutenext(3));
        System.out.println(ss.Brutenext(3));
        System.out.println(ss.Brutenext(1));
        System.out.println(ss.Brutenext(8));
        
        System.out.println(ss.next(7));
        System.out.println(ss.next(2));
        System.out.println(ss.next(1));
        System.out.println(ss.next(3));
        System.out.println(ss.next(3));
        System.out.println(ss.next(1));
        System.out.println(ss.next(8));
    }
}
