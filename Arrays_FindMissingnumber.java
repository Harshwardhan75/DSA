import java.util.Scanner;

public class Arrays_FindMissingnumber {
    static int missingNumber(int[] nums) {
        /*
        BruteForce-Optimal
        Arrays.sort(nums);
        int i=0;
        for(i=0;i<nums.length;i++){
            if(nums[i]!=i) return i;
        }
        return i;
        */

        /*
        Better
        ArrayList<Integer> arr=new ArrayList<>(Collections.nCopies(nums.length+1,0));
        for(int i=0;i<nums.length;i++)  arr.set(nums[i],1);
        int i=0;
        for(i=0;i<arr.size();i++)
            if(arr.get(i)!=1)   return i;
        return i;
        */

        /*
        Optimal Summation
        int sum=(nums.length*(nums.length+1)/2);
        for(int var: nums)
            sum-=var;
        return sum;
        */

        
        //Optiomal Xor
        int xor=0;
        for(int i=0;i<nums.length;i++)
            xor^=nums[i]^i;  
        xor^=nums.length;
        return xor;  
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++)    arr[i]=sc.nextInt();
        System.out.println("The Missing Number is "+missingNumber(arr));
    }
}
