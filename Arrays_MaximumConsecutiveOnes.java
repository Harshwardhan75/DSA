import java.util.ArrayList;
import java.util.Scanner;

public class Arrays_MaximumConsecutiveOnes {

    static int countOnes(ArrayList<Integer> arr) {
        int max = 0;
        int count = 0;

        for (int var : arr) {
            if (var == 0) {
                if (count > max)
                    max = count;
                count = 0;
            } else
                count++;
        }

        if (count > max)
            max = count;

        return max;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < n; i++)
            arr.add(sc.nextInt());

        System.out.println("The Maxium Number Of Consecutive Ones are " + countOnes(arr));
    }
}
