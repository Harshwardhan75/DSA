import java.util.*;
public class Recursion_CombinationSum1 {

    static ArrayList<ArrayList<Integer>> CombinationSum(int[] nums,int target){
        int sum=0;
        int ind=0;
        ArrayList<ArrayList<Integer>> result=new ArrayList<>();
        ArrayList<Integer> arr=new ArrayList<>();
        OptimalCombination_Sum(result,arr,nums,sum,target,ind);
        return result;
    }

    static void Combination_Sum(ArrayList<ArrayList<Integer>> result,ArrayList<Integer> arr,int[] nums,int sum,int target,int ind){
        if(ind==nums.length){
            if(sum==target)
                result.add(new ArrayList<>(arr));
            return;
        }

        if(sum>target)  return;

        arr.add(nums[ind]);
        Combination_Sum(result, arr, nums, sum+nums[ind], target, ind);
        arr.remove(arr.size()-1);
        Combination_Sum(result, arr, nums, sum, target, ind+1);
        
    }

    static void OptimalCombination_Sum(ArrayList<ArrayList<Integer>> result,ArrayList<Integer> arr,int[] nums,int sum,int target,int ind){
        if(ind==nums.length || sum>target)
            return;
        
        if(sum==target){
            result.add(new ArrayList<>(arr));
            return;
        }
        
        arr.add(nums[ind]);
        Combination_Sum(result, arr, nums, sum+nums[ind], target, ind);
        arr.remove(arr.size()-1);
        Combination_Sum(result, arr, nums, sum, target, ind+1);
        
    }


    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int target=sc.nextInt();
        int[] arr=new int[n];

        for(int i=0;i<n;i++)    arr[i]=sc.nextInt();

        System.out.println(CombinationSum(arr,target));

    }
}