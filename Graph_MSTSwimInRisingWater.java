import java.util.*;

public class Graph_MSTSwimInRisingWater {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[][] grid=new int[n][n];

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                grid[i][j]=sc.nextInt();
            }
        }

        System.out.println(MaximumDepth(grid));
    }

    static int MaximumDepth(int[][] grid){
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[2]-b[2]);
        int n=grid.length;
        boolean[][] visited=new boolean[n][n];
        visited[0][0]=true;
        pq.offer(new int[]{0,0,grid[0][0]});
        int[][] dir=new int[][]{{0,1},{1,0},{0,-1},{-1,0}};

        int max=-1;

        while(!pq.isEmpty()){
            int row=pq.peek()[0];
            int col=pq.peek()[1];
            int cost=pq.peek()[2];
            pq.poll();
            max=Math.max(max, cost);
            
            if(row==n-1 && col==n-1)
                return max;
            
            for(int[] d: dir){
                int nexti=d[0]+row;
                int nextj=d[1]+col;

                if(nexti>=0 && nexti<n && nextj>=0 && nextj<n && !visited[nexti][nextj]){
                    visited[nexti][nextj]=true;
                    pq.offer(new int[]{nexti,nextj,grid[nexti][nextj]});
                }
            }
        }

        return max;
    }
}
