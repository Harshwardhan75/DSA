import java.util.*;

public class Graph_ShortestPathinBinaryMaze {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();

        int[][] grid=new int[n][m];

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                grid[i][j]=sc.nextInt();
            }
        }

        int[] src=new int[]{0,1};
        int[] dst=new int[]{2,2};
        System.out.println(shortestPath(grid,src,dst));
    }

    static int shortestPath(int[][] grid,int[] src,int[] dst){
        if(grid[src[0]][src[1]]==0 || grid[dst[0]][dst[1]]==0)
            return -1;
        
        Queue<int[]> que=new LinkedList<>();
        que.offer(new int[]{src[0],src[1],0});

        int[][] dir=new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
        int n=grid.length;
        int m=grid[0].length;
        int[][] dist=new int[n][m];
        
        for(int[] i: dist)  Arrays.fill(i,(int)1e9);
        dist[src[0]][src[1]]=0;

        while(!que.isEmpty()){
            int row=que.peek()[0];
            int col=que.peek()[1];
            int dis=que.peek()[2];
            que.poll();
            
            if(row==dst[0] && col==dst[1])
                return dis;

            for(int[] i: dir){
                int nexti=row+i[0];
                int nextj=col+i[1];

                if(nexti>=0 && nexti<n && nextj>=0 && nextj<m && grid[nexti][nextj]==1 && dis+1<dist[nexti][nextj]){
                    dist[nexti][nextj]=dis+1;
                    que.offer(new int[]{nexti,nextj,dis+1});
                }
            }
        }

        return -1;
    }
}
