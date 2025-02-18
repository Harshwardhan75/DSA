import java.util.*;
import javax.management.Query;

public class Graph_BFSDFS_OsToXs {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        char[][] grid = new char[n][m];

        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                grid[i][j] = sc.next().charAt(0);

        // ReplaceDFS(grid);
        ReplaceBFS(grid);

        for (char[] i : grid) {
            for (char j : i)
                System.out.print(j + " ");
            System.out.println();
        }
    }

    static void ReplaceBFS(char[][] grid){
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        Queue<int[]> que=new LinkedList<>();

        for (int i = 0; i < n; i++) {
            if (!visited[i][0] && grid[i][0] == 'O'){
                visited[i][0]=true;
                que.offer(new int[]{i,0});
            }
                
            if (!visited[i][m - 1] && grid[i][m - 1] == 'O'){
                visited[i][m-1]=true;
                que.offer(new int[]{i,m-1});
            }
        }

        for (int i = 0; i < m; i++) {
            if (!visited[0][i] && grid[0][i] == 'O'){
                visited[0][i]=true;
                que.offer(new int[]{0,i});
            }
            if (!visited[n - 1][i] && grid[n - 1][i] == 'O'){
                visited[0][i]=true;
                que.offer(new int[]{n-1,i});
            }
        }
        int[][] dir = new int[][] { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

        while(!que.isEmpty()){
            int row=que.peek()[0];
            int col=que.peek()[1];
            que.poll();
            
            for(int[] i: dir){
                int nexti=row+i[0];
                int nextj=col+i[1];
                if(nexti>=0 && nexti<n && nextj>=0 && nextj<m && !visited[nexti][nextj] && grid[nexti][nextj]=='O'){
                    visited[nexti][nextj]=true;
                    que.offer(new int[]{nexti,nextj});
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && grid[i][j] == 'O')
                    grid[i][j] = 'X';
            }
        }
    }

    static void ReplaceDFS(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            if (!visited[i][0] && grid[i][0] == 'O')
                dfs(i, 0, visited, grid);
                
            if (!visited[i][m - 1] && grid[i][m - 1] == 'O')
                dfs(i, m - 1, visited, grid);
        }

        for (int i = 0; i < m; i++) {
            if (!visited[0][i] && grid[0][i] == 'O')
                dfs(0, i, visited, grid);
            if (!visited[n - 1][i] && grid[n - 1][i] == 'O')
                dfs(n - 1, i, visited, grid);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && grid[i][j] == 'O')
                    grid[i][j] = 'X';
            }
        }
    }

    static void dfs(int r, int c, boolean[][] visited, char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] dir = new int[][] { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
        visited[r][c]=true;
        for(int[] i: dir){
            int nexti=r+i[0];
            int nextj=c+i[1];
            if(nexti>=0 && nexti<n && nextj>=0 && nextj<m && !visited[nexti][nextj] && grid[nexti][nextj]=='O'){
                dfs(nexti, nextj, visited, grid);
            }
        }
    }
}
