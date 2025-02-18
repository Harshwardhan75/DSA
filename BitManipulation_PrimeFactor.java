import java.util.ArrayList;
import java.util.Scanner;

public class BitManipulation_PrimeFactor {

    static boolean isPrime(int n){
        for(int i=2;i*i<=n;i++)
            if(n%i==0)
                return false;
            
        return true;
    }

    static ArrayList<Integer> BrutePrime(int n){
        ArrayList<Integer> arr=new ArrayList<>();
        for(int i=2;i<=n;i++){
            if(n%i==0){
                if(isPrime(i))
                    arr.add(i);
            }
        }
        return arr;
    }

    static ArrayList<Integer> BetterPrime(int n){
        ArrayList<Integer> arr=new ArrayList<>();
        for(int i=2;i<=Math.sqrt(n);i++){
            if(n%i==0){
                if(isPrime(i))
                    arr.add(i);
                if(n/i != i)
                    if(isPrime(n/i))
                        arr.add(n/i);
            }
        }
        return arr;
    }

    static ArrayList<Integer> OptimalPrime(int n){
        ArrayList<Integer> arr=new ArrayList<>();
        for(int i=2;i<=Math.sqrt(n);i++){
            if(n%i==0){
                arr.add(i);
                while(n%i==0)
                    n/=i;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        System.out.println(OptimalPrime(n));
    }
}