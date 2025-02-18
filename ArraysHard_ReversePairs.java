import java.util.ArrayList;
import java.util.Scanner;

public class ArraysHard_ReversePairs {

    static int BruteReversePairs(ArrayList<Integer> arr){
        int count=0;

        for(int i=0;i<arr.size()-1;i++){
            for(int j=0;j<arr.size();j++){
                if(arr.get(i)>2*arr.get(j))
                    count++;
            }
        }
        return count;
    }

    //Optimal using merge sort


    static void merge(ArrayList<Integer> arr,int low,int mid,int high){
        int i=low,j=mid+1;

        ArrayList<Integer> temp=new ArrayList<>();
        while(i<=mid && j<=high){
            if(arr.get(i)<arr.get(j))
                temp.add(arr.get(i++));
            else
                temp.add(arr.get(j++));
        }

        while(i<=mid)   temp.add(arr.get(i++));
        while(j<=high)   temp.add(arr.get(j++));

        for(i=low;i<=high;i++)
            arr.set(i,temp.get(i-low));
    }

    static int countPairs(ArrayList<Integer> arr,int low,int mid,int high){
        int count=0;
        int left=low;
        int right=mid+1;

        while(left<=mid){
            while(right<=high && arr.get(left)>2*arr.get(right))
                right++;
            count+=right-(mid+1);
            left++;
        }

        return count;
    }

    static int mergesort(ArrayList<Integer> arr,int low,int high){
        int count=0;
        if(low>=high)   return count;

        int mid=(high+low)/2;
        count+=mergesort(arr, low, mid);
        count+=mergesort(arr, mid+1, high);
        count+=countPairs(arr,low,mid,high);
        merge(arr,low,mid,high);
        return count;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        ArrayList<Integer> arr=new ArrayList<>();

        for(int i=0;i<n;i++)
            arr.add(sc.nextInt());

        System.out.println(mergesort(arr,0,n-1));
    }   
}