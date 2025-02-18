import java.util.ArrayList;
import java.util.Scanner;

public class ArraysMedium_BestTimeToBuyAndSellstocks {

    //O(N^2)
    static int Brute(ArrayList<Integer> arr) {
        int profit = 0;
        for (int i = 0; i < arr.size(); i++) {
            for (int j = i + 1; j < arr.size(); j++) {
                profit = Math.max(profit, arr.get(j) - arr.get(i));
            }
        }
        return profit;
    }

    //O(N)
    static int Optimal(ArrayList<Integer> arr){
        int profit=0,min=arr.get(0);
        for(int i=1;i<arr.size();i++){
            profit=Math.max(profit,arr.get(i)-min);
            min=Math.min(min, arr.get(i));
        }

        return profit;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> arr = new ArrayList<>();

        for (int i = 0; i < n; i++)
            arr.add(sc.nextInt());

        System.out.println(arr);

        System.out.println("The Total Profit {BruteForce} is " + Brute(arr));

        System.out.println("The Total Profit {Optimal} is " + Optimal(arr));
    }
}
