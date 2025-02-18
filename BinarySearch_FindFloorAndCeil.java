import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class BinarySearch_FindFloorAndCeil {

    static int findfloor(ArrayList<Integer> arr,int x){
        int low=0,high=arr.size()-1;
        int result=-1;

        while(low<=high){
            int mid=(low+high)/2;

            if(arr.get(mid)<=x){
                result=arr.get(mid);
                low=mid+1;
            }
            else
                high=mid-1;
        }

        return result;
    }

    static int findceil(ArrayList<Integer> arr,int x){
        int low=0,high=arr.size()-1;
        int result=-1;

        while(low<=high){
            int mid=(low+high)/2;

            if(arr.get(mid)>=x){
                result=arr.get(mid);
                high=mid-1;
            }
            else    
                low=mid+1;
        }

        return result;
    }

    static ArrayList<Integer> FloorAndCeil(ArrayList<Integer> arr,int x){
        int floor=findfloor(arr,x);
        int ceil=findceil(arr,x);

        return new ArrayList<>(Arrays.asList(floor,ceil));
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        ArrayList<Integer> arr=new ArrayList<>();

        for(int i=0;i<n;i++)    arr.add(sc.nextInt());
        
        int target=sc.nextInt();
        System.out.println(FloorAndCeil(arr,target));
    }
}
