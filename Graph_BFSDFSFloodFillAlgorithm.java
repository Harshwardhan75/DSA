import java.util.*;

public class Graph_BFSDFSFloodFillAlgorithm {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] grid = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        int[][] result = FloodFillDFS(grid, 1, 1, 2);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }

    static int[][] FloodFillDFS(int[][] grid, int sr, int sc, int newColor) {
        int initColor = grid[sr][sc];
        if (initColor == newColor)
            return grid;
        int[][] dir = new int[][] { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

        dfs(grid, sr, sc, initColor, newColor, dir);
        return grid;
    }

    static void dfs(int[][] grid,int r,int c,int initColor,int newColor,int[][] dir){
        grid[r][c]=newColor;
        int n=grid.length;
        int m=grid[0].length;

        for (int[] i : dir) {
            int nexti = r + i[0];
            int nextj = c + i[1];

            if (nexti >= 0 && nexti < n && nextj >= 0 && nextj < m && grid[nexti][nextj] == initColor) {
                dfs(grid, nexti, nextj, initColor, newColor, dir);
            }
        }
    }

    static int[][] FloodFillBFS(int[][] grid, int sr, int sc, int newColor) {
        int n = grid.length;
        int m = grid[0].length;
        Queue<int[]> que = new LinkedList<>();
        que.offer(new int[] { sr, sc });
        int[][] dir = new int[][] { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
        int initColor = grid[sr][sc];
        if (initColor == newColor)
            return grid;
        grid[sr][sc] = newColor;
        while (!que.isEmpty()) {
            int r = que.peek()[0];
            int c = que.peek()[1];
            que.poll();

            for (int[] i : dir) {
                int nexti = r + i[0];
                int nextj = c + i[1];

                if (nexti >= 0 && nexti < n && nextj >= 0 && nextj < m && grid[nexti][nextj] == initColor) {
                    grid[nexti][nextj] = newColor;
                    que.offer(new int[] { nexti, nextj });
                }
            }
        }

        return grid;
    }
}
