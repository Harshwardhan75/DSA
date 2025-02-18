import java.util.*;

public class ArraysMedium_NextGreaterPermutation {

    static void nextPermutation(ArrayList<Integer> arr){
        int ind=-1;
        for(int i=arr.size()-2;i>=0;i--){
            if(arr.get(i)<arr.get(i+1)){
                ind=i;
                break;
            }
        }

        if(ind==-1){
            Collections.reverse(arr);
            return;
        }

        for(int i=arr.size()-1;i>ind;i--){
            if(arr.get(i)>arr.get(ind)){
                int temp=arr.get(i);
                arr.set(i,arr.get(ind));
                arr.set(ind,temp);
                break;
            }
        }

        List<Integer> subList= arr.subList(ind+1,arr.size());
        Collections.reverse(subList);
        return;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();

        ArrayList<Integer> arr=new ArrayList<>();
        for(int i=0;i<n;i++)    arr.add(sc.nextInt());

        System.out.println(arr);

        nextPermutation(arr);
        System.out.println(arr);
    }
}
