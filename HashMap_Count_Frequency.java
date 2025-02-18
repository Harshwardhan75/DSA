import java.util.HashMap;
import java.util.Scanner;

public class HashMap_Count_Frequency {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        
        int n=sc.nextInt();
        int[] arr=new int[n];

        for(int i=0;i<n;i++)
            arr[i]=sc.nextInt();

        HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
        for(int i=0;i<n;i++)
            if(map.containsKey(arr[i]))
                map.put(arr[i], map.get(arr[i])+1);
            else
                map.put(arr[i], 1);

        System.out.println(map);
    }
}
