import java.util.Scanner;
import java.util.Stack;

public class StackQueue_SumOfSubarrayMinimum {

    static int BruteSumofMinOfSum(int[] arr){
        int sum=0;
        int n=arr.length;
        int mod=(int)(1e9+7);
        for(int i=0;i<n;i++){
            int min=arr[i];
            for(int j=i;j<n;j++){
                min=Math.min(min, arr[j]);
                sum+=min;
            }
        }
        return sum;
    }

    static int[] findnse(int[]arr){
        int[] nse=new int[arr.length];
        Stack<Integer> st=new Stack<>();
        for(int i=arr.length-1;i>=0;i--){
            while(!st.isEmpty() && arr[st.peek()]>=arr[i])
                st.pop();
            nse[i]=st.isEmpty()?arr.length:st.peek();
            st.push(i);
        }
        return nse;
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

    static int OptimalSumofMinOfSum(int[] arr){
        int[] nse=findnse(arr);
        int[] pse=findpse(arr);
        int sum=0;
        int n=arr.length;
        for(int i=0;i<n;i++){
            int left=i-pse[i];
            int right=nse[i]-i;
            sum+=(left*right*arr[i]);
        }

        return sum;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();

        int[] arr=new int[n];
        for(int i=0;i<n;i++)
            arr[i]=sc.nextInt();
        
        System.out.println(OptimalSumofMinOfSum(arr));
    }
}
