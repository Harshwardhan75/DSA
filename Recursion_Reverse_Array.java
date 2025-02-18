import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class Recursion_Reverse_Array {

    static void PrintArray(int arr[]){
        for(int i=0;i<arr.length;i++)
            System.out.printf("%d ",arr[i]);
    }

    static void ReverseArray(int arr[],int i,int n){
        if(i>=n-i)  return;

        int temp=arr[i];
        arr[i]=arr[n-i-1];
        arr[n-i-1]=temp;
        ReverseArray(arr, i+1, n);
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int []arr=new int[n];
        for(int i=0;i<n;i++)
            arr[i]=sc.nextInt();
        PrintArray(arr);
        System.out.println();
        ReverseArray(arr,0,n);

        PrintArray(arr);
    }
}
