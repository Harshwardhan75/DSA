import java.util.*;

public class Recursion_NQueen {

    static ArrayList<ArrayList<String>> BruteNQueen(int n) {
        boolean[][] matrix = new boolean[n][n];
        ArrayList<ArrayList<String>> result = new ArrayList<>();
        BruteSolve(result, matrix, 0, n);
        return result;
    }

    static void BruteSolve(ArrayList<ArrayList<String>> result, boolean[][] matrix, int tqps, int n) {
        if (tqps == n) {
            ArrayList<String> arr = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                String s = "";
                for (int j = 0; j < n; j++) {
                    if (matrix[i][j])
                        s += "Q";
                    else
                        s += ".";
                }
                arr.add(s);
            }
            result.add(arr);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (canBePlaced(matrix, tqps, i)) {
                matrix[tqps][i] = true;
                BruteSolve(result, matrix, tqps + 1, n);
                matrix[tqps][i] = false;
            }
        }
    }

    static boolean canBePlaced(boolean[][] matrix, int row, int col) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            if (matrix[i][col])
                return false;
        }
        int r = row, c = col;

        while (r >= 0 && c >= 0) {
            if (matrix[r--][c--])
                return false;
        }

        r = row;
        c = col;
        while (r >= 0 && c < n) {
            if (matrix[r--][c++])
                return false;
        }

        return true;
    }

    static ArrayList<ArrayList<String>> Optimal_NQueen(int n) {
        boolean[][] matrix = new boolean[n][n];
        boolean[] column_status = new boolean[n];
        boolean[] leftDiagonal = new boolean[2*n-1];
        boolean[] rightDiagonal = new boolean[2*n-1];
        ArrayList<ArrayList<String>> result = new ArrayList<>();
        OptimalSolve(result, matrix, 0, n, column_status, leftDiagonal, rightDiagonal);
        return result;
    }

    public static void OptimalSolve(ArrayList<ArrayList<String>> result, boolean[][] matrix, int tqps, int n, boolean[] column_status, boolean[] leftDiagonal, boolean[] rightDiagonal) {
        if(tqps==n){
            ArrayList<String> arr = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                String s = "";
                for (int j = 0; j < n; j++) {
                    if (matrix[i][j])
                        s += "Q";
                    else
                        s += ".";
                }
                arr.add(s);
            }
            result.add(arr);
            return;
        }

        for(int i=0;i<n;i++){
            if(!column_status[i] && !leftDiagonal[tqps+i] && !rightDiagonal[n-1+tqps-i]){
                column_status[i]=true;
                leftDiagonal[tqps+i]=true;
                rightDiagonal[n-1+tqps-i]=true;
                matrix[tqps][i]=true;
                OptimalSolve(result, matrix, tqps+1, n, column_status, leftDiagonal, rightDiagonal);
                matrix[tqps][i]=false;
                column_status[i]=false;
                leftDiagonal[tqps+i]=false;
                rightDiagonal[n-1+tqps-i]=false;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<ArrayList<String>> result = BruteNQueen(n);
        System.out.println(result);
    }
}
