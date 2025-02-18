import java.util.Scanner;

public class Recursion_factorial {
    static int factorial(int i) {
        if (i == 1)
            return 1;
        else
            return i * (factorial(i - 1));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        System.out.println("The factorial is " + factorial(n));
    }
}
