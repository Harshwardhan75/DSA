import java.util.*;

public class ArraysMedium_LeadersInArray {

    static ArrayList<Integer> leaders(ArrayList<Integer> arr){
        int max=Integer.MIN_VALUE;
        ArrayList<Integer> result=new ArrayList<>();
        for(int i=arr.size()-1;i>=0;i--){
            if(arr.get(i)>max){
                max=arr.get(i);
                result.add(max);
            }
        }
        Collections.reverse(result);

        return result;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();

        ArrayList<Integer> arr=new ArrayList<>();

        for(int i=0;i<n;i++)    arr.add(sc.nextInt());

        System.out.println(arr);

        ArrayList<Integer> result=leaders(arr);
        System.out.println(result);
    }
}
