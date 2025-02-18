import java.util.*;

public class ArraysHard_MergeIntervals {

    static ArrayList<ArrayList<Integer>> BruteMergeIntervals(int[][] arr){
        ArrayList<ArrayList<Integer>> result=new ArrayList<>();
        int n=arr.length;
        Arrays.sort(arr,new Comparator<int[]>() {
            public int compare(int[] a,int[] b){
                return a[0]-b[0];
            }
        });

        for(int i=0;i<n;i++){
            int start=arr[i][0];
            int end=arr[i][1];

            if(!result.isEmpty() && end<=result.get(result.size()-1).get(1))
                continue;
            for(int j=i+1;j<n;j++){
                if(arr[j][0]<=end)
                    end=Math.max(end, arr[j][1]);
                else
                    break;
            }

            result.add(new ArrayList<Integer>(Arrays.asList(start,end)));
        }

        return result;

    }

    static ArrayList<ArrayList<Integer>> OptimalMergeIntervals(int[][] arr){
        ArrayList<ArrayList<Integer>> result=new ArrayList<>();
        int n=arr.length;
        Arrays.sort(arr,new Comparator<int[]>() {
            public int compare(int[] a,int[] b){
                return a[0]-b[0];
            }
        });

        for(int i=0;i<n;i++){
            int start=arr[i][0];
            int end=arr[i][1];
            if(i>0 && start<=result.get(result.size()-1).get(1)){
                end=Math.max(end,result.get(result.size()-1).get(1));
                result.get(result.size()-1).set(1,end);
            }
            else
                result.add(new ArrayList<Integer>(Arrays.asList(start,end)));
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[][] arr=new int[n][2];

        for(int i=0;i<n;i++){
            arr[i][0]=sc.nextInt();
            arr[i][1]=sc.nextInt();
        }

        ArrayList<ArrayList<Integer>> result=OptimalMergeIntervals(arr);

        System.out.println(result);
    }
}
