import java.util.*;

public class Recursion_countNoOfSubsequence {

    static int Count_Subsequence(int index,int s,int sum,ArrayList<Integer> newarr,int arr[]){
        if(index==arr.length){
            if(s==sum) return 1;
            else    return 0;
        }

        newarr.add(arr[index]);
        s+=arr[index];
        int left=Count_Subsequence(index+1, s, sum, newarr, 
        arr);

        newarr.remove(newarr.indexOf(arr[index]));
        s-=arr[index];
        int right=Count_Subsequence(index+1, s, sum, newarr, arr);

        return left+right;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int sum=sc.nextInt();
        int []arr=new int[n];

        for(int i=0;i<n;i++)    arr[i]=sc.nextInt();
        ArrayList<Integer> newarr=new ArrayList<>();
        System.out.println("The Number of Subsequence are "+Count_Subsequence(0,0,sum,newarr,arr));
    }
}
