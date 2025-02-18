import java.util.Scanner;
import java.util.Stack;

public class StackQueue_SumOfSubarrayMaximum {

    static long BruteSubarrayMaximum(int[] arr){
        long sum=0;
        int n=arr.length;
        for(int i=0;i<n;i++){
            int max=arr[i];
            for(int j=i;j<n;j++){
                max=Math.max(max, arr[j]);
                sum+=(long)max;
            }
        }
        return sum;
    }

    static int[] findnge(int[] arr){
        Stack<Integer> st=new Stack<>();
        int n=arr.length;
        int[] result=new int[n];
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && arr[st.peek()]<=arr[i])
                st.pop();
            
            result[i]=st.isEmpty()?n:st.peek();
            st.push(i);
        }
        return result;
    }

    static int[] findpge(int[] arr){
        int n=arr.length;
        int[] result=new int[n];
        Stack<Integer> st=new Stack<>();

        for(int i=0;i<n;i++){
            while(!st.isEmpty() && arr[st.peek()]<arr[i])
                st.pop();
            
            result[i]=st.isEmpty()?-1:st.peek();
            st.push(i);
        }
        return result;
    }

    static long OptimalSubarrayMaximum(int[] arr){
        long sum=0;
        int[] nge=findnge(arr);
        int[] pge=findpge(arr);

        int n=arr.length;
        for(int i=0;i<n;i++){
            int left=i-pge[i];
            int right=nge[i]-i;

            sum+=(left*right*arr[i]);
        }
        return sum;
    }
    
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];

        for(int i=0;i<n;i++)    arr[i]=sc.nextInt();

        System.out.println(BruteSubarrayMaximum(arr));
        System.out.println(OptimalSubarrayMaximum(arr));
    }
}
