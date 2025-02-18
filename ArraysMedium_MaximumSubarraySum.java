import java.util.ArrayList;
import java.util.Scanner;

public class ArraysMedium_MaximumSubarraySum {

    static int Brute(ArrayList<Integer> arr){
        int sum=0,max=Integer.MIN_VALUE;
        for(int i=0;i<arr.size();i++){
            sum=0;
            for(int j=i;j<arr.size();j++){
                sum+=arr.get(j);
                max=Math.max(max, sum);
            }
        }

        return max;
    }

    static int Optimal(ArrayList<Integer> arr){
        int sum=0,maxi=Integer.MIN_VALUE;

        for(int i=0;i<arr.size();i++){
            sum+=arr.get(i);
            maxi=Math.max(maxi, sum);

            if(sum<0)
                sum=0;
        }

        return maxi;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();

        ArrayList<Integer> arr=new ArrayList<>();

        for(int i=0;i<n;i++)    arr.add(sc.nextInt());

        System.out.println(arr);

        System.out.println(Optimal(arr));
    }
}
