import java.util.*;

public class ArraysMedium_RearrangeElementsBySign {
    
    static ArrayList<Integer> RearrangeBySign(ArrayList<Integer> arr){
        int pos=0,neg=1;

        ArrayList<Integer> result=new ArrayList<>(Collections.nCopies(arr.size(), 0));

        for(int i=0;i<arr.size();i++){
            if(arr.get(i)<0){
                result.set(neg,arr.get(i));
                neg+=2;
            }
            else{
                result.set(pos,arr.get(i));
                pos+=2;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        ArrayList<Integer> arr=new ArrayList<>();

        for(int i=0;i<n;i++)    arr.add(sc.nextInt());

        System.out.println(arr);

        arr=RearrangeBySign(arr);
        System.out.println(arr);
    }
}