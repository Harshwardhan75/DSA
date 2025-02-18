import java.util.ArrayList;
import java.util.Scanner;

public class BinarySearch_FindMinimumElement {

    static int FindElement(ArrayList<Integer> arr){
        int low=0,high=arr.size()-1;
        int result=Integer.MAX_VALUE;

        while(low<=high){
            int mid=low+(high-low)/2;

            if(arr.get(low)<=arr.get(mid)){
                result=Math.min(result, arr.get(low));
                low=mid+1;
            }
            else{
                result=Math.min(result, arr.get(mid));
                high=mid-1;
            }
        }

        return result;
    }
    
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        ArrayList<Integer> arr=new ArrayList<>();
        for(int i=0;i<n;i++)    arr.add(sc.nextInt());
        System.out.println(FindElement(arr));
    }
}