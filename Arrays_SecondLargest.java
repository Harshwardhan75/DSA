import java.util.*;

public class Arrays_SecondLargest {

    static int secondLargest(ArrayList<Integer> arr){
        int secondl=Integer.MIN_VALUE;
        int largest=arr.get(0);
        for(int i=0;i<arr.size();i++){
            if(arr.get(i)>largest){
                secondl=largest;
                largest=arr.get(i);
            }
            else if(arr.get(i)<largest && arr.get(i)> secondl)
                secondl=arr.get(i);
        }

        return secondl;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        ArrayList<Integer> arr=new ArrayList<Integer>();
        for(int i=0;i<n;i++) arr.add(sc.nextInt());

        System.out.println(secondLargest(arr));
    }
}
