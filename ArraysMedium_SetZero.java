import java.util.*;

public class ArraysMedium_SetZero {

    static void setRow(int [][] result,int[][] matrix,int i){
        for(int j=0;j<matrix[0].length;j++){
            result[i][j]=0;
        }
    }

    static void setColumn(int[][] result,int[][] matrix,int j){
        for(int i=0;i<matrix[0].length;i++){
            result[i][j]=0;
        }
    }

    static int[][] BruteSetZero(int[][] matrix){
        int[][] result=new int[matrix.length][matrix[0].length];

        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++)
                result[i][j]=1;
        }

        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]==0){
                    setRow(result,matrix,i);
                    setColumn(result,matrix,j);
                }
            }
        }

        return result;
    }

    static void BettersetRow(int [][] matrix,int i){
        for(int j=0;j<matrix[0].length;j++){
            if(matrix[i][j]==1)
                matrix[i][j]=-1;
        }
    }

    static void BettersetColumn(int [][] matrix,int j){
        for(int i=0;i<matrix.length;i++){
            if(matrix[i][j]==1)
                matrix[i][j]=-1;
        }
    }

    static void BetterSetZero(int[][] matrix){
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]==0){
                    BettersetRow(matrix,i);
                    BettersetColumn(matrix,j);
                }
            }
        }


        for(int i=0;i<matrix.length;i++)
            for(int j=0;j<matrix[0].length;j++)
                if(matrix[i][j]==-1)
                    matrix[i][j]=0;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int m=sc.nextInt();
        int n=sc.nextInt();

        int[][] matrix=new int[m][n];

        for(int i=0;i<m;i++)
            for(int j=0;j<n;j++)
                matrix[i][j]=sc.nextInt();

        for(int[] var: matrix){
            for(int k: var)
                System.out.print(" "+k);
            System.out.println();
       }
        
        BetterSetZero(matrix);
        System.out.println();
        for(int[] var: matrix){
            for(int k: var)
                System.out.print(" "+k);
            System.out.println();
        }
    }
}
