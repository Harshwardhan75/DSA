import java.util.*;

public class SegmentTree_LazyPropagationMinRange {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();
        int[] arr = new int[n];
        int[][] query = new int[q][];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        for (int i = 0; i < q; i++)
            query[i] = new int[] { sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt() };

        System.out.println(FindRangeSum(arr, query));

    }

    static class SegmentTree {
        int[] seg;
        int[] lazy;
        int length;

        SegmentTree(int n) {
            this.length = n;
            this.seg = new int[4 * n];
            this.lazy = new int[4 * n];
        }

        void buildTree(int index, int low, int high, int[] arr) {
            if (low == high) {
                seg[index] = arr[low];
                return;
            }

            int mid = (low + high) >> 1;

            buildTree(2 * index + 1, low, mid, arr);
            buildTree(2 * index + 2, mid + 1, high, arr);

            seg[index] = Math.min(seg[2 * index + 1],seg[2 * index + 2]);
        }

        void build(int[] arr) {
            buildTree(0, 0, length - 1, arr);
        }

        void update(int index, int low, int high, int l, int r, int value) {

            // update previous remaining weight
            if (lazy[index] != 0) {
                seg[index] += lazy[index];

                // propagate to the child
                if (low != high) {
                    lazy[2 * index + 1] += lazy[index];
                    lazy[2 * index + 2] += lazy[index];
                }

                lazy[index] = 0;
            }

            // No overlap
            if (high < l || r < low)
                return;

            // complete overlap
            if (l <= low && high <= r) {
                seg[index] +=  value;

                if (low != high) {
                    lazy[2 * index + 1] += value;
                    lazy[2 * index + 2] += value;
                }
                return;
            }

            // partial overlap
            int mid = (low + high) >> 1;
            update(2 * index + 1, low, mid, l, r, value);
            update(2 * index + 2, mid + 1, high, l, r, value);

            seg[index] = Math.min(seg[2 * index + 1],seg[2 * index + 2]);
        }

        void update(int l, int r, int value) {
            update(0, 0, length - 1, l, r, value);
        }

        int getRangeMin(int index, int low, int high, int l, int r) {

            if(lazy[index]!=0){
                seg[index]+=lazy[index];

                if(low!=high){
                    lazy[2*index+1]+=lazy[index];
                    lazy[2*index+2]+=lazy[index];
                }

                lazy[index]=0;
            }

            if (high < l || low > r)
                return Integer.MAX_VALUE;

            if (l <= low && high <= r)
                return seg[index];

            int mid = (low + high) >> 1;

            int left = getRangeMin(2 * index + 1, low, mid, l, r);
            int right = getRangeMin(2 * index + 2, mid + 1, high, l, r);

            return Math.min(left,right);
        }

        int getRangeMin(int l,int r){
            return getRangeMin(0, 0, length-1, l, r);
        }
    }

    

    static ArrayList<Integer> FindRangeSum(int[] arr,int[][] query){
        ArrayList<Integer> result=new ArrayList<>();
        int n=arr.length;
        SegmentTree stree=new SegmentTree(n);
        stree.build(arr);

        for(int[] q: query){
            if(q[0]==1){
                result.add(stree.getRangeMin(q[1], q[2]));
            }
            else{
                stree.update(q[1], q[2], q[3]);
                result.add(null);
            }
        }

        return result;
    }
}
