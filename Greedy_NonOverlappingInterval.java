import java.util.Arrays;
import java.util.Scanner;

public class Greedy_NonOverlappingInterval {

    static int findNonOverlappingInterval(int[][] interval){
        Arrays.sort(interval,(a,b)->Integer.compare(a[1],b[1]));
        
        int count=1;
        int endtime=interval[0][1];
        int n=interval.length;
        for(int i=1;i<n;i++){
            if(endtime<=interval[i][0]){
                endtime=interval[i][1];
                count++;
            }
        }

        return n-count;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();

        int[][] interval=new int[n][2];

        for(int i=0;i<n;i++)
            interval[i]=new int[]{sc.nextInt(),sc.nextInt()};
        
        System.out.println(findNonOverlappingInterval(interval));
    }
}
