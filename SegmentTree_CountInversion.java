import java.util.Arrays;
import java.util.Scanner;
import javax.naming.spi.DirStateFactory;

public class SegmentTree_CountInversion {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }


        System.out.println(inversionCount(arr));
    }

    static class SegmentTree{
        int[] seg;
        int length;

        SegmentTree(int n){
            this.seg=new int[4*n];
            this.length=n;
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

        int getRangeQuery(int index, int low, int high, int l, int r) {
            if (high < l || low > r)
                return 0;

            if (l <= low && high <= r)
                return seg[index];

            int mid = (low + high) / 2;
            int left = getRangeQuery(2 * index + 1, low, mid, l, r);
            int right = getRangeQuery(2 * index + 2, mid + 1, high, l, r);

            return left + right;
        }

        int getRangeQuery(int l, int r) {
            return getRangeQuery(0, 0, length - 1, l, r);
        }

        void updateTree(int index, int low, int high, int updateindex, int value) {
            if (low == high) {
                seg[index] += value;
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

    static int inversionCount(int[] arr){
        int max=Arrays.stream(arr).max().orElseThrow();
        max++;
        int[] freq=new int[max];

        for(int i: arr) freq[i]++;
        SegmentTree seg=new SegmentTree(max);
        seg.build(freq);

        int count=0;
        
        for(int i: arr){
            seg.update(i, -1);

            count+=seg.getRangeQuery(0, i-1);
        }

        return count;
    }
}
