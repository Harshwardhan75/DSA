import java.util.Arrays;
import java.util.Scanner;

public class Greedy_ShortestJobFirst {

    static int FindAvergaeWaitingTime(int[] arr){
        int n=arr.length;

        Arrays.sort(arr);
        int t=0,waittime=0;

        for(int i: arr){
            waittime+=t;
            t+=i;
        }

        return waittime/n;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];

        for(int i=0;i<n;i++)
            arr[i]=sc.nextInt();
        
        System.out.println(FindAvergaeWaitingTime(arr));
    }
}
