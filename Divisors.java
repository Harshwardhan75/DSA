import java.util.Scanner;

public class Divisors {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int [] arr=new int[(int)Math.sqrt(n)+1];
        for(int i=1;i<=(int)Math.sqrt(n);i++){
            if(n%i==0){
                arr[i]=n/i;
                if(n/i!=i)
                    System.out.printf("%d ",i);
            }
            else
                arr[i]=0;
        }

        for(int i=1;i<arr.length;i++)
            if(arr[arr.length-i]!=0)
                System.out.printf("%d ",arr[arr.length-i]);

    }
}
