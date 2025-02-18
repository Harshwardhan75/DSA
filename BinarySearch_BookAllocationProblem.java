import java.util.Arrays;
import java.util.Scanner;

public class BinarySearch_BookAllocationProblem {

    static int findStudents(int arr[],int maxpages){
        int studentcount=1;
        int studentpage=0;
        for(int i=0;i<arr.length;i++){
            if(studentpage+arr[i]<=maxpages)
                studentpage+=arr[i];
            else{
                studentcount++;
                studentpage=arr[i];
            }
        }

        return studentcount;
    }

    static int BrutefindPages(int[] arr,int books,int students){
        if(books<students)  return -1;
        int min=Arrays.stream(arr).min().orElseThrow();
        int sum=Arrays.stream(arr).sum();
        
        for(int i=min;i<=sum;i++){
            if(findStudents(arr,i)==students)
                return i;
        }
        
        return -1;
    }

    static int OptimalfindPages(int []arr,int books,int students){
        if(books<students)  return -1;

        int low=Arrays.stream(arr).min().orElseThrow();
        int high=Arrays.stream(arr).sum();
        int ans=-1;
        // while(low<=high){
        //     int mid=(low+high)/2;
        //     int x=findStudents(arr, mid);
        //     if(x==students){
        //         ans=mid;
        //         high=mid-1;
        //     }
        //     else if(x<students)
        //         high=mid-1;
        //     else
        //         low=mid+1;
        // }
        
        while(low<=high){
            int mid=(low+high)/2;
            int x=findStudents(arr, mid);
            if(x<=students){
                ans=mid;
                high=mid-1;
            }
            else
                low=mid+1;
        }
        return low; //or ans (opposite polarity concept)
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++)    arr[i]=sc.nextInt();

        System.out.println(OptimalfindPages(arr,n,m));
    }
}