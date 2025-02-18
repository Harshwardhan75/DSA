import java.util.ArrayList;
import java.util.Scanner;

public class Arrays_isSorted {

    static String isSorted(ArrayList<Integer> arr){
        for(int i=0;i<arr.size()-1;i++)
            if(arr.get(i)>arr.get(i+1))
                return "NO";
        
        return "YES";
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        ArrayList<Integer> arr=new ArrayList<>();
        for(int i=0;i<n;i++)    arr.add(sc.nextInt());

        System.out.println(isSorted(arr));
    }
}
