import java.util.*;

public class Arrays_ZerosAtEnd {

    static void RemoveZeros(ArrayList<Integer> arr){
        ArrayList<Integer> temp=new ArrayList<>();

        for(int i=0;i<arr.size();i++)
            if(arr.get(i)!=0)
                temp.add(arr.get(i));

        for(int i=0;i<temp.size();i++)
            arr.set(i, temp.get(i));

        for(int i=temp.size();i<arr.size();i++)
            arr.set(i,0);
    }
    
    static int zero(ArrayList<Integer> arr){
        for(int i=0;i<arr.size();i++)
            if(arr.get(i)==0)   return i;

        return -1;
    }
    static void Removezeros(ArrayList<Integer> arr){
        int j=zero(arr);
        if(j!=-1)
            for(int i=j+1;i<arr.size();i++){
                if(arr.get(i)!=0){
                    arr.set(j,arr.get(i));
                    arr.set(i,0);
                    j++;
                }
            }
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        ArrayList<Integer> arr=new ArrayList<>();
        for(int i=0;i<n;i++)    arr.add(sc.nextInt());

        System.out.println(arr);

        Removezeros(arr);
        System.out.println(arr);
    }    
}
