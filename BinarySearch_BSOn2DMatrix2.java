import java.util.Scanner;

public class BinarySearch_BSOn2DMatrix2 {

    static int[] BruteFind(int[][] matrix,int target){
        int n=matrix.length,m=matrix[0].length;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++)
                if(matrix[i][j]==target)
                    return new int[]{i,j};
        }

        return new int[]{-1,-1};
    }

    static int BinarySearch(int[] arr,int target){
        int low=0,high=arr.length-1;
        while(low<=high){
            int mid=(low+high)/2;
            if(arr[mid]==target)
                return mid;
            else if(arr[mid]<target)
                low=mid+1;
            else
                high=mid-1;
        }
        return -1;
    }

    static int[] BetterFind(int[][] matrix,int target){
        int n=matrix.length,m=matrix[0].length;

        for(int i=0;i<n;i++){
            int ind=BinarySearch(matrix[i],target);
            if(ind!=-1)
                return new int[]{i,ind};
        }

        return new int[]{-1,-1};
    }

    static int[] OptimalFind(int[][] matrix,int target){
        int n=matrix.length,m=matrix[0].length;
        int row=0,col=m-1;

        while(row<n && col>=0){
            if(matrix[row][col]==target)
                return new int[]{row,col};
            else if(matrix[row][col]<target)
                row++;
            else
                col--;
        }

        return new int[]{-1,-1};
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

        int[] arr=OptimalFind(matrix,target);
        System.out.println(arr[0]+" "+arr[1]);
    }    
}
