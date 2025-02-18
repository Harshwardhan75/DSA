import java.util.Scanner;

public class Recursion_N_1 {
    static void PrintN_1(int i){
        if(i==0)    return;
        
        System.out.println(i);
        PrintN_1(i-1);
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        PrintN_1(n);
    }
}
