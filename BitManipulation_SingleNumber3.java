import java.util.Scanner;

public class BitManipulation_SingleNumber3 {

    static int[] SingleNumber3(int[] arr){
        int xor=0;
        for(int i: arr) 
            xor^=i;
        
        int rightbit=(xor&(xor-1))^xor;
        int b1=0,b2=0;
        for(int i=0;i<arr.length;i++){
            if((arr[i] & rightbit)!=0)
                b1=b1^arr[i];
            else
                b2=b2^arr[i];
        }

        return new int[]{b1,b2};
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];

        for(int i=0;i<n;i++)
            arr[i]=sc.nextInt();
        
        int[] result=SingleNumber3(arr);
        System.out.println(result[0]+" "+result[1]);
    }
}