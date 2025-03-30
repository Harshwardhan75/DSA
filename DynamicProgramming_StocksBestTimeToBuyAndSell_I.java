import java.util.Scanner;

public class DynamicProgramming_StocksBestTimeToBuyAndSell_I {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] prices=new int[n];
        for(int i=0;i<n;i++)
            prices[i]=sc.nextInt();
            
        System.out.println(maxProfit(prices));
    }

    static int maxProfit(int[] prices){
        int n=prices.length;
        int mini = prices[0];
        int profit = 0;

        for(int i=1;i<n;i++){
            int cost = prices[i]-mini;
            profit=Math.max(profit, cost);
            mini=Math.min(mini, prices[i]);
        }

        return profit;
    }
}
