import java.util.*;

public class ArraysHard_FourSum {

    static ArrayList<ArrayList<Integer>> Brute4Sum(int[] nums,int target){
        Set<ArrayList<Integer>> set=new HashSet<>();
        int n=nums.length;

        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                for(int k=j+1;k<n;k++){
                    for(int l=k+1;l<n;l++){
                        int sum=nums[i]+nums[j]+nums[k]+nums[l];
                        if(sum==target){
                            ArrayList<Integer> arr=new ArrayList<>(Arrays.asList(nums[i],nums[j],nums[k],nums[l]));
                            Collections.sort(arr);
                            set.add(arr);
                        }
                    }
                }
            }
        }

        ArrayList<ArrayList<Integer>> result=new ArrayList<>(set);
        return result;
    }

    static ArrayList<ArrayList<Integer>> Better4Sum(int[] nums,int target){
        Set<ArrayList<Integer>> set=new HashSet<>();
        int n=nums.length;
        Set<Integer> s=new HashSet<>();

        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                for(int k=j+1;k<n;k++){
                    int find=target-(nums[i]+nums[j]+nums[k]);
                    if(s.contains(find)){
                        ArrayList<Integer> arr=new ArrayList<>(Arrays.asList(nums[i],nums[j],nums[k],find));
                        Collections.sort(arr);
                        set.add(arr);
                    }
                    s.add(nums[k]);
                }

                s.clear();
            }
        }

        ArrayList<ArrayList<Integer>> result=new ArrayList<>(set);

        return result;
    }

    static ArrayList<ArrayList<Integer>> Optimal4Sum(int[] nums,int target){
        int n=nums.length;
        Arrays.sort(nums);
        ArrayList<ArrayList<Integer>> result=new ArrayList<>();

        for(int i=0;i<n;i++){
            if(i>0 && nums[i]==nums[i-1])   continue;
            for(int j=i+1;j<n;j++){
                if(j>i+1 && nums[j]==nums[j-1])    continue;
                int k=j+1,l=n-1;

                while(k<l){
                    long sum=nums[i]+nums[j];
                    sum+=nums[k];
                    sum+=nums[l];

                    if(sum==target){
                        ArrayList<Integer> arr=new ArrayList<>(Arrays.asList(nums[i],nums[j],nums[k],nums[l]));
                        result.add(arr);
                        k++;
                        l--;

                        while(k<l && nums[k]==nums[k-1])    k++;
                        while(k<l && nums[l]==nums[l+1])    l--;
                    }
                    else if(sum<target) k++;
                    else l--;
                }
            }
        }

        return result;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] nums=new int[n];
        for(int i=0;i<n;i++)    nums[i]=sc.nextInt();
        int target=sc.nextInt();
        ArrayList<ArrayList<Integer>> result=Optimal4Sum(nums,target);

        System.out.println(result);
    }   
}