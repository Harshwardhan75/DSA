import java.util.*;

public class ArraysMedium_TotalSubArrayWithSumK {

    static int BruteTotalSubArraywithsumK(ArrayList<Integer> arr,int K){
        int count=0;

        for(int i=0;i<arr.size();i++){
            for(int j=i;j<arr.size();j++){
                int sum=0;
                for(int k=i;k<=j;k++)
                    sum+=arr.get(k);
                
                if(sum==K)  count++;
            }
        }

        return count;
    }

    static int BetterTotalSubArraywithsumK(ArrayList<Integer> arr,int K){
        int count=0;

        for(int i=0;i<arr.size();i++){
            int sum=0;
            for(int j=i;j<arr.size();j++){
                sum+=arr.get(j);
                if(sum==K)  count++;
            }
        }

        return count;
    }

    static int OptimalTotalSubArraywithsumK(ArrayList<Integer> arr,int K){
        Map<Integer,Integer> map=new HashMap<>();
        map.put(0,1);
        int count=0;
        int presum=0;
        for(int i=0;i<arr.size();i++){
            presum+=arr.get(i);
            int rem=presum-K;
            count+=map.getOrDefault(rem,0);
            map.put(presum,map.getOrDefault(presum, 0)+1);
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        ArrayList<Integer> arr=new ArrayList<>();

        for(int i=0;i<n;i++)    arr.add(sc.nextInt());

        System.out.println(arr);

        int K=sc.nextInt();
        System.out.println(OptimalTotalSubArraywithsumK(arr,K));
    }
}
