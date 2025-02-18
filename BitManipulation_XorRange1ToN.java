import java.util.Scanner;

public class BitManipulation_XorRange1ToN {

    static int BruteXor(int n){
        int xor=0;
        for(int i=1;i<=n;i++)   
            xor^=i;
        return xor;
    }

    static int OptimalXor(int n){
        if(n%4==0)
            return n;
        else if(n%4==1)
            return 1;
        else if(n%4==2)
            return n+1;
        else
            return 0;
    }

    static int BruteXorRange(int l,int r){
        int xor=0;
        for(int i=l;i<=r;i++)
            xor^=i;
        return xor;
    }

    static int OptimalXorRange(int l,int r){
        return OptimalXor(l-1)^OptimalXor(r);
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        // int n=sc.nextInt();
        // System.out.println(BruteXor(n));
        // System.out.println(OptimalXor(n));

        int l=sc.nextInt();
        int r=sc.nextInt();
        System.out.println(BruteXorRange(l,r));
        System.out.println(OptimalXorRange(l,r));
    }
}