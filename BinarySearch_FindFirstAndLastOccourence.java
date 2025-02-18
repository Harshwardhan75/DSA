import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class BinarySearch_FindFirstAndLastOccourence {

    static ArrayList<Integer> Brutefirstandlast(ArrayList<Integer> arr,int x){
        int first=-1,last=-1;

        for(int i=0;i<arr.size();i++){
            if(arr.get(i)==x){
                if(first==-1)
                    first=i;
                last=i;
            }
        }

        return new ArrayList<>(Arrays.asList(first,last));
    }

    static int lowerbound(ArrayList<Integer> arr,int x){
        int low=0,high=arr.size()-1;
        int result=arr.size();
        while(low<=high){
            int mid=(low+high)/2;
            if(arr.get(mid)>=x){
                result=mid;
                high=mid-1;
            }
            else
                low=mid+1;
        }
        return result;
    }

    static int upperbound(ArrayList<Integer> arr,int x){
        int low=0,high=arr.size()-1;
        int result=arr.size();
        while(low<=high){
            int mid=(low+high)/2;
            if(arr.get(mid)>x){
                result=mid;
                high=mid-1;
            }
            else
                low=mid+1;
        }
        return result;
    }
    
    static ArrayList<Integer> Betterfirstandlast(ArrayList<Integer> arr,int x){
        int lb=lowerbound(arr,x);
        if(lb==arr.size() || arr.get(lb)!=x)
            return new ArrayList<>(Arrays.asList(-1,-1));
        else
            return new ArrayList<>(Arrays.asList(lb,upperbound(arr,x)-1));
    }

    static ArrayList<Integer> Optimalfirstandlast(ArrayList<Integer> arr,int x){
        int low=0,high=arr.size()-1;
        int first=-1,last=-1;
        while(low<=high){
            int mid=(low+high)/2;
            if(arr.get(mid)==x){
                first=mid;
                high=mid-1;
            }
            else if(arr.get(mid)<x)
                low=mid+1;
            else
                high=mid-1;
        }

        low=0;high=arr.size()-1;


        while(low<=high){
            int mid=(low+high)/2;
            if(arr.get(mid)==x){
                last=mid;
                low=mid+1;
            }
            else if(arr.get(mid)<x)
                low=mid+1;
            else
                high=mid-1;
        }

        return new ArrayList<>(Arrays.asList(first,last));
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        ArrayList<Integer> arr=new ArrayList<>();
        for(int i=0;i<n;i++)    arr.add(sc.nextInt());
        int x=sc.nextInt();

        System.out.println(Optimalfirstandlast(arr,x));
    }
}