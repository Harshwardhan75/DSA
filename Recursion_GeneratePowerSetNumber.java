import java.util.*;

public class Recursion_GeneratePowerSetNumber {
    
    static ArrayList<ArrayList<Integer>> IterativePowerSet(int[] nums){
        int n=nums.length;
        ArrayList<ArrayList<Integer>> result=new ArrayList<>();
        for(int i=0;i<(1<<n);i++){
            ArrayList<Integer> arr=new ArrayList<>();
            for(int j=0;j<n;j++){
                if((i & (1<<j)) !=0)
                    arr.add(nums[j]);
            }
            result.add(arr);
        }
        return result;
    }

    static void generatePowerSet(int[] nums,ArrayList<ArrayList<Integer>> result,ArrayList<Integer> arr,int selected){
        if(selected==nums.length){
            result.add(new ArrayList<>(arr));
            return;
        }

        arr.add(nums[selected]);
        generatePowerSet(nums, result, arr, selected+1);
        arr.remove(arr.size()-1);
        generatePowerSet(nums, result, arr, selected+1);
    }

    static ArrayList<ArrayList<Integer>> RecursivePowerSet(int[] nums){
        ArrayList<ArrayList<Integer>> result=new ArrayList<>();
        ArrayList<Integer> arr=new ArrayList<>();
        generatePowerSet(nums,result,arr,0);
        return result;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++)    arr[i]=sc.nextInt();
        System.out.println(RecursivePowerSet(arr));
    }
}
