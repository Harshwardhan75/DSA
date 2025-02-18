import java.util.ArrayList;
import java.util.Scanner;

public class BitManipulation_PrimeFactorisation {

    static ArrayList<Integer> getPrimeFactor(int n){
        ArrayList<Integer> arr=new ArrayList<>();
        for(int i=2;i*i<=n;i++){
            if(n%i==0){
                while(n%i==0){
                    arr.add(i);
                    n/=i;
                }
            }
        }
        if(n>1) arr.add(n);
        return arr;
    }

    static ArrayList<ArrayList<Integer>> BrutePrimeFactorization(int[] queries){
        int n=queries.length;
        ArrayList<ArrayList<Integer>> result=new ArrayList<>();
        for(int i=0;i<n;i++){
            ArrayList<Integer> list=getPrimeFactor(queries[i]);
            result.add(list);
        }
        return result;
    }

    static ArrayList<ArrayList<Integer>> OptimalPrimeFactorization(int[] queries){
        int[] prime=new int[100000+1];
        for(int i=1;i<=1e5;i++)
            prime[i]=i;
        
        for(int i=2;i*i<=1e5;i++){
            if(prime[i]==i){
                for(int j=i*i;j<1e5;j+=i){
                    if(prime[j]==j)
                        prime[j]=i;
                }
            }
        }

        ArrayList<ArrayList<Integer>> result=new ArrayList<>();
        for(int i=0;i<queries.length;i++){
            ArrayList<Integer> arr=new ArrayList<>();
            int n=queries[i];
            while(n>1){
                arr.add(prime[n]);
                n/=prime[n];
            }
            result.add(arr);
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int [] arr=new int[n];
        for(int i=0;i<n;i++)    arr[i]=sc.nextInt();
        System.out.println(OptimalPrimeFactorization(arr));
    }
}
