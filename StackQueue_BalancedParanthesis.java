import java.util.Scanner;
import java.util.Stack;

public class StackQueue_BalancedParanthesis {

    static String isBalanced(String s){
        Stack<Character> st=new Stack<>();
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(c=='(' || c=='[' || c=='{')
                st.push(c);
            else{
                if(st.isEmpty())
                    return "Not Balanced";
                else{
                    char ch=st.pop();
                    if((c==')' && ch!='(') || (c==']' && ch!='[') || (c=='}' && ch!='{'))
                        return "Not Balanced";
                }
            }
        }
        if(!st.isEmpty())
            return "Not Balanced";
        else
            return "Balanced";
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.next();

        System.out.println(isBalanced(s));
    }
}
