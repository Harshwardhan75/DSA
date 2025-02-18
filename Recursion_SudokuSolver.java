import java.util.*;

// 5 3 . . 7 . . . .
// 6 . . 1 9 5 . . .
// . 9 8 . . . . 6 .
// 8 . . . 6 . . . 3
// 4 . . 8 . 3 . . 1
// 7 . . . 2 . . . 6
// . 6 . . . . 2 8 .
// . . . 4 1 9 . . 5
// . . . . 8 . . 7 9


public class Recursion_SudokuSolver {

    static boolean solve(char[][] board){
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j]=='.'){
                    for(char c='1';c<='9';c++){
                        if(isValid(board,i,j,c)){
                            board[i][j]=c;
                            if(solve(board))
                                return true;
                            board[i][j]='.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    static boolean isValid(char[][] board,int row,int col,char c){
        for(int i=0;i<9;i++)
            if(board[row][i]==c || board[i][col]==c)
                return false;
            
        int xoffset=row/3;
        int yoffset=col/3;
        xoffset*=3;
        yoffset*=3;

        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++)
                if(board[xoffset+i][yoffset+j]==c)
                    return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=9;
        char[][] board=new char[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                board[i][j]=sc.next().charAt(0);
            }
        }

        solve(board);

        for(char[] i: board){
            for(char j: i)
                System.out.print(j+" ");
            System.out.println();
        }
    }
}
