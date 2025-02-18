import java.util.Scanner;
import java.util.Stack;

public class StackQueue_InfixToPrefix {

    static String InfixToPrefix(String s){
        String reverse="";
        for(int i=s.length()-1;i>=0;i--){
            if(s.charAt(i)==')')    reverse+='(';
            else    if(s.charAt(i)=='(')    reverse+=')';
            else    reverse+=s.charAt(i);
        }
        System.out.println(reverse);
        String ans="";
        int i=0;
        Stack<Character> st=new Stack<>();

        while(i<reverse.length()){
            char c=reverse.charAt(i);
            if((c>='A' && c<='z') || (c>='a' && c<='z') || (c>='0' && c<='9'))
                ans+=c;
            else
            if(c=='(')  st.push(c);
            else
            if(c==')'){
                while(!st.isEmpty() && st.peek()!='(')
                    ans+=st.pop();
                st.pop();
            }
            else{
                while(!st.isEmpty() && priority(c)<priority(st.peek()))
                    ans+=st.pop();
                st.push(c);
            }
            i++;
        }

        while(!st.isEmpty())
            ans+=st.pop();

        return new StringBuilder(ans).reverse().toString();
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

        System.out.println(InfixToPrefix(s));
    }
}
