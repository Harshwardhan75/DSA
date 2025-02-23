import java.util.*;

public class SegmentTree_SerejaAndBrackets {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int q = sc.nextInt();

        int[][] query = new int[q][];
        for (int i = 0; i < q; i++)
            query[i] = new int[] { sc.nextInt(), sc.nextInt() };

        System.out.println(FindFullBracketsinRange(s, query));
    }

    static class SegmentTree {
        static class Info {
            int open = 0;
            int close = 0;
            int full = 0;
            Info(){}

            Info(char c){
                if(c=='(')  open++;
                if(c==')')  close++;
            }

            Info(Info left,Info right){
                int min=Math.min(left.open,right.close);
                open=left.open+right.open-min;
                close=left.close+right.close-min;
                full=left.full+right.full+min;
            }
        }

        Info[] seg;
        int length;

        SegmentTree(int n) {
            this.seg = new Info[4 * n];
            this.length = n;
        }

        void buildTree(int index, int low, int high, char[] crr) {
            if (low == high) {
                seg[index] = new Info(crr[low]);
                return;
            }

            int mid = (low + high) / 2;

            buildTree(2 * index + 1, low, mid, crr);
            buildTree(2 * index + 2, mid + 1, high, crr);

            seg[index] = new Info(seg[2*index+1],
                            seg[2*index+2]);
        }

        void build(char[] crr) {
            buildTree(0, 0, length - 1, crr);
        }

        Info findFull(int index, int low, int high, int l, int r) {
            if(high<l || low>r)
                return new Info();
            
            if(l<=low && high<=r){
                return seg[index];
            }
            int mid=(low+high)/2;
            Info left=findFull(2*index+1, low, mid, l, r);
            Info right=findFull(2*index+2, mid+1, high, l, r);
            
            return new Info(left, right);
        }

        int get(int l, int r) {
            return findFull(0, 0, length - 1, l, r).full;
        }
    }

    static ArrayList<Integer> FindFullBracketsinRange(String s, int[][] query) {
        int n = s.length();
        SegmentTree segtree = new SegmentTree(n);
        char[] crr = s.toCharArray();

        segtree.build(crr);

        ArrayList<Integer> result = new ArrayList<>();

        for (int[] q : query)
            result.add(segtree.get(q[0]-1, q[1]-1));

        return result;
    }
}
