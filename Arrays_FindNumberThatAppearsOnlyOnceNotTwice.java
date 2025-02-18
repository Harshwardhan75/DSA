import java.util.*;

public class Arrays_FindNumberThatAppearsOnlyOnceNotTwice {

    static int OnceAppearence(ArrayList<Integer> arr){
        /*BRUTEFORCE APPROACH
        int count=0;
        for(int i=0;i<arr.size();i++){
            count=0;
            for(int j=0;j<arr.size();j++)
                if(arr.get(j)==arr.get(i))
                    count++;
            if(count==1)
                return arr.get(i);
        }
        return Integer.MIN_VALUE;
        */
        
        /*BETTER APPROACH && FOR ONLY POSITIVE INTEGER YOU CAN USE HASHSET

        Map<Integer,Integer> map=new TreeMap<>();
        for(int i=0;i<arr.size();i++){
            if(!map.containsKey(arr.get(i)))
                map.put(arr.get(i), 1);
            else
                map.put(arr.get(i),map.get(arr.get(i))+1);
        }
        for(int var: map.keySet())
            if(map.get(var)==1)
                return var;
        return -1;
        */

        //OPTIMAL APPROACH USING XOR
        int xor=0;
        for(int var: arr) xor^=var;
        return xor;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        ArrayList<Integer> arr=new ArrayList<>();
        for(int i=0;i<n;i++)    arr.add(sc.nextInt());

        System.out.println("The Number that appears Once: "+OnceAppearence(arr));
    }
}
