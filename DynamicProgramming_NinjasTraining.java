import java.util.*;

public class DynamicProgramming_NinjasTraining {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] points = new int[n][];
        for (int i = 0; i < n; i++)
            points[i] = new int[] { sc.nextInt(), sc.nextInt(), sc.nextInt() };

        System.out.println(Memoization_NinjasTraining(points));
        System.out.println(Tabulation_NinjasTraining(points));
        System.out.println(SpaceOptimization_NinjasTraining(points));
    }

    static int SpaceOptimization_NinjasTraining(int[][] points) {
        int n = points.length;
        int[] dp = new int[4];
        dp[0] = Math.max(points[0][1], points[0][2]);
        dp[1] = Math.max(points[0][0], points[0][2]);
        dp[2] = Math.max(points[0][0], points[0][1]);
        dp[3] = Math.max(points[0][0], Math.max(points[0][1], points[0][2]));

        for (int day = 1; day < n; day++) {
            int[] temp = new int[4];
            for (int last = 0; last < 4; last++) {
                temp[last] = 0;

                for (int task = 0; task < 3; task++) {
                    if (task != last) {
                        int point = points[day][task] + dp[task];
                        temp[last] = Math.max(temp[last], point);
                    }
                }
            }
            dp = temp;
        }

        return dp[3];
    }

    static int Tabulation_NinjasTraining(int[][] points) {
        int n = points.length;
        int[][] dp = new int[n][4];
        dp[0][0] = Math.max(points[0][1], points[0][2]);
        dp[0][1] = Math.max(points[0][0], points[0][2]);
        dp[0][2] = Math.max(points[0][0], points[0][1]);
        dp[0][3] = Math.max(points[0][0], Math.max(points[0][1], points[0][2]));

        for (int day = 1; day < n; day++) {
            for (int last = 0; last < 4; last++) {
                int max = 0;
                for (int task = 0; task < 3; task++) {
                    if (last != task) {
                        int point = points[day][task] + dp[day - 1][task];
                        max = Math.max(max, point);
                    }
                }
                dp[day][last] = max;
            }
        }

        return dp[n - 1][3];
    }

    static int Memoization_NinjasTraining(int[][] points) {
        int n = points.length;
        int[][] dp = new int[n][4];
        for (int[] i : dp)
            Arrays.fill(i, -1);

        return solve(points, n - 1, 3, dp);
    }

    static int solve(int[][] points, int day, int last, int[][] dp) {
        if (day == 0) {
            int max = 0;
            for (int i = 0; i < 3; i++) {
                if (i != last) {
                    max = Math.max(max, points[day][i]);
                }
            }
            return max;
        }

        if (dp[day][last] != -1)
            return dp[day][last];

        int max = 0;

        for (int i = 0; i < 3; i++) {
            if (i != last) {
                int point = points[day][i] + solve(points, day - 1, i, dp);
                max = Math.max(max, point);
            }
        }

        return dp[day][last] = max;
    }
}
