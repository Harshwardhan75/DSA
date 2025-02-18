import java.util.*;

public class StackQueue_NextGreater2 {

    static int[] BruteNextgreater2(int[] arr){
        int n=arr.length;
        int[] result=new int[n];
        for(int i=0;i<n;i++){
            result[i]=-1;
            for(int j=i+1;j<i+n;j++){
                if(arr[j%n]>arr[i]){
                    result[i]=arr[j%n];
                    break;
                }
            }
        }
        return result;
    }

    static int[] OptimalNextgreater2(int[] arr){
        int n=arr.length;
        int[] result=new int[n];
        Stack<Integer> st=new Stack<>();
        for(int i=2*n-1;i>=0;i--){
            while(!st.isEmpty() && st.peek()<=arr[i%n])
                st.pop();
            
            if(i<n)
                result[i]=st.isEmpty()?-1:st.peek();
            
            st.push(arr[i%n]);
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];

        for(int i=0;i<n;i++)
            arr[i]=sc.nextInt();
        
        int[] result=OptimalNextgreater2(arr);
        for(int i: result)
            System.out.print(i+" ");
    }
}
