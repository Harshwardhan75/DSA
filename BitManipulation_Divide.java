import java.util.*;

public class BitManipulation_Divide {

    static int Divide(int dividend,int divisor){
        if(dividend==divisor)   return 1;
        boolean sign=true;
        if((dividend<0 && divisor>0) || (dividend>=0 && divisor<0))
            sign=false;
        long n=Math.abs((long)dividend);
        long d=Math.abs((long)divisor);
        int sum=0;
        while(n>=d){
            int count=0;
            while(n>=(d<<(count+1)))
                count++;
            sum+=(1<<count);
            n-=(d<<count);
        }

        if(sum==(1<<31) && sign)
            return Integer.MAX_VALUE;
        if(sum==(1<<31) && !sign)
            return Integer.MIN_VALUE;
        
        return sign?sum:-1*sum;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int dividend=sc.nextInt();
        int divisor=sc.nextInt();
        System.out.println(Divide(dividend,divisor));
    }
}