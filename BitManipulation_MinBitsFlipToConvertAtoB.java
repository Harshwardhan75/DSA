import java.util.Scanner;

public class BitManipulation_MinBitsFlipToConvertAtoB {

    static int bitflip(int a,int b){
        int ans=a^b;
        int count=0;
        for(int i=0;i<32;i++)
            if((ans & (1<<i))!=0)
                count++;
        return count;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int a=sc.nextInt();
        int b=sc.nextInt();
        System.out.println(bitflip(a,b));
    }
}