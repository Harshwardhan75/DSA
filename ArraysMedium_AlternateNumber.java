import java.util.*;

public class ArraysMedium_AlternateNumber {

    static ArrayList<Integer> AlternateNumber(ArrayList<Integer> arr){
        ArrayList<Integer> result=new ArrayList<>();
        ArrayList<Integer> p=new ArrayList<>();
        ArrayList<Integer> n=new ArrayList<>();

        for(int i=0;i<arr.size();i++){
            if(arr.get(i)<0)
                n.add(arr.get(i));
            else
                p.add(arr.get(i));
        }

        if(p.size()>n.size()){
            for(int i=0;i<n.size();i++){
                arr.set(i*2,p.get(i));
                arr.set(2*i+1,n.get(i));
            }

            for(int i=n.size();i<p.size();i++)
                arr.set(i,p.get(i));
        }
        else{
            for(int i=0;i<p.size();i++){
                arr.set(i*2,p.get(i));
                arr.set(2*i+1,n.get(i));
            }

            for(int i=p.size();i<n.size();i++)
                arr.set(i,n.get(i));
        }
        return arr;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        ArrayList<Integer> arr=new ArrayList<>();

        for(int i=0;i<n;i++)    arr.add(sc.nextInt());
            
        System.out.println(arr);
        arr=AlternateNumber(arr);
        System.out.println(arr);
    }
}
