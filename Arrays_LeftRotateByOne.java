import java.util.ArrayList;
import java.util.Scanner;

public class Arrays_LeftRotateByOne {
    static ArrayList<Integer> LeftRotate(ArrayList<Integer> arr){
        int temp=arr.get(0);
        System.out.println(arr);
        for(int i=1;i<arr.size();i++)
            arr.set(i-1,arr.get(i));
        arr.set(arr.size()-1,temp);
        return arr;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();

        ArrayList<Integer> arr=new ArrayList<>();

        for(int i=0;i<n;i++)    arr.add(sc.nextInt());
        
        arr=LeftRotate(arr);

        System.out.println(arr);
    }
}
