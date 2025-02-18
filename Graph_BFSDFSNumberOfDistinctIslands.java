import java.util.*;

public class Graph_BFSDFSNumberOfDistinctIslands {
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

        System.out.println(DistinctElementsBFS(grid));
        System.out.println(DistinctElementsDFS(grid));
    }

    static int DistinctElementsDFS(int[][] grid){
        int n=grid.length;
        int m=grid[0].length;

        boolean[][] visited=new boolean[n][m];
        Set<ArrayList<String>> set=new HashSet<>();

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(!visited[i][j] && grid[i][j]==1){
                    ArrayList<String> arr=new ArrayList<>();
                    DFS(visited,grid,arr,i,j,i,j);
                    set.add(arr);
                }
            }
        }

        return set.size();
    }

    static void DFS(boolean[][] visited,int[][] grid,ArrayList<String> arr,int r,int c,int minr,int minc){
        int n=grid.length;
        int m=grid[0].length;

        visited[r][c]=true;
        arr.add((r-minr)+","+(c-minc));
        int[][] dir = new int[][] { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

        for(int[] i: dir){
            int nexti=r+i[0];
            int nextj=r+i[1];

            if(nexti>=0 && nexti<n && nextj>=0 && nextj<m && !visited[nexti][nextj] && grid[nexti][nextj]==1){
                DFS(visited, grid, arr, nexti, nextj, minr, minc);
            }
        }
        
    }

    static int DistinctElementsBFS(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        Set<ArrayList<String>> set = new HashSet<>();
        boolean[][] visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && grid[i][j] == 1) {
                    ArrayList<String> arr = BFS(visited, grid, i, j);
                    set.add(arr);
                }
            }
        }

        return set.size();
    }

    static ArrayList<String> BFS(boolean[][] visited, int[][] grid, int r, int c) {
        int n = grid.length;
        int m = grid[0].length;
        Queue<int[]> que = new LinkedList<>();
        que.offer(new int[] { r, c });
        visited[r][c] = true;
        int[][] dir = new int[][] { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
        ArrayList<String> arr = new ArrayList<>();

        while (!que.isEmpty()) {
            int row = que.peek()[0];
            int col = que.peek()[1];
            que.poll();
            arr.add((row - r) + "," + (col - c));
            for (int[] i : dir) {
                int nexti = row + i[0];
                int nextj = col + i[1];

                if (nexti >= 0 && nexti < n && nextj >= 0 && nextj < m && !visited[nexti][nextj]
                        && grid[nexti][nextj] == 1) {
                    visited[nexti][nextj] = true;
                    que.offer(new int[] { nexti, nextj });
                }
            }
        }

        return arr;
    }
}
