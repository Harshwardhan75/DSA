import java.util.Scanner;

public class Greedy_JumpGame {

    static boolean check(int[] arr,int index){
        if(index>=arr.length-1) return true;
        
        for(int i=1;i<=arr[index];i++)
        {
            if(check(arr,index+i))
                return true;
        }

        return false;
    }

    static boolean BruteFindJumps(int[] arr){
        return check(arr,0);
    }

    static boolean OptimalFindJumps(int[] arr){
        int max=0;
        for(int i=0;i<=arr.length-1;i++){
            if(i>max)
                return false;
            max=Math.max(max,i+arr[i]);
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++)
            arr[i]=sc.nextInt();
        
        System.out.println(BruteFindJumps(arr));
        System.out.println(OptimalFindJumps(arr));
    }
}
