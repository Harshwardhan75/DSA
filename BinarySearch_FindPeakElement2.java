import java.util.Scanner;

public class BinarySearch_FindPeakElement2 {

    static int[] BruteFindPeak(int[][] matrix, int n, int m) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int left = j - 1 >= 0 ? matrix[i][j - 1] : -1;
                int right = j + 1 < m ? matrix[i][j + 1] : -1;
                int top = i - 1 >= 0 ? matrix[i - 1][j] : -1;
                int bottom = i + 1 < n ? matrix[i + 1][j] : -1;
                int center = matrix[i][j];
                if (center > left && center > right && center > top && center > bottom)
                    return new int[] { i, j };
            }
        }

        return new int[] { -1, -1 };
    }

    static int[] BetterFindPeak(int[][] matrix, int n, int m) {
        int max = -1, row = -1, col = -1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] > max) {
                    max = matrix[i][j];
                    row = i;
                    col = j;
                }
            }
        }

        return new int[] { row, col };
    }

    static int maxElement(int[][] matrix, int n, int col) {
        int max = -1, index = -1;
        for (int i = 0; i < n; i++) {
            if (matrix[i][col] > max) {
                max = matrix[i][col];
                index = i;
            }
        }

        return index;
    }

    static int[] OptimalFindPeak(int[][] matrix, int n, int m) {
        int low = 0, high = m - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            int row = maxElement(matrix, n, mid);

            int left = mid - 1 >= 0 ? matrix[row][mid - 1] : -1;
            int right = mid + 1 < m ? matrix[row][mid + 1] : -1;

            if(matrix[row][mid]>left && matrix[row][mid]>right)
                return new int[]{row,mid};
            else if(matrix[row][mid]<right)
                low=mid+1;
            else
                high=mid-1;
        }

        return new int[]{-1,-1};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] matrix = new int[n][m];

        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                matrix[i][j] = sc.nextInt();

        int[] arr = OptimalFindPeak(matrix, n, m);
        System.out.println(arr[0] + " " + arr[1]);
    }
}