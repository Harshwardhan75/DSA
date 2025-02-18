import java.util.*;
public class Recursion_SubSetSum1 {

    static ArrayList<Integer> SubSetSum(int[] nums){
        ArrayList<Integer> result=new ArrayList<>();
        subset(result,nums,0,0);
        Collections.sort(result);
        return result;
    }

    static void subset(ArrayList<Integer> result,int[] nums,int sum,int index){
        if(index==nums.length){
            result.add(sum);
            return;
        }

    subset(result, nums, sum+nums[index], index+1);
    subset(result, nums, sum, index+1);
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] nums=new int[n];
        for(int i=0;i<n;i++)    nums[i]=sc.nextInt();

        System.out.println(SubSetSum(nums));
    }
}