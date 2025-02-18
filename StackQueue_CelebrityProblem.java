import java.util.Scanner;

public class StackQueue_CelebrityProblem {

    static int BrutefindCelebrity(int[][] matrix){
        int n=matrix.length;
        int[] iknow=new int[n];
        int[] knowme=new int[n];

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]==1){
                    iknow[i]++;
                    knowme[j]++;
                }
            }
        }

        for(int i=0;i<n;i++)
            if(iknow[i]==0 && knowme[i]==n-1)
                return i;

        return -1;
    }

    static int OptimalCelebrity(int[][] matrix){
        int n=matrix.length;
        int top=0,bottom=n-1;
        while(top<bottom){
            if(matrix[top][bottom]==1)
                top++;
            else
                bottom--;
        }

        for(int i=0;i<n;i++){
            if(i!=top && (matrix[top][i]==1 || matrix[i][top]==0))
                return -1;
        }

        return top;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] matrix=new int[n][n];

        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++)
                matrix[i][j]=sc.nextInt();
            
        System.out.println(OptimalCelebrity(matrix));
    }
}
