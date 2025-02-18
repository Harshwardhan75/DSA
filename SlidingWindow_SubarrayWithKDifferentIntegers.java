import java.util.*;
public class SlidingWindow_SubarrayWithKDifferentIntegers {

    static int BruteKDifferentIntegers(int[] arr,int k){
        int count=0;
        Map<Integer,Integer> map=new HashMap<>();
        int n=arr.length;

        for(int i=0;i<n;i++){
            map.clear();
            for(int j=i;j<n;j++){
                map.put(arr[j],map.getOrDefault(arr[j], 0)+1);
                if(map.size()==k)
                    count++;
                else
                if(map.size()>k)
                    break;
            }
        }

        return count;
    }

    static int OptimalKDifferentIntegers(int[] arr,int k){
        return smallerequal(arr,k)-smallerequal(arr,k-1);
    }

    static int smallerequal(int[] arr,int k){
        int l=0,r=0,count=0;
        Map<Integer,Integer> map=new HashMap<>();
        int n=arr.length;

        while(r<n){
            map.put(arr[r], map.getOrDefault(arr[r], 0)+1);

            while(l<r && map.size()>k){
                map.put(arr[l],map.get(arr[l])-1);
                if(map.get(arr[l])==0)
                    map.remove(arr[l]);
                l++;
            }

            count+=r-l+1;
            r++;
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int k=sc.nextInt();

        int[] arr=new int[n];

        for(int i=0;i<n;i++)
            arr[i]=sc.nextInt();

        System.out.println(BruteKDifferentIntegers(arr,k));
        System.out.println(OptimalKDifferentIntegers(arr,k));
    }
}
