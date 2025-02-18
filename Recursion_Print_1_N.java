import java.util.Scanner;

public class Recursion_Print_1_N {
    static void Print1_N(int i,int n){
        if(i>n) return;

        System.out.println(i);
        Print1_N(i+1, n);
    }    
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();

        Print1_N(1,n);
    }
}
