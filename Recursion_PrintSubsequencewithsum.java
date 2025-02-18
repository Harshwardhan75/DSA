import java.util.*;

public class Recursion_PrintSubsequencewithsum {

    static void printsubsequencesum(int[] arr,int sum){
        ArrayList<Integer> ds=new ArrayList<>();
        print(arr,ds,0,0,sum);
    }

    static void print(int[] arr,ArrayList<Integer> ds,int ind,int s,int sum){
        if(ind==arr.length){
            if(sum==s)
                System.out.println(ds);
            return;
        }

        ds.add(arr[ind]);
        print(arr, ds, ind+1, s+arr[ind], sum);

        ds.remove(ds.size()-1);
        print(arr, ds, ind+1, s, sum);
    }


    static void print1subsequencewithsumk(int[] nums,int sum){
        ArrayList<Integer> arr=new ArrayList<>();
        printone(arr,nums,0,0,sum);
    }

    static boolean printone(ArrayList<Integer> arr,int[] nums,int ind,int s,int sum){
        if(ind==nums.length){
            if(sum==s){
                System.out.println(arr);
                return true;
            }
            return false;
        }

        arr.add(nums[ind]);
        boolean status=printone(arr, nums, ind+1, s+nums[ind], sum);
        if(!status){
            arr.remove(arr.size()-1);
            return printone(arr, nums, ind+1, s, sum);
        }
        return status;
    }

    static int CountSubsequenceswithsum(int[] arr,int sum){
        return countsub(arr,0,0,sum);
    }

    static int countsub(int arr[],int ind,int s,int sum){
        if(ind==arr.length){
            if(s==sum)
                return 1;
            else
                return 0;
        }

        int count=0;
        count+=countsub(arr,ind+1,s+arr[ind],sum);
        count+=countsub(arr,ind+1,s,sum);
        return count;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int sum=sc.nextInt();
        int[] arr=new int[n];

        for(int i=0;i<n;i++)    arr[i]=sc.nextInt();

        System.out.println(CountSubsequenceswithsum(arr,sum));

    }
}