import java.util.Scanner;

public class BinarySearch_FindNthRoot {

    static int Power(int mid ,int n, int m){
        long ans=1;
        for(int i=1;i<=n;i++){
            ans*=mid;
            if(ans>m)   return 2;
        }

        if(ans==m)
            return 1;
        else
            return 0;
    }

    static int BruteFindNthroot(int n,int m){
        for(int i=1;i<=m;i++){
            int x=Power(i, n, m);
            if(x==1)
                return i;
            if(x==2)
                break;
        }

        return -1;
    }

    static int OptimalFindNthroot(int n,int m){
        int low=1,high=m;

        while(low<=high){
            int mid=(low+high)/2;
            int x=Power(mid, n, m);
            if(x==1)    return mid;
            else if(x==0)    low=mid+1;
            else    high=mid-1;
        }

        return -1;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();

        System.out.println(OptimalFindNthroot(n,m));
    }
}