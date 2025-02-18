import java.util.*;

public class Graph_BFSDFSNumberOfEnclaves {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] grid = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++)
                grid[i][j] = sc.nextInt();
        }

        System.out.println(numEnclavesBFS(grid));
        System.out.println(numEnclavesDFS(grid));

        // for (int[] i : grid) {
        // for (int j : i)
        // System.out.print(j + " ");
        // System.out.println();
        // }
    }

    static int numEnclavesDFS(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            if (!visited[i][0] && grid[i][0] == 1)
                DFS(i, 0, visited, grid);

            if (!visited[i][m - 1] && grid[i][m - 1] == 1)
                DFS(i, m - 1, visited, grid);
        }

        for (int i = 0; i < m; i++) {
            if (!visited[0][i] && grid[0][i] == 1)
                DFS(0, i, visited, grid);
            if (!visited[n - 1][i] && grid[n - 1][i] == 1)
                DFS(n - 1, i, visited, grid);
        }

        int count=0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && grid[i][j] == 1)
                    count++;
            }
        }

        return count;
    }

    static void DFS(int r,int c,boolean[][] visited,int[][] grid){
        visited[r][c]=true;
        int[][] dir = new int[][] { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
        int n=grid.length;
        int m=grid[0].length;
        for (int[] i : dir) {
            int nexti = r + i[0];
            int nextj = c + i[1];

            if (nexti >= 0 && nexti < n && nextj >= 0 && nextj < m && !visited[nexti][nextj]
                    && grid[nexti][nextj] == 1) {
                DFS(nexti, nextj, visited, grid);
            }
        }

    }

    static int numEnclavesBFS(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        Queue<int[]> que = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];
        int totalOne = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 || j == 0 || i == n - 1 || j == m - 1) {
                    if (grid[i][j] == 1) {
                        que.offer(new int[] { i, j });
                        visited[i][j] = true;
                    }
                }
                if (grid[i][j] == 1)
                    totalOne++;
            }
        }

        int[][] dir = new int[][] { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

        while (!que.isEmpty()) {
            int r = que.peek()[0];
            int c = que.peek()[1];
            que.poll();
            totalOne--;
            for (int[] i : dir) {
                int nexti = r + i[0];
                int nextj = c + i[1];

                if (nexti >= 0 && nexti < n && nextj >= 0 && nextj < m && !visited[nexti][nextj]
                        && grid[nexti][nextj] == 1) {
                    visited[nexti][nextj] = true;
                    que.offer(new int[] { nexti, nextj });
                }
            }
        }

        return totalOne;
    }
}
