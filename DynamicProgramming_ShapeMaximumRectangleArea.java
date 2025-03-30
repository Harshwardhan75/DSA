import java.util.*;

public class DynamicProgramming_ShapeMaximumRectangleArea {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] grid = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++)
                grid[i][j] = sc.nextInt();
        }

        System.out.println(MaximumRectangle(grid));
    }

    static int MaximumRectangle(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[] height = new int[m];
        int max = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1)
                    height[j]++;
                else
                    height[j] = 0;
            }

            max = Math.max(max, maxRectangle(height));
        }

        return max;
    }

    static int maxRectangle(int[] height) {
        int n = height.length;
        Stack<Integer> st = new Stack<>();
        int max = 0;
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && height[st.peek()] >= height[i]) {
                int element = height[st.pop()];
                int nse = i;
                int pse = st.isEmpty() ? -1 : st.peek();

                max = Math.max(max, (nse - pse - 1) * element);
            }
            st.push(i);
        }

        while(!st.isEmpty()){
            int element = height[st.pop()];
            int nse = n;
            int pse=st.isEmpty()?-1:st.peek();
            max = Math.max(max, (nse - pse - 1) * element);
        }

        return max;
    }
}
