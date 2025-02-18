import java.util.Scanner;

public class Recursion_POW {

    static double IterativePOW(int x,int n){
        int nn=n;
        if(n<0) nn*=-1;

        double ans=1.0;

        while(nn>0){
            if(nn%2==1){
                ans=ans*x;
                nn--;
            }
            else{
                x*=x;
                nn/=2;
            }
        }

        if(n<0)
            return 1/ans;
        else    
            return ans;
    }

    static double POW(int x,int n){
        if(n==0)    return 1;

        if(n%2==1)
            return x*POW(x, n-1);
        else    
            return POW(x*x,n/2);
    }

    static double RecursivePOW(int x,int n){
        int nn=n;
        if(n<0) nn*=-1;
        double ans=POW(x,nn);
        if(n<0)
            return 1/ans;
        else
            return ans;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int x=sc.nextInt();
        int n=sc.nextInt();

        System.out.println(RecursivePOW(x,n));
    }
}
