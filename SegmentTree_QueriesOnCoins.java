import java.util.*;

public class SegmentTree_QueriesOnCoins {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();
        int[] arr = new int[n];
        int[][] query = new int[q][];

        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        for (int i = 0; i < q; i++)
            query[i] = new int[] { sc.nextInt(), sc.nextInt(), sc.nextInt() };

        System.out.println(findRangeHead(arr, query));
    }

    static class SegmentTree {
        int[] seg;
        boolean[] lazy;
        int length;

        SegmentTree(int n) {
            this.length = n;
            this.seg = new int[4 * n];
            this.lazy = new boolean[4 * n];
        }

        void buildTree(int index, int low, int high, int[] arr) {
            if (low == high) {
                seg[index] = arr[low];
                return;
            }

            int mid = (low + high) >> 1;

            buildTree(2 * index + 1, low, mid, arr);
            buildTree(2 * index + 2, mid + 1, high, arr);

            seg[index] = seg[2 * index + 1] + seg[2 * index + 2];
        }

        void build(int[] arr) {
            buildTree(0, 0, length - 1, arr);
        }

        void updateTree(int index, int low, int high, int l, int r) {

            // update previous remaining weight
            if (lazy[index]) {
                seg[index] = (high - low + 1) - seg[index];

                // propagate to the child
                if (low != high) {
                    lazy[2 * index + 1] = !lazy[2 * index + 1];
                    lazy[2 * index + 2] = !lazy[2 * index + 2];
                }

                lazy[index] = false;
            }

            // No overlap
            if (high < l || r < low)
                return;

            // complete overlap
            if (l <= low && high <= r) {
                seg[index] = (high - low + 1) - seg[index];

                if (low != high) {
                    lazy[2 * index + 1] = !lazy[2 * index + 1];
                    lazy[2 * index + 2] = !lazy[2 * index + 2];
                }
                return;
            }

            // partial overlap
            int mid = (low + high) >> 1;
            updateTree(2 * index + 1, low, mid, l, r);
            updateTree(2 * index + 2, mid + 1, high, l, r);

            seg[index] = seg[2 * index + 1] + seg[2 * index + 2];
        }

        void update(int l, int r) {
            updateTree(0, 0, length - 1, l, r);
        }

        int getRangeHead(int index, int low, int high, int l, int r) {

            if (lazy[index]) {
                seg[index] = (high - low + 1) - seg[index];

                if (low != high) {
                    lazy[2 * index + 1] = !lazy[2 * index + 1];
                    lazy[2 * index + 2] = !lazy[2 * index + 2];
                }

                lazy[index] = false;
            }

            if (high < l || low > r)
                return 0;

            if (l <= low && high <= r)
                return seg[index];

            int mid = (low + high) >> 1;

            int left = getRangeHead(2 * index + 1, low, mid, l, r);
            int right = getRangeHead(2 * index + 2, mid + 1, high, l, r);

            return left + right;
        }

        int getRangeHead(int l, int r) {
            return this.getRangeHead(0, 0, length - 1, l, r);
        }
    }

    static ArrayList<Integer> findRangeHead(int[] arr, int[][] query) {
        int n = arr.length;
        SegmentTree stree = new SegmentTree(n);
        stree.build(arr);
        ArrayList<Integer> result = new ArrayList<>();

        for (int[] q : query) {
            if (q[0] == 1) {
                result.add(stree.getRangeHead(q[1], q[2]));
            } else {
                stree.update(q[1], q[2]);
                result.add(null);
            }
        }
        return result;
    }

}