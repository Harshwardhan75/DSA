import java.util.Scanner;

public class BinarySearch_FindSquareRoot {

    static int BruteSquare(int n){
        int ans=1;
        for(int i=1;i<=n;i++){
            if(i*i<=n)
                ans=i;
            else
                break;
        }

        return ans;
    }

    static int OptimalSquare(int n){
        int low=1,high=n,ans=1;

        while(low<=high){
            int mid=low+(high-low)/2;
            if(mid*mid<=n){
                ans=mid;
                low=mid+1;
            }
            else
                high=mid-1;
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();

        System.out.println(BruteSquare(n));
    }
}