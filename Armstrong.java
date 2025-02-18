import java.util.Scanner;

public class Armstrong {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n,num;
        n=num=sc.nextInt();
        int rem,anum=0;
        while(n!=0){
            rem=n%10;
            anum+=rem*rem*rem;
            n/=10;
        }

        if(anum==num)
            System.out.println("It is ArmStrong Number");
        else
            System.out.println("It is not a ArmStrong Number");
    }
}
