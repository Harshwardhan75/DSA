import java.util.Scanner;

public class Recursion_sum_of_N_Parameterized {

    static int SumOfN(int i, int sum) {
        if (i < 0)
            return sum;
        else {
            return SumOfN(i - 1, sum + i);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        System.out.println("The sum is " + SumOfN(n, 0));
    }
}