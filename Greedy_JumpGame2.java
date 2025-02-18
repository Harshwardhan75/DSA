import java.util.Scanner;

public class Greedy_JumpGame2 {
    static int find(int[] arr,int index,int jumps){
        if(index>=arr.length-1)
            return jumps;
        
        int min=Integer.MAX_VALUE;
        for(int i=1;i<=arr[index];i++){
            min=Math.min(min, find(arr, index+i, jumps+1));
        }
        return min;
    }

    static int BruteFindMinJumps(int[] arr){
        return find(arr,0,0);
    }

    static int OptimalFindMinJumps(int[] arr){
        int l=0,r=0;

        int n=arr.length;
        int jumps=0;
        while(r<n-1){
            int farthest=0;
            for(int i=l;i<=r;i++)
                farthest=Math.max(farthest, arr[i]+i);
            
            l=r+1;
            r=farthest;
            jumps++;
        }

        return jumps;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];

        for(int i=0;i<n;i++)    
            arr[i]=sc.nextInt();
        
        System.out.println(BruteFindMinJumps(arr));
        System.out.println(OptimalFindMinJumps(arr));
    }
}
