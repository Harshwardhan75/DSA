import java.util.*;

public class Recursion_1_N_BackTracking {
    
    static void Print1_N(int i){
        if(i==0)    return;

        Print1_N(i-1);
        System.out.println(i);
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();

        Print1_N(n);
    }
}
