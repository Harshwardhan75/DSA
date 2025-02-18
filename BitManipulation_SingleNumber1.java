import java.util.Scanner;

public class BitManipulation_SingleNumber1 {

    static int SingleNumber1(int[] arr){
        int xor=0;
        for(int i: arr)
            xor^=i;
        return xor;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++)    arr[i]=sc.nextInt();

        System.out.println(SingleNumber1(arr));
    }
}
