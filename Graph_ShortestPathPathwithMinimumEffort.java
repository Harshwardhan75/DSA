import java.util.*;

public class Graph_ShortestPathPathwithMinimumEffort {
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

        System.out.println(MinimumEffort(grid));
    }

    static int MinimumEffort(int[][] grid) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        int n = grid.length;
        int m = grid[0].length;

        int[][] dist = new int[n][m];
        for (int[] i : dist)
            Arrays.fill(i, (int) 1e9);

        pq.offer(new int[] { 0, 0, 0 });
        int[][] dir = new int[][] { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

        while (!pq.isEmpty()) {
            int row = pq.peek()[0];
            int col = pq.peek()[1];
            int dis = pq.peek()[2];
            pq.poll();

            for(int[] i: dir){
                int nexti=row+i[0];
                int nextj=col+i[1];

                if(nexti>=0 &&  nexti<n && nextj>=0 && nextj<m){
                    int newEffort=Math.max(dis,
                    Math.abs(grid[nexti][nextj]-grid[row][col]));

                    if(newEffort<dist[nexti][nextj]){
                        dist[nexti][nextj]=newEffort;
                        pq.offer(new int[]{nexti,nextj,newEffort});
                    }
                }
            }
        }
        return dist[n-1][m-1];
    }
}
