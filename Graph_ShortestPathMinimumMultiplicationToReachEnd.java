import java.util.*;

public class Graph_ShortestPathMinimumMultiplicationToReachEnd {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int start = sc.nextInt();
        int end = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        System.out.println(minimumMultiplication(arr, start, end));
    }

    static int minimumMultiplication(int[] arr, int start, int end) {
        int[] dist = new int[100000];
        Arrays.fill(dist, (int) 1e9);
        Queue<int[]> que = new LinkedList<>();
        que.offer(new int[] { start, 0 });
        dist[start] = 0;

        while (!que.isEmpty()) {
            int node = que.peek()[0];
            int d = que.peek()[1];
            que.poll();

            for (int i : arr) {
                int nexti=(i*node)%100000;
                if(d+1<dist[nexti]){
                    dist[nexti]=d+1;
                    que.offer(new int[]{nexti,dist[nexti]});
                }
            }
        }

        return dist[end];
    }
}
