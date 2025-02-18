import java.util.ArrayList;
import java.util.Scanner;

public class BinarySearch_RowWithMaximum1s {

    static int BruteFindMax1(ArrayList<ArrayList<Integer>> matrix,int n,int m){
        int max=0;
        int index=-1;

        for(int i=0;i<n;i++){
            int count=0;
            for(int j=0;j<m;j++)
                count+=matrix.get(i).get(j);
            
            if(count>max){
                max=count;
                index=i;
            }
        }
        return index;
    }

    static int firstoccurence(ArrayList<Integer> arr,int n){
        int low=0,high=n-1;

        while(low<=high){
            int mid=(low+high)/2;
            if(arr.get(mid)>=1)
                high=mid-1;
            else
                low=mid+1;
        }
        return low;
    }

    static int OptimalFindMax1(ArrayList<ArrayList<Integer>> matrix,int n,int m){
        int max=0,index=-1;

        for(int i=0;i<n;i++){
            int first=firstoccurence(matrix.get(i),m);
            int count=m-first;
            if(count>max){
                max=count;
                index=i;
            }
        }

        return index;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();

        ArrayList<ArrayList<Integer>> matrix=new ArrayList<>();
        
        for(int i=0;i<n;i++){
            ArrayList<Integer> arr=new ArrayList<>();
            for(int j=0;j<m;j++)
                arr.add(sc.nextInt());
            matrix.add(arr);
        }

        System.out.println(OptimalFindMax1(matrix,n,m));
    }
}