import java.util.*;

public class Arrays_Remove_Duplicate {
    //nlogn
    static Set<Integer> RemoveDuplicateSet(ArrayList<Integer> arr){
        Set<Integer> set=new HashSet<>();
        for(int i=0;i<arr.size();i++)    set.add(arr.get(i));
        return set;
    }
    //n
    static int RemoveDuplicateTwoPointer(ArrayList<Integer> arr){
        int p1=0;
        int count=0;
        for(int i=0;i<arr.size();i++){
            if(arr.get(p1)!=arr.get(i)){
                p1++;
                arr.set(p1,arr.get(i));
            }
        }

        return ++p1;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Set<Integer> set=new HashSet<>();
        int n=sc.nextInt();
        ArrayList<Integer> arr=new ArrayList<>();
        for(int i=0;i<n;i++)    arr.add(sc.nextInt());

        set=RemoveDuplicateSet(arr);
        int x=RemoveDuplicateTwoPointer(arr);

        for(int i=0;i<x;i++) System.out.printf("%d ",arr.get(i));

    }
}
