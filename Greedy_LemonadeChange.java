import java.util.Scanner;

public class Greedy_LemonadeChange {

    static boolean FindPossible(int[] arr) {
        int five = 0, ten = 0;

        for (int i : arr) {
            if (i == 5)
                five++;
            else if (i == 10) {
                ten++;
                if (five > 0)
                    five--;
                else
                    return false;
            } else {
                if (ten > 0 && five > 0) {
                    ten--;
                    five--;
                } else if (five >= 3)
                    five -= 3;
                else
                    return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        System.out.println(FindPossible(arr));
    }
}
