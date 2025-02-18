import java.util.*;

public class ArraysHard_LargestSubArrayWithZeroSum {

    static int BruteSubArrayWithSum0(ArrayList<Integer> arr){
        int length=0;

        for(int i=0;i<arr.size();i++){
            for(int j=i;j<arr.size();j++){
                int sum=0;
                for(int k=i;k<=j;k++)
                    sum+=arr.get(k);
                if(sum==0)
                    length=Math.max(length,j-i+1);
            }
        }

        return length;
    }

    static int BetterSubArrayWithSum0(ArrayList<Integer> arr){
        int length=0;

        for(int i=0;i<arr.size();i++){
            int sum=0;
            for(int j=i;j<arr.size();j++){
                sum+=arr.get(j);
                if(sum==0)
                    length=Math.max(length,j-i+1);
            }
        }

        return length;
    }

    static int OptimalSubArrayWithSum0(ArrayList<Integer> arr){
        int length=0;
        Map<Integer,Integer> map=new HashMap<>();
        int sum=0;
        for(int i=0;i<arr.size();i++){
            sum+=arr.get(i);
            if(sum==0)
                length=Math.max(length,i+1);
             
            if(map.containsKey(sum))
                length=Math.max(length,i-map.get(sum));
            else
                map.put(sum,i);
        }

        return length;
    }

    

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();

        ArrayList<Integer> arr=new ArrayList<>();
        for(int i=0;i<n;i++)    arr.add(sc.nextInt());

        System.out.println(OptimalSubArrayWithSum0(arr));
    }
}