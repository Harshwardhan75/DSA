import java.util.*;

public class Arrays_LinearSearch {

    static int LinearSearch(ArrayList<Integer> arr,int key){
        for(int i=0;i<arr.size();i++)
            if(arr.get(i)==key)
                return i;
        
            return -1;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        ArrayList<Integer> arr=new ArrayList<>();
        for(int i=0;i<n;i++)
            arr.add(sc.nextInt());

        int key=sc.nextInt();
        System.out.println("The index is "+LinearSearch(arr,key));
    }
}
