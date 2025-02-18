import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class BitManipulation_SingleNumber2 {

    static int BetterSingleNumber2(int[] nums){
        int ans=0;
        for(int i=0;i<32;i++){
            int count=0;
            for(int j=0;j<nums.length;j++){
                if((nums[j] & (1<<i))!=0)
                    count++;
            }
            if(count%3==1)
                ans=ans|(1<<i);
        }
        return ans;
    }

    static int Optimal1SingleNumber2(int[] nums){
        Arrays.sort(nums);
        for(int i=1;i<nums.length;i+=3){
            if(nums[i-1]!=nums[i])
                return nums[i-1];
        }
        return nums[nums.length-1];
    }

    static int Optimal2SingleNumber2(int[] nums){
        int ones=0,twos=0;
        for(int i=0;i<nums.length;i++){
            ones=(ones^nums[i])&~twos;
            twos=(twos^nums[i])&~ones;
        }
        return ones;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++) arr[i]=sc.nextInt();

        System.out.println(BetterSingleNumber2(arr));
        System.out.println(Optimal1SingleNumber2(arr));
        System.out.println(Optimal2SingleNumber2(arr));
    }
}
