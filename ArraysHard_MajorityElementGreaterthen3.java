import java.util.*;

public class ArraysHard_MajorityElementGreaterthen3 {

    static ArrayList<Integer> BruteMajorityElement(ArrayList<Integer> arr){
        ArrayList<Integer> result=new ArrayList<>();

        for(int i=0;i<arr.size();i++){
            int count=0;
            for(int j=i;j<arr.size();j++){
                if(arr.get(i)==arr.get(j))
                    count++;
            }
            if(count>arr.size()/3)
                result.add(arr.get(i));
        }

        return result;
    }

    //2 Pass Better Solution
    static ArrayList<Integer> BetterMajorityElement(ArrayList<Integer> arr){
        ArrayList<Integer> result=new ArrayList<>();
        
        Map<Integer,Integer> map=new HashMap<>();

        for(int i=0;i<arr.size();i++){
            map.put(arr.get(i),map.getOrDefault(arr.get(i),0)+1);
        }

        for(int key: map.keySet())
            if(map.get(key)>arr.size()/3)
                result.add(key);

        return result;
    }

    //1 Pass Better solution
    static ArrayList<Integer> Better2MajorityElement(ArrayList<Integer> arr){
        ArrayList<Integer> result=new ArrayList<>();
        int count=0;
        Map<Integer,Integer> map=new HashMap<>();
        int min=(arr.size()/3)+1;
        for(int var: arr){
            count++;
            map.put(var,map.getOrDefault(var, 0)+1);
            if(map.get(var)==min)
                result.add(var);
            
            if(result.size()==2)
                break;
        }
        System.out.println(count);
        return result;
    }

    static ArrayList<Integer> OptimalMajorityElement(ArrayList<Integer> arr){
        int count1=0,count2=0,el1=Integer.MIN_VALUE,el2=Integer.MIN_VALUE;

        ArrayList<Integer> result=new ArrayList<>();

        for(int var: arr){
            if(count1==0 && var!=el2){
                count1=1;
                el1=var;
            }
            else if(count2==0 && var!=el1){
                count2=1;
                el2=var;
            }
            else if(var==el1)
                count1++;
            else if(var==el2)
                count2++;
            else{
                count1--;
                count2--;
            }
        }

        count1=count2=0;

        for(int x: arr){
            if(x==el1)
                count1++;
            if(x==el2)
                count2++;
        }

        if(count1>arr.size()/3)
            result.add(el1);
        if(count2>arr.size()/3)
            result.add(el2);

        return result;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        ArrayList<Integer> arr=new ArrayList<>();

        for(int i=0;i<n;i++)    arr.add(sc.nextInt());

        System.out.println(arr);

        ArrayList<Integer> result=OptimalMajorityElement(arr);
        System.out.println(result);
    }
}
