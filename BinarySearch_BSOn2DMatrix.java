import java.util.Scanner;

public class BinarySearch_BSOn2DMatrix {

    static boolean BruteFind(int[][] matrix,int target){
        int n=matrix.length,m=matrix[0].length;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++)
                if(matrix[i][j]==target)
                    return true;
        }

        return false;
    }

    static boolean BinarySearch(int[] arr,int target){
        int low=0,high=arr.length-1;
        while(low<=high){
            int mid=(low+high)/2;
            if(arr[mid]==target)
                return true;
            else if(arr[mid]<target)
                low=mid+1;
            else
                high=mid-1;
        }
        return false;
    }

    static boolean BetterFind(int[][] matrix,int target){
        int n=matrix.length,m=matrix[0].length;

        for(int i=0;i<n;i++){
            if(matrix[i][0]<=target && target<=matrix[i][m-1])
                return BinarySearch(matrix[i],target);
        }
        return false;
    }

    static boolean OptimalFind(int[][] matrix,int target){
        int n=matrix.length,m=matrix[0].length;
        int low=0,high=n*m-1;

        while(low<=high){
            int mid=(low+high)/2;
            int row=mid/m;
            int col=mid%m;

            if(matrix[row][col]==target)
                return true;
            else if(matrix[row][col]<target)
                low=mid+1;
            else
                high=mid-1;
        }

        return false;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int target=sc.nextInt();
        int[][] matrix=new int[n][m];
        for(int i=0;i<n;i++)
            for(int j=0;j<m;j++)
                matrix[i][j]=sc.nextInt();

        
        System.out.println(OptimalFind(matrix,target));
    }    
}