import java.util.*;

public class ArraysHard_MaximumProductSubarray {

    static int BruteMaximumProduct(ArrayList<Integer> arr){
        int max=Integer.MIN_VALUE;

        for(int i=0;i<arr.size();i++){
            for(int j=i;j<arr.size();j++){
                int product=1;
                for(int k=i;k<=j;k++)
                    product*=arr.get(k);
                max=Math.max(max, product);
            }
        }

        return max;
    }

    static int BetterMaximumProduct(ArrayList<Integer> arr){
        int max=Integer.MIN_VALUE;

        for(int i=0;i<arr.size();i++){
            int product=1;
            for(int j=i;j<arr.size();j++){
                product*=arr.get(j);
                max=Math.max(max, product);
            }
        }

        return max;
    }

    static int OptimalMaximumProduct(ArrayList<Integer> arr){
        double prefix=1,suffix=1,max=Integer.MIN_VALUE;

        for(int i=0;i<arr.size();i++){
            if(prefix==0)   prefix=1;
            if(suffix==0)   suffix=1;

            prefix*=arr.get(i);
            suffix*=arr.get(arr.size()-1-i);

            max=Math.max(max, Math.max(prefix, suffix));
        }

        return (int)max;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        ArrayList<Integer> arr=new ArrayList<>();

        for(int i=0;i<n;i++)    arr.add(sc.nextInt());

        System.out.println(arr);

        System.out.println(OptimalMaximumProduct(arr));
    }
}