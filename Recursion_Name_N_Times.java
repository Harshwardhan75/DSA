import java.util.Scanner;

public class Recursion_Name_N_Times {

    static void PrintName(int i,int n){
        if(i==n)    return;

        System.out.println("Harshwardhan");
        PrintName(i+1,n);
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        PrintName(0,n);
    }   
}
