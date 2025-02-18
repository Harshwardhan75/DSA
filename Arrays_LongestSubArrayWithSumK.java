import java.util.*;
//Positive Array
public class Arrays_LongestSubArrayWithSumK {
    //BRUTEFORCE APPROACH_1 O(n^3)
    static int BA1SubArraySum(ArrayList<Integer> arr,int K){
        int maxlength=0;
        for(int i=0;i<arr.size();i++){
            for(int j=i;j<arr.size();j++){
                int sum=0;
                for(int k=i;k<=j;k++)
                    sum+=arr.get(i);
                if(sum==K)  maxlength=Math.max(maxlength,j-i+1);
            }
        }
        return maxlength;
    }

    //BRUTEFORCE APPROACH_2 O(n^2)
    static int BA2SubArraySum(ArrayList<Integer> arr,int K){
        int maxlength=0;
        for(int i=0;i<arr.size();i++){
            int sum=0;
            for(int j=i;j<arr.size();j++){
                sum+=arr.get(i);
                if(sum==K)  maxlength=Math.max(maxlength,j-i+1);
            }
        }
        return maxlength;
    }

    //BETTER APPROACH POSITIVE+NEGATIVE
    static int BetterSubArraySum(ArrayList<Integer> arr,int K){
        Map<Integer,Integer> map=new HashMap<>();
        int length=0;
        int sum=0;
        for(int i=0;i<arr.size();i++){
            sum+=arr.get(i);
            if(sum==K){
                length=Math.max(length,i+1);
            }
            int rem=sum-K;
            if(map.containsKey(rem)){
                int len=i-map.get(rem);
                length=Math.max(length, len);
            }
            if(!map.containsKey(sum))
                map.put(sum,i);
        }

        return length;
    }

    //OPTIMAL APPROACH
    static int OptimalSubArraySum(ArrayList<Integer> arr,int K){
        int i=0,j=0;
        int length=0;
        int sum=arr.get(0);
        
        while(i<arr.size()){
            while(j<=i && sum>K){
                sum-=arr.get(j);
                j++;
            }
            if(sum==K)  length=Math.max(length,i-j+1);

            i++;
            if(i<arr.size())
                sum+=arr.get(i);
        }

        return length;
    }
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int n=sc.nextInt();
            ArrayList<Integer> arr=new ArrayList<>();
            int K=sc.nextInt();
            for(int i=0;i<n;i++)    arr.add(sc.nextInt());

            System.out.println("The length of subarray with max length is "+OptimalSubArraySum(arr,K));
        }
    }    
}
