import java.util.*;

public class SlidingWindow_FruitsIntoBaskets {

    static int BruteFruitinBasket(int[] arr){
        int n=arr.length;

        int max=0;
        for(int i=0;i<n;i++){
            Set<Integer> set=new HashSet<>();
            for(int j=i;j<n;j++){
                set.add(arr[j]);
                if(set.size()<=2)
                    max=Math.max(max,j-i+1);
                else
                    break;
            }
        }

        return max;
    }

    static int OptimalFruitinBasket1(int[] arr){
        int n=arr.length;
        int max=0;
        Map<Integer,Integer> map=new HashMap<>();
        int l=0,r=0;

        while(r<n){
            map.put(arr[r],map.getOrDefault(arr[r],0)+1);
            while(map.size()>2){
                map.put(arr[l],map.get(arr[l])-1);
                if(map.get(arr[l])==0)
                    map.remove(arr[l]);
                l++;
            }

            max=Math.max(max,r-l+1);
            r++;
        }

        return max;

    }
    
    static int OptimalFruitinBasket2(int[] arr){
        int n=arr.length;
        int max=0;
        Map<Integer,Integer> map=new HashMap<>();
        int l=0,r=0;

        while(r<n){
            map.put(arr[r],map.getOrDefault(arr[r],0)+1);
            if(map.size()>2){
                map.put(arr[l],map.get(arr[l])-1);
                if(map.get(arr[l])==0)
                    map.remove(arr[l]);
                l++;
            }
            if(map.size()<=2)
                max=Math.max(max,r-l+1);
            r++;
        }

        return max;

    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];

        for(int i=0;i<n;i++)
            arr[i]=sc.nextInt();
        
        System.out.println(OptimalFruitinBasket2(arr));
    }
}
