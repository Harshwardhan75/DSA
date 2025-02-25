import java.util.*;

public class FenwickTree_RangeSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        n++;
        int q = sc.nextInt();
        int[] arr = new int[n];
        int[][] query = new int[q][];
        for (int i = 1; i < n; i++)
            arr[i] = sc.nextInt();

        for (int i = 0; i < q; i++)
            query[i] = new int[] { sc.nextInt(), sc.nextInt(), sc.nextInt() };

        System.out.println(FindRangeSum(arr, query));
    }

    static class FenwickTree{
        int[] fen;
        int length;

        FenwickTree(int n){
            this.fen=new int[n];
            this.length=n;
        }

        void update(int index,int add){
            while(index<length){
                fen[index]+=add;
                index=index+(index&(-index));
            }
        }

        int getRangeSum(int index){
            int sum=0;
            while(index>0){
                sum+=fen[index];
                index = index - (index&(-index));
            }
            return sum;
        }

        void build(int[] arr){
            for(int i=1;i<length;i++){
                update(i, arr[i]);
            }
        }

        int getRangeSum(int l,int r){
            return getRangeSum(r)-getRangeSum(l-1);
        }

    }

    static ArrayList<Integer> FindRangeSum(int[] arr,int[][] query){
        int n=arr.length;
        FenwickTree ftree=new FenwickTree(n);

        ftree.build(arr);
        ArrayList<Integer> result=new ArrayList<>();

        for(int[] q: query){
            if(q[0]==1)
                result.add(ftree.getRangeSum(q[1], q[2]));
            else{
                ftree.update(q[1], q[2]);
                result.add(null);
            }
        }

        return result;
    }
}
