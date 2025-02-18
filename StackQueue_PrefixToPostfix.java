import java.util.Scanner;
import java.util.Stack;

public class StackQueue_PrefixToPostfix {

    static String PrefixtoPostfix(String s){
        Stack<String> st=new Stack<>();
        int i=s.length()-1;

        while(i>=0){
            char c=s.charAt(i);
            if(Character.isLetterOrDigit(c))
                st.push(s.substring(i, i+1));
            else{
                String t1=st.pop();
                String t2=st.pop();
                String con=t1+t2+c;
                st.push(con);
            }
            i--;
        }
        return st.peek();
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.next();
        System.out.println(PrefixtoPostfix(s));
    }
}