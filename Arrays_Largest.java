import java.util.ArrayList;
import java.util.Scanner;

public class Arrays_Largest {

    static int recursivelargest(ArrayList<Integer> arr,int i,int max){
        if(i==arr.size()) return max;

        if(arr.get(i)> max) max=arr.get(i);

        return recursivelargest(arr, i+1, max);
    }

    static int largest(ArrayList<Integer> arr){
        int max=arr.get(0);
        for(int i=0;i<arr.size();i++)
            if(arr.get(i)>max)
                max=arr.get(i);

        return max;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();

        ArrayList<Integer> arr=new ArrayList<>();
        for(int i=0;i<n;i++) arr.add(sc.nextInt());

        System.out.println("The Greatest Element is "+ largest(arr));
        System.out.println("The Greatest Element is "+ recursivelargest(arr,0,arr.get(0)));
    }
}
