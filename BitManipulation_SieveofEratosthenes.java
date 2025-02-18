import java.util.ArrayList;
import java.util.Scanner;

public class BitManipulation_SieveofEratosthenes {

    static boolean isPrime(int n){
        for(int i=2;i*i<=n;i++)
            if(n%i==0)
                return false;
            
        return true;
    }

    static ArrayList<Integer> BrutePrimeTilln(int n){
        ArrayList<Integer> arr=new ArrayList<>();
        for(int i=2;i<=n;i++){
            if(isPrime(i))
                    arr.add(i);;
        }
        return arr;
    }

    static ArrayList<Integer> BetterPrimeTilln(int n){
        ArrayList<Integer> arr=new ArrayList<>();
        int[] prime=new int[n+1];
        for(int i=0;i<=n;i++)   prime[i]=1;

        for(int i=2;i<=n;i++){
            if(prime[i]==1){
                for(int j=2*i;j<=n;j+=i)
                    prime[j]=0;
            }
        }

        for(int i=2;i<=n;i++){
            if(prime[i]==1)
                arr.add(i);
        }

        return arr;
    }

    static ArrayList<Integer> OptimalPrimeTilln(int n){
        int[] prime=new int[n+1];
        for(int i=1;i<=n;i++)    prime[i]=1;

        for(int i=2;i*i<=n;i++){
            if(prime[i]==1){
                for(int j=i*i;j<=n;j+=i){
                    prime[j]=0;
                }
            }
        }

        ArrayList<Integer> arr=new ArrayList<>();
        for(int i=2;i<=n;i++)   
        if(prime[i]==1)
            arr.add(i);
        
        return arr;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        System.out.println(OptimalPrimeTilln(n));
    }
}
