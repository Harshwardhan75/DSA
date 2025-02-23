import java.util.*;

public class SegmentTree_ImplementationMaxRange {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        int[][] query = new int[q][];

        for (int i = 0; i < q; i++)
            query[i] = new int[] { sc.nextInt(), sc.nextInt(), sc.nextInt() };

        System.out.println(FindMaxRange(arr, query));
    }

    static class SegmentTree {
        int[] seg;
        int length;

        SegmentTree(int n) {
            this.seg = new int[4 * n];
            this.length = n;
        }

        private void buildSegmentTree(int index, int low, int high, int[] arr) {
            if (low == high) {
                seg[index] = arr[low];
                return;
            }

            int mid = (low + high) / 2;
            // int mid=(low+high)>>1;

            buildSegmentTree(2 * index + 1, low, mid, arr);
            buildSegmentTree(2 * index + 2, mid + 1, high, arr);

            seg[index] = Math.max(seg[2 * index + 1], seg[2 * index + 2]);
        }

        void build(int[] arr) {
            this.buildSegmentTree(0, 0, length - 1, arr);
        }

        int getQuery(int left, int right) {
            return find(0, 0, length - 1, left, right);
        }

        private int find(int index, int low, int high, int l, int r) {
            // No overlap
            if (r < low || high < l) {
                return Integer.MIN_VALUE;
            }

            // complete overlap
            if (l <= low && high <= r) {
                return seg[index];
            }

            // partial overlap
            int mid = (low + high) / 2;
            int left = find(2 * index + 1, low, mid, l, r);
            int right = find(2 * index + 2, mid + 1, high, l, r);
            return Math.max(left, right);

        }

        private void update(int index, int low, int high, int update_index, int value) {
            if (low == high) {
                seg[index] = value;
                return;
            }

            int mid = (low + high) / 2;

            if (update_index <= mid)
                update(2 * index + 1, low, mid, update_index, value);
            else
                update(2 * index + 2, mid + 1, high, update_index, value);

            seg[index] = Math.max(seg[2 * index + 1], seg[2 * index + 2]);
        }

        void update(int update_index, int value) {
            update(0, 0, length - 1, update_index, value);
        }
    }

    static ArrayList<Integer> FindMaxRange(int[] arr, int[][] query) {
        int n = arr.length;
        SegmentTree segtree = new SegmentTree(n);
        segtree.build(arr);
        ArrayList<Integer> result = new ArrayList<>();

        for (int[] q : query) {
            if(q[0]==1){
                int ans=segtree.getQuery(q[1], q[2]);
                result.add(ans);
            }
            else{
                segtree.update(q[1], q[2]);
                result.add(null);
            }
        }
        return result;
    }
}
