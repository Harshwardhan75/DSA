import java.util.*;

public class Recursion_SubSets2 {

    static ArrayList<ArrayList<Integer>> Brutesubset(int[] nums){
        Arrays.sort(nums);
        Set<ArrayList<Integer>> set=new HashSet<>();
        ArrayList<Integer> arr=new ArrayList<>();
        BruteSubSet(set,arr,nums,0);
        ArrayList<ArrayList<Integer>> result=new ArrayList<>(set);
        return result;
    }

    static void BruteSubSet(Set<ArrayList<Integer>> set, ArrayList<Integer> arr, int[] nums, int index) {
        if(index==nums.length){
            set.add(new ArrayList<>(arr));
            return;
        }

        arr.add(nums[index]);
        BruteSubSet(set, arr, nums, index+1);
        arr.remove(arr.size()-1);
        BruteSubSet(set, arr, nums, index+1);
    }

    static ArrayList<ArrayList<Integer>> Optimalsubset(int[] nums){
        Arrays.sort(nums);
        ArrayList<ArrayList<Integer>> result=new ArrayList<>();
        ArrayList<Integer> arr=new ArrayList<>();
        OptimalSubSet(result,arr,nums,0);
        return result;
    }

    static void OptimalSubSet(ArrayList<ArrayList<Integer>> result,ArrayList<Integer> arr,int [] nums,int index){

        result.add(new ArrayList<>(arr));

        for(int i=index;i<nums.length;i++){
            if(i>index && nums[i]==nums[i-1])   continue;

            arr.add(nums[i]);
            OptimalSubSet(result, arr, nums, i+1);
            arr.remove(arr.size()-1);
        }

    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] nums=new int[n];
        for(int i=0;i<n;i++)    nums[i]=sc.nextInt();

        System.out.println(Optimalsubset(nums));
    }
}
