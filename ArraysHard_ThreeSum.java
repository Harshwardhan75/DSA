import java.util.*;

public class ArraysHard_ThreeSum {

    static ArrayList<ArrayList<Integer>> BruteThreeSum(int[] nums){
        Set<ArrayList<Integer>> set=new HashSet<>();

        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                for(int k=j+1;k<nums.length;k++){
                    if(nums[i]+nums[j]+nums[k]==0){
                        ArrayList<Integer> arr=new ArrayList<>(Arrays.asList(nums[i],nums[j],nums[k]));

                        Collections.sort(arr);

                        set.add(arr);
                    }
                }
            }
        }

        ArrayList<ArrayList<Integer>> result=new ArrayList<>(set);

        return result;
    }

    static ArrayList<ArrayList<Integer>> BetterThreeSum(int[] nums){
        Set<ArrayList<Integer>> set=new HashSet<>();

        Set<Integer> s=new HashSet<>();

        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                int x=-(nums[i]+nums[j]);
                if(s.contains(x)){
                    ArrayList<Integer> arr=new ArrayList<>(Arrays.asList(nums[i],nums[j],x));
                    Collections.sort(arr);
                    set.add(arr);
                }
                s.add(nums[j]);
            }
            s.clear();
        }
        ArrayList<ArrayList<Integer>> result=new ArrayList<>(set);
        return result;
    }

    static ArrayList<ArrayList<Integer>> OptimalThreeSum(int[] nums){
        ArrayList<ArrayList<Integer>> result=new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            if(i>0 && nums[i]==nums[i-1])   continue;
            int j=i+1,k=nums.length-1;

            while(j<k){
                if(nums[i]+nums[j]+nums[k]==0){
                    result.add(new ArrayList(Arrays.asList(nums[i],nums[j],nums[k])));
                    j++;
                    k--;
                    while(j<k && nums[k]==nums[k+1])   
                        k--;
                    while(j<k && nums[j]==nums[j-1])   
                        j++;
                }
                else if(nums[i]+nums[j]+nums[k]<0)
                    j++;
                else
                    k--;
            }
        }

        return result;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];

        for(int i=0;i<n;i++)    arr[i]=sc.nextInt();

        ArrayList<ArrayList<Integer>> result=OptimalThreeSum(arr);
        System.out.println(result);
    }
}
