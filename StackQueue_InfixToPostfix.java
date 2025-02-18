import java.util.Scanner;
import java.util.Stack;

public class StackQueue_InfixToPostfix {

    static String InfixToPostfix(String s){
        int i=0;
        String ans="";
        Stack<Character> st=new Stack<>();
        while(i<s.length()){
            char c=s.charAt(i);
            if((c>='A' && c<='Z') || (c>='a' && c<='z') || (c>='0' && c<='9'))
                ans+=c;
            else
            if(c=='(')
                st.push(c);
            else
            if(c==')'){
                while(!st.isEmpty() && st.peek()!='('){
                    ans+=st.peek();
                    st.pop();
                }
                st.pop();
            }
            else{
                while(!st.isEmpty() && priority(c)<=priority(st.peek())){
                    ans+=st.peek();
                    st.pop();
                }
                st.push(c);
            }
            i++;
        }

        while(!st.isEmpty())
            ans+=st.pop();
        
        return ans;
    }

    static int priority(char c){
        switch(c){
            case '^': return 3;
            case '*': return 2;
            case '/': return 2;
            case '+': return 1;
            case '-': return 1;
            default : return -1;
        }
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.next();

        System.out.println(InfixToPostfix(s));
    }
}
