import java.util.*;

public class BitManipulation_CountNoOfSetBits {

    static int BrutesetBits(int n){
        int count=0;

        while(n>0){
            if(n%2==1)  count++;
            n/=2;
        }
        return count;
    }

    
    static int Approach2(int n){
        int count=0;
        while(n!=0){
            if((n&1) == 1) count+=1;
            n=n>>1;
        }        
        return count;
    }
    
    static int Approach3(int n){
        int count=0;
        while(n!=0){
            count+=n&1;
            n>>=1;
        }
        return count;
    }

    static int Approach4(int n){
        int count=0;
        while(n!=0){
            n&=n-1;
            count++;
        }
        return count;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        System.out.println(Approach4(n));
    }
}