import java.util.*;

public class ArraysMedium_SpiralTraversalOfMatrix {

    static ArrayList<Integer> SpiralTraversal(int[][] matrix){
        int top=0,left=0,right=matrix[0].length-1,bottom=matrix.length-1;
        
        ArrayList<Integer> result=new ArrayList<>();
        while(left<=right && top<=bottom){
            for(int i=left;i<=right;i++)    
                result.add(matrix[top][i]);
            top++;

            for(int i=top;i<=bottom;i++)    
                result.add(matrix[i][right]);
            right--;

            if(left<=right){
                for(int i=right;i>=left;i--)    
                    result.add(matrix[bottom][i]);
                bottom--;
            }

            if(top<=bottom){
                for(int i=bottom;i>=top;i--)    
                    result.add(matrix[i][left]);
                left++;
            }
        }

        return result;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int m=sc.nextInt();
        int n=sc.nextInt();

        int [][] matrix=new int[m][n];

        for(int i=0;i<m;i++)
            for(int j=0;j<n;j++)
                matrix[i][j]=sc.nextInt();
            
        ArrayList<Integer> result=SpiralTraversal(matrix);

        System.out.println(result);
    }
}
