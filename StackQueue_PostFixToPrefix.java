import java.util.Scanner;
import java.util.Stack;

public class StackQueue_PostFixToPrefix {

    static String PostFixtoPrefix(String s){
        Stack<String> st=new Stack<>();
        int i=0;
        while(i<s.length()){
            char c=s.charAt(i);
            if(Character.isLetterOrDigit(c))
                st.push(s.substring(i, i+1));
            else{
                String t1=st.pop();
                String t2=st.pop();
                String con=c+t2+t1;
                st.push(con);
            }
            i++;
        }

        return st.peek();
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.next();
        System.out.println(PostFixtoPrefix(s));
    }
}
