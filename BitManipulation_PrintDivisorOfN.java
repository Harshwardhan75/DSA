import java.util.ArrayList;
import java.util.Scanner;

public class BitManipulation_PrintDivisorOfN {

    static ArrayList<Integer> BruteDivisor(int n){
        ArrayList<Integer> arr=new ArrayList<>();
        for(int i=1;i<=n;i++)
            if(n%i==0)
                arr.add(i);
            
        return arr;
    }

    static ArrayList<Integer> BetterDivisor(int n){
        ArrayList<Integer> arr=new ArrayList<>();
        for(int i=1;i<=Math.sqrt(n);i++){
            if(n%i==0){
                arr.add(i);
                if(i!=n/i)
                    arr.add(n/i);
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        System.out.println(BetterDivisor(n));
    }
}
