import java.util.*;

public class StackQueue_NextSmallerElement {

    static int[] BruteNextSmaller(int [] arr){
        int n=arr.length;
        int[] result=new int[n];
        
        for(int i=0;i<n;i++){
            result[i]=-1;
            for(int j=i-1;j>=0;j--){
                if(arr[j]<arr[i]){
                    result[i]=arr[j];
                    break;
                }
            }
        }
        return result;
    }
    static int[] OptimalNextSmaller(int[] arr){
        int n=arr.length;
        int[] result=new int[n];
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && st.peek()>=arr[i])
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
        
        int[] result=OptimalNextSmaller(arr);
        for(int i: result)
            System.out.print(i+" ");
    }
}
