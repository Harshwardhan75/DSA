import java.util.*;

public class BitManipulation_Basics2 {

    static void swap(int a,int b){
        System.out.println(a+" "+b);
        a=a^b;
        b=a^b;
        a=a^b;
        System.out.println(a+" "+b);
    }

    static String ConvertToBinary(int n){
        String result="";
        while(n!=0){
            if(n%2==0)
                result+="0";
            else
                result+="1";
            n/=2;
        }
        result=new StringBuilder(result).reverse().toString();
        return result;
    }

    static int ConvertToDecimal(String s){
        int n=0;
        int p2=1;
        for(int i=s.length()-1;i>=0;i--){
            if(s.charAt(i)=='1'){
                n+=p2;
            }
            p2*=2;
        }
        return n;
    }

    static boolean BruteithBitSet(int n,int i){
        String s=ConvertToBinary(n);
        s=new StringBuilder(s).reverse().toString();
        return s.charAt(i)=='1';
    }

    static boolean OptimalithBitSetLeftshift(int n,int i){
        return (n&(1<<i))!=0;
    }

    static boolean OptimalithBitSetRightshift(int n,int i){
        return ((n>>i)&1)!=0;
    }

    static int SetithBit(int n,int i){
        return (n|(1<<i));
    }

    static int clearithbit(int n,int i){
        return (n & ~(1<<i));
    }

    static int toggleithBit(int n,int i){
        return (n^(1<<i));
    }

    static int removeLastsetBit(int n){
        return (n&n-1);
    }

    static boolean checkPowerof2(int n){
        return (n&n-1) == 0;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        // int a=sc.nextInt();
        // int b=sc.nextInt();
        // swap(a,b);

        // int n=sc.nextInt();
        // int i=sc.nextInt();
        // System.out.println(BruteithBitSet(n, i));
        // System.out.println(OptimalithBitSetLeftshift(n, i));
        // System.out.println(OptimalithBitSetRightshift(n, i));

        // int n=sc.nextInt();
        // int i=sc.nextInt();
        // System.out.println(SetithBit(n,i));
        // int n=sc.nextInt();
        // int i=sc.nextInt();
        // System.out.println(clearithbit(n,i));

        // int n=sc.nextInt();
        // int i=sc.nextInt();
        // System.out.println(toggleithBit(n,i));
        // int n=sc.nextInt();
        // System.out.println(removeLastsetBit(n));
        int n=sc.nextInt();
        System.out.println(checkPowerof2(n));
    }
}