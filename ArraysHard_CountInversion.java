import java.util.*;

public class ArraysHard_CountInversion {

    static int BruteCountInversion(int[] arr){
        int count=0;

        for(int i=0;i<arr.length-1;i++){
            for(int j=i+1;j<arr.length;j++){
                if(arr[i]>arr[j])
                    count++;
            }
        }

        return count;
    }


    //Optimal
    static int mergesort(int[] arr,int low,int high){
        int count=0;
        if(low>=high)
        return count;
        
        int mid=low+(high-low)/2;
        count+=mergesort(arr,low,mid);
        count+=mergesort(arr,mid+1,high);
        count+=merge(arr,low,mid,high);

        return count;
    }

    static int merge(int[] arr,int low,int mid,int high){
        int count=0;
        int i=low,j=mid+1;
        ArrayList<Integer> temp=new ArrayList<>();

        while(i<=mid && j<=high){
            if(arr[i]<=arr[j]){
                temp.add(arr[i]);i++;}
            else{
                count+=mid-i+1;
                temp.add(arr[j]);
                j++;
            }
        }

        while(i<=mid)   temp.add(arr[i++]);
        while(j<=high)  temp.add(arr[j++]);

        for(i=low;i<=high;i++)
            arr[i]=temp.get(i-low);
        
        return count;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++)    arr[i]=sc.nextInt();

        System.out.println(mergesort(arr,0,n-1));
    }
}