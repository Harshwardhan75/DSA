import java.util.*;

public class SegmentTree_XeniaAndBitOperation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();
        int length = (int) Math.pow(2, n);
        int[] arr = new int[length];

        for (int i = 0; i < length; i++)
            arr[i] = sc.nextInt();

        int[][] query = new int[q][];

        for (int i = 0; i < q; i++)
            query[i] = new int[] { sc.nextInt(), sc.nextInt() };

        System.out.println(BitOperation(n, arr, query));
    }

    static class SegmentTree_ORandXOR {
        int length;
        int[] seg;
        boolean flag;

        SegmentTree_ORandXOR(int n, boolean flag) {
            this.length = n;
            this.seg = new int[4 * length];
            this.flag = flag;
        }

        void buildTree(int index, int low, int high, int[] arr, boolean flag) {
            if (low == high) {
                seg[index] = arr[low];
                return;
            }

            int mid = (low + high) / 2;

            buildTree(2 * index + 1, low, mid, arr, !flag);
            buildTree(2 * index + 2, mid + 1, high, arr, !flag);
            // true -> OR
            // false -> XOR
            if (flag)
                seg[index] = seg[2 * index + 1] | seg[2 * index + 2];
            else
                seg[index] = seg[2 * index + 1] ^ seg[2 * index + 2];
        }

        void build(int[] arr) {
            buildTree(0, 0, length - 1, arr, this.flag);
        }

        void updateTree(int index, int low, int high, int update_index, int value, boolean flag) {
            if (low == high) {
                seg[index] = value;
                return;
            }

            int mid = (low + high) / 2;

            if (update_index <= mid)
                updateTree(2 * index + 1, low, mid, update_index, value, !flag);
            else
                updateTree(2 * index + 2, mid + 1, high, update_index, value, !flag);

            // true -> OR
            // false -> XOR
            if (flag)
                seg[index] = seg[2 * index + 1] | seg[2 * index + 2];
            else
                seg[index] = seg[2 * index + 1] ^ seg[2 * index + 2];
        }

        void update(int update_index, int value) {
            updateTree(0, 0, length - 1, update_index, value, this.flag);
        }

        int getRoot() {
            return seg[0];
        }
    }

    static ArrayList<Integer> BitOperation(int n, int[] arr, int[][] query) {
        boolean flag = n % 2 == 1;

        SegmentTree_ORandXOR segtree = new SegmentTree_ORandXOR(arr.length, flag);

        segtree.build(arr);

        ArrayList<Integer> result = new ArrayList<>();

        for (int[] q : query) {
            segtree.update(q[0] - 1, q[1]);
            result.add(segtree.getRoot());
        }
        return result;
    }
}
