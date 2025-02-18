import java.util.ArrayList;
import java.util.Scanner;

public class Recursion_Subsequence {

    static void Subsequence(int n,ArrayList<Integer> newarr,int arr[]){
        if(n>=arr.length){
            if(newarr.size()==0)
                System.out.print("{}");
            for(int i=0;i<newarr.size();i++)
                System.out.printf("%d ",newarr.get(i));
            System.out.println();
            return;
        }

        newarr.add(arr[n]);
        Subsequence(n+1, newarr, arr);

        newarr.remove(newarr.indexOf(arr[n]));
        Subsequence(n+1, newarr, arr);
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++)
            arr[i]=sc.nextInt();
        
            ArrayList<Integer> newarr=new ArrayList<>();
        Subsequence(0,newarr,arr);
    }
}
