import java.util.*;

public class Recursion_WordSearch {

    static boolean wordSearch(char[][] board,String word){
        int n=board.length;
        int m=board[0].length;
        boolean[][] visited=new boolean[n][m];
        int[] di={1,0,0,-1};
        int[] dj={0,-1,1,0};
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j]==word.charAt(0)){
                    if(Search(i,j,word.substring(1),board,visited,di,dj))
                        return true;
                }
            }
        }
        return false;
    }

    static boolean Search(int row,int col,String word,char[][] board,boolean[][] visited,int[] di,int[] dj){
        int n=board.length,m=board[0].length;
        if(word.length()==0)
            return true;

        for(int i=0;i<4;i++){
            int nexti=row+di[i];
            int nextj=col+dj[i];
            if(nexti>=0 && nexti<n && nextj>=0 && nextj<m && !visited[nexti][nextj] && board[nexti][nextj]==word.charAt(0)){
                visited[row][col]=true;
                if(Search(nexti, nextj, word.substring(1), board, visited, di, dj))
                    return true;
                visited[row][col]=false;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        char[][] board=new char[n][m];
        String word=sc.next();
        for(int i=0;i<n;i++)
            for(int j=0;j<m;j++)
                board[i][j]=sc.next().charAt(0);
            
        System.out.println(wordSearch(board,word));
    }
    
}