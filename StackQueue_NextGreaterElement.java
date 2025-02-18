import java.util.*;

public class StackQueue_NextGreaterElement {

    static int[] BruteNextgreater(int[] arr){
        int n=arr.length;
        int[] result=new int[n];
        for(int i=0;i<n;i++){
            result[i]=-1;
            for(int j=i+1;j<n;j++){
                if(arr[j]>arr[i]){
                    result[i]=arr[j];
                    break;
                }
            }
        }

        return result;
    }

    static int[] OptimalNextgreater(int[] arr){
        int n=arr.length;
        Stack<Integer> st=new Stack<>();
        int[] result=new int[n];
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && st.peek()<=arr[i])
                st.pop();
            result[i]=st.isEmpty()?-1:st.peek();
            st.push(arr[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];

        for(int i=0;i<n;i++)
            arr[i]=sc.nextInt();
        
        int[] result=OptimalNextgreater(arr);
        for(int i: result)
            System.out.print(i+" ");
    }
}
