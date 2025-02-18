import java.util.ArrayList;
import java.util.Scanner;

public class Greedy_InsertInterval {

    static ArrayList<int[]> InsertInterval(int[][] intervals,int[] newInterval){
        int n=intervals.length;
        ArrayList<int[]> arr=new ArrayList<>();

        int i=0;

        while(i<n && intervals[i][1]<newInterval[0]){
            arr.add(intervals[i]);
            i++;
        }

        while(i<n && newInterval[1]>=intervals[i][0]){
            newInterval[0]=Math.min(newInterval[0],intervals[i][0]);
            newInterval[1]=Math.max(newInterval[1],intervals[i][1]);
            i++;
        }

        arr.add(newInterval);

        while(i<n){
            arr.add(intervals[i]);
            i++;
        }

        return arr;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();

        int[][] intervals=new int[n][2];
        int[] newInterval=new int[]{sc.nextInt(),sc.nextInt()}; 
        for(int i=0;i<n;i++)
            intervals[i]=new int[]{sc.nextInt(),sc.nextInt()};
        
        ArrayList<int[]> arr=InsertInterval(intervals,newInterval);

        for(int[] i: arr)
            System.out.println("["+i[0]+" "+i[1]+"]");
    }
}
