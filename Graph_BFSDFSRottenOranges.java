import java.util.*;

public class Graph_BFSDFSRottenOranges {
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

        System.out.println(RottenOranges(grid));
    }

    static int RottenOranges(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        
        int[][] dir = new int[][] { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
        boolean[][] visited=new boolean[n][m];
        Queue<int[]> que = new LinkedList<>();

        int freshcount=0;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==2){
                    visited[i][j]=true;
                    que.offer(new int[]{0,i,j});
                }

                if(grid[i][j]==1)
                    freshcount++;
            }
        }

        int count=0;
        int maxtime=0;
        while(!que.isEmpty()){
            int[] cell=que.poll();
            int t=cell[0];
            int r=cell[1];
            int c=cell[2];

            for(int[] i: dir){
                int nexti=i[0]+r;
                int nextj=i[1]+c;

                if(nexti>=0 && nexti<n && nextj>=0 && nextj<m && !visited[nexti][nextj] && grid[nexti][nextj]==1){
                    count++;
                    visited[nexti][nextj]=true;
                    que.offer(new int[]{t+1,nexti,nextj});
                }
            }
            maxtime=Math.max(maxtime,t);
        }

        return count==freshcount?maxtime:-1;
    }
}
