import java.util.*;

public class BitManipulation_PowerSet {

    static ArrayList<ArrayList<Integer>> PowerSet(int[] nums){
        ArrayList<ArrayList<Integer>> result=new ArrayList<>();
        
        for(int i=0;i<(1<<nums.length);i++){
            ArrayList<Integer> arr=new ArrayList<>();
            for(int j=0;j<nums.length;j++){
                if((i&(1<<j))!=0)
                    arr.add(nums[j]);
            }
            result.add(arr);
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++)    arr[i]=sc.nextInt();
        System.out.println(PowerSet(arr));
    }
}