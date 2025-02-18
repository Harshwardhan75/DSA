import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class BinarySearch_KokoEatingBananas {

    static int Possible(ArrayList<Integer> arr,int day){
        int totalhr=0;

        for(int i: arr){
            totalhr+=Math.ceil((double)(i)/(double)day);
        }

        return totalhr;
    }

    static int BruteEatingBananas(ArrayList<Integer> arr,int h){
        int max=Collections.max(arr);
        int ans=-1;
        for(int i=1;i<=max;i++){
            if(Possible(arr,i)<=h)
                return i;
        }
        return -1;
    }

    static int OptimalEatingBananas(ArrayList<Integer> arr,int h){
        int low=1,high=Collections.max(arr);
        int ans=-1;
        while(low<=high){
            int mid=(low+high)/2;
            int x=Possible(arr, mid);
            if(x<=h){
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
        int h=sc.nextInt();
        ArrayList<Integer> arr=new ArrayList<>();

        for(int i=0;i<n;i++)    arr.add(sc.nextInt());

        System.out.println(OptimalEatingBananas(arr,h));
    }
}