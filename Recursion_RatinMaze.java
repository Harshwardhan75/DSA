import java.util.*;

public class Recursion_RatinMaze {

    static ArrayList<String> Ratinmaze1(int[][] matrix){
        int n=matrix.length;
        boolean[][] visited=new boolean[n][n];
        ArrayList<String> result=new ArrayList<>();
        if(matrix[0][0]==1)
            findPath1(0,0,"",result,matrix,visited);
        return result;
    }

    static void findPath1(int row,int col,String move,ArrayList<String> result,int[][] matrix,boolean[][] visited){
        int n=matrix.length;
        if(row==n-1 && col==n-1){
            result.add(move);
            return;
        }

        if(row<n-1 && matrix[row+1][col]==1 && !visited[row+1][col]){
            visited[row][col]=true;
            findPath1(row+1,col,move+"D",result,matrix,visited);
            visited[row][col]=false;
        }
        
        if(col>0 && matrix[row][col-1]==1 && !visited[row][col-1]){
            visited[row][col]=true;
            findPath1(row,col-1,move+"L",result,matrix,visited);
            visited[row][col]=false;
        }
        
        if(col<n-1 && matrix[row][col+1]==1 && !visited[row][col+1]){
            visited[row][col]=true;
            findPath1(row,col+1,move+"R",result,matrix,visited);
            visited[row][col]=false;
        }
        
        if(row>0 && matrix[row-1][col]==1 && !visited[row-1][col]){
            visited[row][col]=true;
            findPath1(row-1,col,move+"U",result,matrix,visited);
            visited[row][col]=false;
        }
    }


    static ArrayList<String> Ratinmaze2(int[][] matrix){
        int n=matrix.length;
        boolean[][] visited=new boolean[n][n];
        int[] di={1,0,0,-1};
        int[] dj={0,-1,1,0};
        ArrayList<String> result=new ArrayList<>();
        if(matrix[0][0]==1)
            findPath2(0,0,"",result,matrix,visited,di,dj);
        return result;
    }

    static void findPath2(int row,int col,String move,ArrayList<String> result,int[][] matrix,boolean[][] visited,int[] di,int[] dj){
        int n=matrix.length;
        if(row==n-1 && col==n-1){
            result.add(move);
            return;
        }

        String direction="DLRU";

        for(int i=0;i<4;i++){
            int nexti=row+di[i];
            int nextj=col+dj[i];

            if(nexti<n && nextj<n && nexti>=0 && nextj>=0 && matrix[nexti][nextj]==1 && !visited[nexti][nextj]){
                visited[row][col]=true;
                findPath2(nexti,nextj,move+direction.charAt(i),result,matrix,visited,di,dj);
                visited[row][col]=false;
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[][] matrix=new int[n][n];
        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++)
                matrix[i][j]=sc.nextInt();
        
        ArrayList<String> result=Ratinmaze2(matrix);
        if(result.size()==0)
            System.out.println(-1);
        else
            System.out.println(result);
    }
}
