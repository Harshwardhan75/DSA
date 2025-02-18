import java.util.*;

public class StackQueue_MaximalRectangle {
    
    static int histogram(int[] arr){
        Stack<Integer> st=new Stack<>();
        int n=arr.length;
        int max=0;

        for(int i=0;i<n;i++){
            while(!st.isEmpty() && arr[st.peek()]>=arr[i]){
                int e=st.pop();
                int nse=i;
                int pse=st.isEmpty()?-1:st.peek();
                max=Math.max(max, arr[e]*(nse-pse-1));
            }
            st.push(i);
        }

        while(!st.isEmpty()){
            int e=st.pop();
            int nse=n;
            int pse=st.isEmpty()?-1:st.peek();
            max=Math.max(max, arr[e]*(nse-pse-1));
        }

        return max;
    }

    static int MaximalRectangle1(int[][] arr){
        int n=arr.length;
        int m=arr[0].length;

        int[][] psum=new int[n][m];

        for(int i=0;i<m;i++){
            int sum=0;
            for(int j=0;j<n;j++){
                sum+=arr[j][i];
                if(arr[j][i]==0)
                    sum=0;
                psum[j][i]=sum;
            }
        }

        int maxArea=0;

        for(int i=0;i<n;i++){
            maxArea=Math.max(maxArea, histogram(psum[i]));
        }

        return maxArea;
    }

    static int MaximalRectangle2(int[][] arr){
        int n=arr.length;
        int m=arr[0].length;
        int[] row=new int[m];
        int maxArea=0;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(arr[i][j]==1)
                    row[j]+=1;
                else    
                    row[j]=0;
            }
            maxArea=Math.max(maxArea, histogram(row));
        }

        return maxArea;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int[][] arr=new int[n][m];

        for(int i=0;i<n;i++)
            for(int j=0;j<m;j++)
                arr[i][j]=sc.nextInt();
            
        System.out.println(MaximalRectangle1(arr));
        System.out.println(MaximalRectangle2(arr));
    }

}
