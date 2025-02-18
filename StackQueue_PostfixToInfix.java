import java.util.Scanner;
import java.util.Stack;

public class StackQueue_PostfixToInfix {

    static String PostfixtoInfix(String s){
        Stack<String> st=new Stack<>();
        int i=0;
        while(i<s.length()){
            char c=s.charAt(i);
            if((c>='A' && c<='Z') || (c>='a' && c<='z') || (c>='0' && c<='9'))
                st.push(s.substring(i,i+1));
            else{
                String t1=st.pop();
                String t2=st.pop();
                String con='('+t2+c+t1+')';
                st.push(con);
            }
            i++;
        }

        return st.peek();
    }

    
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.next();

        System.out.println(PostfixtoInfix(s));
    }
}