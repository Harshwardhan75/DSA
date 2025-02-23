import java.util.*;

public class SegmentTree_RangeSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        int q = sc.nextInt();

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int[][] query = new int[q][];

        for (int i = 0; i < q; i++)
            query[i] = new int[] { sc.nextInt(), sc.nextInt(), sc.nextInt() };

        System.out.println(findRangeSum(arr, query));
    }

    static class SegmentTree {
        int[] seg;
        int length;

        SegmentTree(int n) {
            this.seg = new int[4 * n];
            this.length = n;
        }

        void buildTree(int index, int low, int high, int[] arr) {
            if (low == high) {
                seg[index] = arr[low];
                return;
            }

            int mid = (low + high) / 2;
            buildTree(2 * index + 1, low, mid, arr);
            buildTree(2 * index + 2, mid + 1, high, arr);

            seg[index] = seg[2 * index + 1] + seg[2 * index + 2];
        }

        void build(int[] arr) {
            this.buildTree(0, 0, length - 1, arr);
        }

        int getRangeSum(int index, int low, int high, int l, int r) {

            if (high < l || low > r)
                return 0;

            if (l <= low && high <= r)
                return seg[index];

            int mid = (low + high) / 2;
            int left = getRangeSum(2 * index + 1, low, mid, l, r);
            int right = getRangeSum(2 * index + 2, mid + 1, high, l, r);

            return left + right;
        }

        int getRangeSum(int l, int r) {
            return getRangeSum(0, 0, length - 1, l, r);
        }

        void updateTree(int index, int low, int high, int updateindex, int value) {
            if (low == high) {
                seg[index] = value;
                return;
            }

            int mid = (low + high) / 2;

            if (updateindex <= mid)
                updateTree(2 * index + 1, low, mid, updateindex, value);
            else
                updateTree(2 * index + 2, mid + 1, high, updateindex, value);

            seg[index] = seg[2 * index + 1] + seg[2 * index + 2];
        }

        void update(int updateindex, int value) {
            this.updateTree(0, 0, length - 1, updateindex, value);
        }
    }

    static ArrayList<Integer> findRangeSum(int[] arr, int[][] query) {
        int n = arr.length;
        SegmentTree stree = new SegmentTree(n);
        stree.build(arr);
        ArrayList<Integer> result = new ArrayList<>();

        for (int[] q : query){
            if(q[0]==1){
                result.add(stree.getRangeSum(q[1], q[2]));
            }
            else{
                stree.update(q[1], q[2]);
                result.add(null);
            }
        }

        return result;
    }
}
