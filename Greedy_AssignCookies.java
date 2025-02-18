import java.util.Arrays;
import java.util.Scanner;

public class Greedy_AssignCookies {

    static int AssignCookies(int[] greedy,int[] size){
        Arrays.sort(greedy);
        Arrays.sort(size);
        int n=greedy.length;
        int m=size.length;
        int r=0,l=0;

        while(l<m){
            if(r<n && greedy[r]<=size[l])
                r++;
            l++;
        }
        return r;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int[] greedy=new int[n];
        int[] size=new int[m];

        for(int i=0;i<n;i++)    greedy[i]=sc.nextInt();
        for(int i=0;i<m;i++)    size[i]=sc.nextInt();

        System.out.println(AssignCookies(greedy,size));
    }
}