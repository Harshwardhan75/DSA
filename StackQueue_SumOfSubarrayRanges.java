import java.util.Scanner;
import java.util.Stack;

public class StackQueue_SumOfSubarrayRanges {

    static int BruteSumSubarray(int[] arr){
        int sum=0;
        int n=arr.length;
        for(int i=0;i<n;i++){
            int min=Integer.MAX_VALUE;
            int max=Integer.MIN_VALUE;
            for(int j=i;j<n;j++){
                min=Math.min(min, arr[j]);
                max=Math.max(max, arr[j]);
                sum+=(max-min);
            }
        }

        return sum;
    }

    static int OptimalSumSubarray(int[] arr){
        return maximumsum(arr)-minimumsum(arr);
    }

    static int maximumsum(int[] arr){
        int[] pge=findpge(arr);
        int[] nge=findnge(arr);
        
        int sum=0;
        int n=arr.length;

        for(int i=0;i<n;i++){
            int left = i-pge[i];
            int right=nge[i]-i;

            sum+=(left*right*arr[i]);
        }

        return sum;
    }

    static int[] findpge(int[] arr){
        int n=arr.length;
        int[] pge=new int[n];
        Stack<Integer> st=new Stack<>();

        for(int i=0;i<n;i++){
            while(!st.isEmpty() && arr[st.peek()]<arr[i])
                st.pop();
            pge[i]=st.isEmpty()?-1:st.peek();
            st.push(i);
        }

        return pge;
    }

    static int[] findnge(int[] arr){
        int n=arr.length;
        int[] nge=new int[n];
        Stack<Integer> st=new Stack<>();
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && arr[st.peek()]<=arr[i])
                st.pop();
            nge[i]=st.isEmpty()?n:st.peek();
            st.push(i);
        }

        return nge;
    }

    static int minimumsum(int [] arr){
        int n=arr.length;
        int[] pse=findpse(arr);
        int[] nse=findnse(arr);
        int sum=0;
        for(int i=0;i<n;i++){
            int left=i-pse[i];
            int right=nse[i]-i;

            sum+=(left*right*arr[i]);
        }
        return sum;
    }

    static int[] findpse(int[] arr){
        int n=arr.length;
        int[] pse=new int[n];
        Stack<Integer> st=new Stack<>();

        for(int i=0;i<n;i++){
            while(!st.isEmpty() && arr[st.peek()]>arr[i])
                st.pop();
            
            pse[i]=st.isEmpty()?-1:st.peek();
            st.push(i);
        }
        return pse;
    }

    static int[] findnse(int[] arr){
        int n=arr.length;
        int[] nse=new int[n];
        Stack<Integer> st=new Stack<>();

        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && arr[st.peek()]>=arr[i])
                st.pop();
            
            nse[i]=st.isEmpty()?n:st.peek();
            st.push(i);
        }
        return nse;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];

        for(int i=0;i<n;i++)
            arr[i]=sc.nextInt();

        System.out.println(BruteSumSubarray(arr));
        System.out.println(OptimalSumSubarray(arr));
    }
}
