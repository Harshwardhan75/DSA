import java.util.*;

public class StackQueue_RemoveKDigits {

    static String RemoveKDigits(String s,int k){
        Stack<Character> st=new Stack<>();
        for(int i=0;i<s.length();i++){
            while(!st.isEmpty() && k>0 && (st.peek()-'0')>(s.charAt(i)-'0')){
                st.pop();
                k--;
            }
            st.push(s.charAt(i));
        }

        while(!st.isEmpty() && k>0){
            st.pop();
            k--;
        }

        if(st.isEmpty())    return "0";

        StringBuilder ans=new StringBuilder();
        while(!st.isEmpty())
            ans.append(st.pop());
        
        while(!ans.isEmpty() && ans.charAt(ans.length()-1)=='0')
            ans.deleteCharAt(ans.length()-1);
        
        if(ans.isEmpty())   return "0";

        return ans.reverse().toString();
    }
    
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.next();
        int k=sc.nextInt();
        System.out.println(RemoveKDigits(s,k));
    }

}
