import java.util.Scanner;

public class Recursion_Ntimes {
    
    static void Print(int n,int x){
        if(n>x)
            return;
        else{
            System.out.printf("%d\t",n);
            Print(n+1,x);
        }
    }

    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int x=sc.nextInt();
        Print(1,x);
    }
}
