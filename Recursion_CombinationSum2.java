import java.util.*;

public class Recursion_CombinationSum2 {

    static ArrayList<ArrayList<Integer>> BruteCombinationSum2(int[] nums,int target){
        Arrays.sort(nums);
        Set<ArrayList<Integer>> set=new HashSet<>();
        ArrayList<Integer> arr=new ArrayList<>();
        BruteCombination_Sum(set,arr,nums,0,target,0);
        ArrayList<ArrayList<Integer>> result=new ArrayList<>(set);
        return result;
    }

    static void BruteCombination_Sum(Set<ArrayList<Integer>> set,ArrayList<Integer> arr,int[] nums,int sum,int target,int ind){
        if(sum==target){
            set.add(new ArrayList<>(arr));
            return;
        }
        if(ind==nums.length || sum>target)  return;


        arr.add(nums[ind]);
        BruteCombination_Sum(set, arr, nums, sum+nums[ind], target, ind+1);
        arr.remove(arr.size()-1);
        BruteCombination_Sum(set, arr, nums, sum, target, ind+1);
    }

    static ArrayList<ArrayList<Integer>> OptimalCombinationSum2(int[] nums,int target){
        Arrays.sort(nums);
        ArrayList<ArrayList<Integer>> result=new ArrayList();
        ArrayList<Integer> arr=new ArrayList<>();
        OptimalCombination_Sum(result,arr,nums,0,target,0);
        return result;
    }

    static void OptimalCombination_Sum(ArrayList<ArrayList<Integer>> result,ArrayList<Integer> arr,int[] nums,int sum,int target,int ind){
        if(sum==target) {
            result.add(new ArrayList<>(arr));
            return;
        }

        if(sum>target)  return;

        for(int i=ind;i<nums.length;i++){
            if(i>ind && nums[i]==nums[i-1]) continue;
            
            arr.add(nums[i]);
            OptimalCombination_Sum(result, arr, nums, sum+nums[i], target, i+1);
            arr.remove(arr.size()-1);
        }
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int target=sc.nextInt();
        int[] arr=new int[n];

        for(int i=0;i<n;i++)    arr[i]=sc.nextInt();

        System.out.println(OptimalCombinationSum2(arr,target));

    }
}
