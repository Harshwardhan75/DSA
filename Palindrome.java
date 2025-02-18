import java.util.Scanner;

public class Palindrome {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n,num;
        n=num=sc.nextInt();
        int rev=0;
        if(n>=0)
        while(n!=0){
            int rem=n%10;
            rev=rev*10+rem;
            n/=10;
        }

        if(rev==num)
            System.out.println("It is Palindrome");
        else  
            System.out.println("It is Not a Palindrome"); 
    }
}
