import java.util.Scanner;

public class Recursion_PrintN_1_Backtracking {
    static void PrintN_1(int i,int n){
        if(i>n) return;

        PrintN_1(i+1, n);
        System.out.println(i);
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();

        PrintN_1(1,n);
    }
}
