import java.util.Scanner;

public class Recursion_sum_of_N_functional {
    
    static int SumOfN(int i){
        if(i==0) return 0;
        else return i+SumOfN(i-1);
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        int n=sc.nextInt();

        System.out.println("The Sum is "+SumOfN(n));
    }
}
