import java.util.*;

public class StackQueue_LargestRectangleinHistogram {

    static int[] findpse(int [] arr){
        Stack<Integer> st=new Stack<>();
        int n=arr.length;
        int[] pse=new int[n];

        for(int i=0;i<n;i++){
            while(!st.isEmpty() && arr[st.peek()]>=arr[i])
                st.pop();
            pse[i]=st.isEmpty()?-1:st.peek();
            st.push(i);
        }
        return pse;
    }

    static int[] findnse(int[] arr){
        Stack<Integer> st=new Stack<>();
        int n=arr.length;
        int[] nse=new int[n];

        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && arr[st.peek()]>=arr[i])
                st.pop();
            
            nse[i]=st.isEmpty()?n:st.peek();
            st.push(i);
        }

        return nse;
    }

    static int Brutelargestrectangle(int[] arr){
        int[] pse=findpse(arr);
        int[] nse=findnse(arr);
        int n=arr.length;

        int max=0;

        for(int i=0;i<n;i++){
            int left=pse[i];
            int right=nse[i];
            max=Integer.max(max,arr[i]*(right-left-1));
        }

        return max;
    }

    static int Optimallargestrectangle(int[] arr){
        Stack<Integer> st=new Stack<>();
        int n=arr.length;
        int max=0;

        for(int i=0;i<n;i++){
            while(!st.isEmpty() && arr[st.peek()]>=arr[i]){
                int e=st.pop();
                int nse=i;
                int pse=st.isEmpty()?-1:st.peek();
                max=Integer.max(max, arr[e]*(nse-pse-1));
            }
            st.push(i);
        }

        while(!st.isEmpty()){
            int e=st.pop();
            int nse=n;
            int pse=st.isEmpty()?-1:st.peek();
            max=Integer.max(max, arr[e]*(nse-pse-1));
        }

        return max;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];

        for(int i=0;i<n;i++)
            arr[i]=sc.nextInt();
        
        System.out.println(Brutelargestrectangle(arr));
        System.out.println(Optimallargestrectangle(arr));
    }
}
