import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class BinarySearch_BloomDay {

    static boolean possible(ArrayList<Integer> arr,int m,int k,int day){
        int count=0,NoBouquet=0;

        for(int i=0;i<arr.size();i++){
            if(arr.get(i)<=day)
                count++;
            else{
                NoBouquet+=count/k;
                count=0;
            }
        }

        NoBouquet+=count/k;
        if(NoBouquet>=m)
            return true;
        else
            return false;
    }


    static int BruteBloomDayMIN(ArrayList<Integer> arr,int m,int k){
        for(int i=Collections.min(arr);i<=Collections.max(arr);i++){
            if(possible(arr,m,k,i))
                return i;
        }

        return -1;
    }

    static int OptimalBloomDayMIN(ArrayList<Integer> arr,int m,int k){
        int low=Collections.min(arr),high=Collections.max(arr);
        int ans=-1;

        while(low<=high){
            int mid=(low+high)/2;
            if(possible(arr,m,k,mid)){
                ans=mid;
                high=mid-1;
            }
            else
                low=mid+1;
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int k=sc.nextInt();
        ArrayList<Integer> arr=new ArrayList<>();

        for(int i=0;i<n;i++)    arr.add(sc.nextInt());

        System.out.println(BruteBloomDayMIN(arr,m,k));
    }
}
