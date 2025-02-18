import java.util.*;

public class ArraysMedium_TwoSum {

    static int[] BruteForce(ArrayList<Integer> arr,int target){
        for(int i=0;i<arr.size();i++){
            for(int j=i+1;j<arr.size();j++){
                if(arr.get(i)+arr.get(j)==target)
                    return new int[]{i,j};
            }
        }
        return new int[]{};
    }

    static int[] Better(ArrayList<Integer> arr,int target){
        Map<Integer,Integer> map=new HashMap<>();
        int [] result=new int[2];
        for(int i=0;i<arr.size();i++){
            int rem=target-arr.get(i);
            if(map.containsKey(rem)){
                result[0]=map.get(rem);
                result[1]=i;
                return result;
            }
            map.put(arr.get(i),i);
        }

        return new int[]{};
    }

    static int[] Optimal(ArrayList<Integer> arr,int target){
        Collections.sort(arr);
        int[] result=new int[2];

        int left=0,right=arr.size()-1;

        while(left<right){
            if(arr.get(left)+arr.get(right)==target){
                result[0]=left;
                result[1]=right;
                return result;
            }
            else if(arr.get(left)+arr.get(right)<target)
                left++;
            else right--;
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();

        ArrayList<Integer> arr=new ArrayList<>();

        for(int i=0;i<n;i++)    arr.add(sc.nextInt());
        int k=sc.nextInt();
        int[] x=Optimal(arr, k);
        for(int y:x)
            System.out.print(y+" ");
        
    }
}
