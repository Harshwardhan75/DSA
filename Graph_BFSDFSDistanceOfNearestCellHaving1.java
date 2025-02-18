import java.util.*;

public class Graph_BFSDFSDistanceOfNearestCellHaving1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] grid = new int[n][m];

        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                grid[i][j] = sc.nextInt();

        narestOne(grid);
        for (int[] i : grid) {
            for (int j : i)
                System.out.print(j + " ");
            System.out.println();
        }
    }

    static void narestOne(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        Queue<int[]> que = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    visited[i][j] = true;
                    que.offer(new int[] { 0, i, j });
                }
            }
        }
        int[][] dir = new int[][] { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
        while (!que.isEmpty()) {
            int step = que.peek()[0];
            int row = que.peek()[1];
            int col = que.peek()[2];
            que.poll();
            grid[row][col]=step;
            for(int[] i: dir){
                int nexti=row+i[0];
                int nextj=col+i[1];

                if(nexti>=0 && nexti<n && nextj>=0 && nextj<m && !visited[nexti][nextj]){
                    visited[nexti][nextj]=true;
                    que.offer(new int[]{step+1,nexti,nextj});
                }
            }
        }
    }
}
