import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class BinarySearch_LeastCapacityToShiftPackages {

    static int requireddays(ArrayList<Integer> weights,int capacity){
        int load=0,day=1;

        for(int i=0;i<weights.size();i++){
            if(load+weights.get(i)>capacity){
                day++;
                load=weights.get(i);
            }
            else
                load+=weights.get(i);
        }

        return day;
    }

    static int BruteMinDaysToShift(ArrayList<Integer> weights,int days){
        int mincap=Collections.max(weights);
        int maxcap=0;
        for(int i=0;i<weights.size();i++)   
            maxcap+=weights.get(i);

        for(int i=mincap;i<=maxcap;i++){
            int reqdays=requireddays(weights,i);
            if(reqdays<=days)
                return i;
        }

        return maxcap;
    }

    static int OptimalMinDaysToShift(ArrayList<Integer> weights,int days){
        int mincap=Collections.max(weights);
        int maxcap=0;
        for(int i=0;i<weights.size();i++)   
            maxcap+=weights.get(i);
        int result=maxcap;
        int low=mincap,high=maxcap;
        while(low<=high){
            int mid=(low+high)/2;
            int reqday=requireddays(weights, mid);
            if(reqday<=days){
                result=mid;
                high=mid-1;
            }
            else
                low=mid+1;
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        ArrayList<Integer> arr=new ArrayList<>();
        int n=sc.nextInt();
        int days=sc.nextInt();
        for(int i=0;i<n;i++)    arr.add(sc.nextInt());

        System.out.println(OptimalMinDaysToShift(arr,days));
    }
}
