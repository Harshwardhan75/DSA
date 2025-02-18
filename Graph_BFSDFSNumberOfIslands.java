import java.util.*;

public class Graph_BFSDFSNumberOfIslands {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        System.out.println(NumberOfIslandsBFS(arr));
        System.out.println(NumberOfIslandsDFS(arr));
    }

    static int NumberOfIslandsDFS(int[][] arr) {
        int n = arr.length;
        int m = arr[0].length;
        int count = 0;
        boolean[][] visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && arr[i][j] == 1) {
                    count++;
                    dfs(arr, visited, i, j);
                }
            }
        }

        return count;
    }

    static void dfs(int[][] arr,boolean[][] visited,int r,int c){
        int[][] dir = new int[][] { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 }, { 1, 1 }, { -1, -1 }, 
        { 1, -1 }, { -1, 1 } };
        int n=arr.length;
        int m=arr[0].length;

        visited[r][c]=true;

        for(int[] i: dir){
            int nexti=r+i[0];
            int nextj=c+i[1];

            if(nexti>=0 && nexti<n && nextj>=0 && nextj<m && !visited[nexti][nextj] && arr[nexti][nextj]==1){
                dfs(arr, visited, nexti, nextj);
            }
        }
    }

    static int NumberOfIslandsBFS(int[][] arr) {
        int n = arr.length;
        int m = arr[0].length;
        int count = 0;
        boolean[][] visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && arr[i][j] == 1) {
                    count++;
                    bfs(arr, visited, i, j);
                }
            }
        }

        return count;
    }

    static void bfs(int[][] arr, boolean[][] visited, int r, int c) {
        Queue<int[]> que = new LinkedList<>();
        int[][] dir = new int[][] { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 }, { 1, 1 }, { -1, -1 }, 
        { 1, -1 }, { -1, 1 } };
        int n = arr.length;
        int m = arr[0].length;

        que.offer(new int[] { r, c });
        visited[r][c] = true;

        while (!que.isEmpty()) {
            int[] node = que.poll();

            for (int[] i : dir) {
                int nexti = node[0] + i[0];
                int nextj = node[1] + i[1];

                if (nexti >= 0 && nexti < n && nextj >= 0 && nextj < m && !visited[nexti][nextj]
                        && arr[nexti][nextj] == 1) {
                    visited[nexti][nextj] = true;
                    que.offer(new int[] { nexti, nextj });
                }
            }
        }
    }
}
