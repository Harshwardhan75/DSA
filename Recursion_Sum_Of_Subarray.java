import java.util.*;

public class Recursion_Sum_Of_Subarray {

    static void SumOfSubarray(int index,ArrayList<Integer> newarr,int arr[],int sum,int s){
        if(index==arr.length){
            if(s==sum)
                System.out.println(newarr);
            return;
        }

        newarr.add(arr[index]);
        s+=arr[index];
        SumOfSubarray(index+1, newarr, arr, sum, s);

        newarr.remove(newarr.indexOf(arr[index]));
        s-=arr[index];
        SumOfSubarray(index+1, newarr, arr, sum, s);
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int sum=sc.nextInt();
        int[] arr=new int[n];

        for(int i=0;i<n;i++)
            arr[i]=sc.nextInt();

        ArrayList<Integer> newarr=new ArrayList<>();
        SumOfSubarray(0,newarr,arr,sum,0);
    }
}
