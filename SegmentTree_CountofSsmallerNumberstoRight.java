import java.util.*;

public class SegmentTree_CountofSsmallerNumberstoRight {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        System.out.println(countSmaller(arr));
    }

    static class SegmentTree {
        int[] seg;
        int length;

        SegmentTree(int n) {
            this.length = n;
            this.seg = new int[4 * n];
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
            this.buildTree(0, 0, length - 1, arr);
        }

        void updateTree(int index, int low, int high, int updateindex) {
            if (low == high) {
                seg[index]--;
                return;
            }

            int mid = (low + high) >> 1;

            if (updateindex <= mid)
                updateTree(2 * index + 1, low, mid, updateindex);
            else
                updateTree(2 * index + 2, mid + 1, high, updateindex);

            seg[index] = seg[2 * index + 1] + seg[2 * index + 2];
        }

        void update(int updateindex) {
            this.updateTree(0, 0, length - 1, updateindex);
        }

        int getRangeSum(int index, int low, int high, int l, int r) {
            if (high < l || r < low)
                return 0;

            if (l <= low && high <= r)
                return seg[index];

            int mid = (low + high) >> 1;

            int left = getRangeSum(2 * index + 1, low, mid, l, r);
            int right = getRangeSum(2 * index + 2, mid + 1, high, l, r);

            return left + right;
        }

        int getRangeSum(int l, int r) {
            return this.getRangeSum(0, 0, length - 1, l, r);
        }
    }

    public static List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i : nums) {
            min = Math.min(min, i);
            max = Math.max(max, i);
        }
        max++;
        int bound = min < 0 ? Math.abs(min) : 0;

        int[] freq = new int[max + bound];

        for (int i : nums)
            freq[bound + i]++;

        SegmentTree stree = new SegmentTree(freq.length);
        stree.build(freq);

        List<Integer> result = new ArrayList<>();

        for (int i : nums) {
            freq[bound + i]--;
            stree.update(bound + i);
            int val = stree.getRangeSum(0, bound + i - 1);
            result.add(val);
        }
        return result;
    }
}