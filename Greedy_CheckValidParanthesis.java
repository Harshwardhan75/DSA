import java.util.Scanner;

public class Greedy_CheckValidParanthesis {

    static boolean bruteCheckValidString(String s){
        return check(s,0,0);
    }

    static boolean check(String s,int index,int count){
        if(count<0) return false;

        if(index==s.length())
            return count==0;
        
        if(s.charAt(index)=='(')
            return check(s, index+1, count+1);
        else if(s.charAt(index)==')')
            return check(s, index+1, count-1);
        else
            return check(s, index+1, count+1)  ||
            check(s, index+1, count-1) ||
            check(s, index+1, count);
    }

    static boolean optimalCheckValidString(String s){
        int min=0,max=0;

        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(c=='('){
                min++;
                max++;
            }
            else if(c==')'){
                min--;
                max--;
            }
            else{
                min--;
                max++;
            }
            if(max<0)
                return false;
            if(min<0)
                min=0;
        }

        return min==0;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.next();
        System.out.println(bruteCheckValidString(s));
        System.out.println(optimalCheckValidString(s));
    }
}
