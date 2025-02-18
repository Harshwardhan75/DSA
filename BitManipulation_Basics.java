import java.util.*;
public class BitManipulation_Basics {

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

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        String s=ConvertToBinary(n);
        System.out.println(s);
        String d=sc.next();
        System.out.println(ConvertToDecimal(d));
    }
}