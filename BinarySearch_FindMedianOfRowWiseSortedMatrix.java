import java.util.*;

public class BinarySearch_FindMedianOfRowWiseSortedMatrix {

    static double BruteFindMedian(int[][] matrix,int n,int m){
        ArrayList<Integer> arr=new ArrayList<>();

        for(int i=0;i<n;i++)
            for(int j=0;j<m;j++)
                arr.add(matrix[i][j]);
            
        Collections.sort(arr);

        if(arr.size()%2==1)
            return (double)arr.get(arr.size()/2);
        else
            return (double)(arr.get(arr.size()/2-1)+arr.get(arr.size()/2))/2.0;
    }

    static int upperbound(int[] arr,int x){
        int low=0,high=arr.length-1;

        while(low<=high){
            int mid=(low+high)/2;
            if(arr[mid]>x)
                high=mid-1;
            else    
                low=mid+1;
        }

        return low;
    }

    static int calculate(int[][] arr,int n,int x){
        int count=0;
        for(int i=0;i<n;i++){
            count+=upperbound(arr[i],x);
        }
        return count;
    }

    static double OptimalFindMedian(int[][] matrix,int n,int m){
        int required=(n*m)/2;
        int low=Integer.MAX_VALUE;
        int high=Integer.MIN_VALUE;

        for(int i=0;i<n;i++){
            low=Math.min(low, matrix[i][0]);
            high=Math.max(high, matrix[i][m-1]);               
        }

        while(low<=high){
            int mid=(low+high)/2;
            int smallerequal=calculate(matrix,n,mid);

            if(smallerequal>required)
                high=mid-1;
            else
                low=mid+1;
        }

        return low;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] matrix = new int[n][m];

        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                matrix[i][j] = sc.nextInt();

        System.out.println(OptimalFindMedian(matrix, n, m));
    }
}
