import java.util.*;

class count_digit{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);

        int n=sc.nextInt();
        int count=0;
        while(n!=0){
            int temp=n%10;
            n=n/10;
            count++;
        }
        
        System.out.println("The Number of Digits are "+count);
    }
}