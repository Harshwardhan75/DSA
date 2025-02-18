import java.util.*;

public class Graph_ShortestPathFloydWarshalAlgorithm {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        
        int[][] matrix=new int[n][n];
        for(int[] i: matrix)    Arrays.fill(i, -1);
        int e=sc.nextInt();
        for(int i=0;i<e;i++){
            int u=sc.nextInt();
            int v=sc.nextInt();
            int wt=sc.nextInt();
            matrix[u][v]=wt;
        }

        FloydWarshal(matrix);

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }

    static void FloydWarshal(int[][] matrix){
        int n=matrix.length;

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]==-1)
                    matrix[i][j]=(int)1e9;
                
                if(i==j)
                    matrix[i][j]=0;
            }
        }

        for(int via=0;via<n;via++){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    matrix[i][j]=Math.min(matrix[i][j],matrix[i][via]+matrix[via][j]);
                }
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]<0)
                    System.out.println("Negative Cycle");
                if(matrix[i][j]==(int)1e9)
                    matrix[i][j]=-1;
            }
        }
    }
}
