import java.util.ArrayList;
import java.util.Scanner;

public class Greedy_MinimumCoinChange {

    static ArrayList<Integer> FindMinCoin(int v){
        ArrayList<Integer> arr=new ArrayList<>();
        int[] coins=new int[]{1,2,5,10,20,50,100,500,1000};
        int i=coins.length-1;

        for(i=i;i>=0;i--){
            while(v>=coins[i]){
                arr.add(coins[i]);
                v-=coins[i];
            }
        }

        return arr;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int v=sc.nextInt();

        System.out.println(FindMinCoin(v));
    }
}
