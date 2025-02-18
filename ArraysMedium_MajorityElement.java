import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class ArraysMedium_MajorityElement {

    static int BetterMajorityElement(int nums[]){
    Map<Integer,Integer> map=new TreeMap<>();

        for(int var: nums)
            map.put(var,map.getOrDefault(var,0)+1);
        
        for(int key: map.keySet())
            if(map.get(key)> nums.length/2)
                return key;

        return -1;
    }

    static int OptimalMajorityElement(int nums[]){
        int el=0,count=0;

        for(int i=0;i<nums.length;i++){
            if(count==0){
                el=nums[i];
                count++;
            }
            else if(nums[i]==el)
                count++;
            else
                count--;
        }

        return el;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        
        int[] arr=new int[n];

        for(int i=0;i<n;i++)    arr[i]=sc.nextInt();

        System.out.println(OptimalMajorityElement(arr));
    }
}
