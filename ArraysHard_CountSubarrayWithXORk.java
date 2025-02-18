import java.util.*;

public class ArraysHard_CountSubarrayWithXORk {

    static int BruteCountSubArrayWithxorK(ArrayList<Integer> arr,int x){
        int count=0;

        for(int i=0;i<arr.size();i++){
            for(int j=i;j<arr.size();j++){
                int xor=0;
                for(int k=i;k<=j;k++)
                    xor^=arr.get(k);
                if(xor==x)
                    count++;
            }
        }

        return count;
    }

    static int BetterCountSubArrayWithxorK(ArrayList<Integer> arr,int x){
        int count=0;

        for(int i=0;i<arr.size();i++){
            int xor=0;
            for(int j=i;j<arr.size();j++){
                xor^=arr.get(j);
                if(xor==x)
                    count++;
            }
        }

        return count;
    }

    static int OptimalCountSubArrayWithxorK(ArrayList<Integer> arr,int k){
        int count=0;
        HashMap<Integer,Integer> map=new HashMap<>();
        map.put(0,1);
        int prexor=0;
        for(int i=0;i<arr.size();i++){
            prexor^=arr.get(i);
            int remxor=prexor^k;
            count+=map.getOrDefault(remxor,0);
            map.put(prexor,map.getOrDefault(prexor, 0)+1);
        }

        return count;
    }


    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        ArrayList<Integer> arr=new ArrayList<>();
        for(int i=0;i<n;i++)    arr.add(sc.nextInt());
        int k=sc.nextInt();
        System.out.println(arr);

        System.out.println(OptimalCountSubArrayWithxorK(arr,k));
    }
}