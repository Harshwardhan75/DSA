import java.util.Scanner;

public class Recursion_Palindrome {

    static boolean checkPalindrome(String s,int i){
        if(i>=s.length()-i)
            return true;
        else if(s.charAt(i)==s.charAt(s.length()-i-1))
            return checkPalindrome(s,i+1);
        else
            return false;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String n=sc.next();

        System.out.println(n);
        int i=0;
        boolean status=checkPalindrome(n,i);

        if(status) 
            System.out.println("Palindrome");
        else
            System.out.println("Not a Palindrome");
    }
}
