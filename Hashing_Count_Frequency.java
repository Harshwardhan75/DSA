import java.util.*;

public class Hashing_Count_Frequency {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        ArrayList<Integer> arr=new ArrayList<>(n);

        int max=0;
        for(int i=0;i<n;i++){
            arr.add(i, sc.nextInt());
            if(arr.get(i)>max)
                max=arr.get(i);
        }

        ArrayList<Integer> hash=new ArrayList<>(Collections.nCopies(max+1, 0));
        for(int i=0;i<n;i++)
            hash.set(arr.get(i),hash.get(arr.get(i))+1);
        
        int query=sc.nextInt();
        ArrayList<Integer> queryarr=new ArrayList<>(query);
        for(int i=0;i<query;i++){
            int c=sc.nextInt();
            if(c>max)
                queryarr.add(i,0);
            else
                queryarr.add(i, hash.get(c));
        }

        System.out.println(queryarr);
        
    }
}
