import java.util.ArrayList;
import java.util.Scanner;

public class Recursion_1Subsequence {

    static boolean Subsequence_1(int index,int s,int sum,ArrayList<Integer> newarr,int arr[]){
        if(index==arr.length){
            if(s==sum){
                System.out.println(newarr);
                return true;
            }
            return false;
        }

        newarr.add(arr[index]);
        s+=arr[index];
        if(Subsequence_1(index+1, s, sum, newarr, arr))
            return true;
        
        newarr.remove(newarr.indexOf(arr[index]));
        s-=arr[index];
        if(Subsequence_1(index+1, s, sum, newarr, arr))
            return true;
        
        return false;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];
        int sum=sc.nextInt();
        for(int i=0;i<n;i++)    arr[i]=sc.nextInt();
        ArrayList<Integer> newarr=new ArrayList<Integer>();
        boolean b=Subsequence_1(0,0,sum,newarr,arr);
    }
}
