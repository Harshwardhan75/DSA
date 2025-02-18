import java.util.*;

public class ArraysMedium_RotaeMatrix90 {

    static int[][] BruteRotate(int[][] matrix){
        int n=matrix.length;
        int[][] result=new int[n][n];

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                result[j][n-1-i]=matrix[i][j];
            }
        }

        return result;
    }


    static void swap(int[][] matrix,int i,int j){
        int temp=matrix[i][j];
        matrix[i][j]=matrix[j][i];
        matrix[j][i]=temp;
    }

    static void Transpose(int[][] matrix){
        int n=matrix.length;

        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                swap(matrix,i,j);
            }
        }
    }

    static void swap(int[][] matrix,int i,int start,int end){
        int temp=matrix[i][start];
        matrix[i][start]=matrix[i][end];
        matrix[i][end]=temp;
    }
    static void reverse(int[][] matrix,int i){
        int start=0,end=matrix.length-1;
        while(start<end){
            swap(matrix,i,start,end);
            start++;
            end--;
        }
    }

    static void OptimalRotate(int[][] matrix){
        Transpose(matrix);
        for(int i=0;i<matrix.length;i++){
            reverse(matrix,i);
        }
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        
        int[][] matrix=new int[n][n];

        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++)
                matrix[i][j]=sc.nextInt();
            
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++)
                System.out.print(matrix[i][j]+" ");
            System.out.println();
        }
        
        OptimalRotate(matrix);
        System.out.println();

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++)
                System.out.print(matrix[i][j]+" ");
            System.out.println();
        }
    }
}
