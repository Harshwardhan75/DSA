import java.util.*;

public class ArraysHard_FindMissingAndRepeatingNumber {

    static ArrayList<Integer> BruteMissingandRepeating(ArrayList<Integer> arr,int n){
        int repeat=-1,missing=-1;
        ArrayList<Integer> result=new ArrayList<>();

        for(int i=1;i<=n;i++){
            int count=0;
            for(int j=0;j<n;j++){
                if(arr.get(j)==i)
                    count++;
            }
            if(count==2)    repeat=i;
            else if(count==0)   missing=i;

            if(repeat!=-1 && missing!=-1)   break;
        }

        result.add(repeat);
        result.add(missing);

        return result;
    }

    static ArrayList<Integer> BetterMissingandRepeating(ArrayList<Integer> arr,int n){
        int[] hash=new int[n+1];
        int repeat=-1,missing=-1;
        for(int i=0;i<n;i++)
            hash[arr.get(i)]++;
        
        for(int i=1;i<hash.length;i++){
            if(hash[i]==2)  repeat=i;
            else if(hash[i]==0) missing=i;

            if(repeat!=-1 && missing!=-1)
                break;
        }

        return new ArrayList<>(Arrays.asList(repeat,missing));
    }

    static ArrayList<Integer> Optimal1MissingandRepeating(ArrayList<Integer> arr,int N){
        long n=N;
        long s1=0,s2=0;

        for(int i=0;i<N;i++){
            s1+=(long)arr.get(i);
            s2+=(long)arr.get(i)*(long)arr.get(i);
        }

        long s1n=(n*(n+1))/2;
        long s2n=(n*(n+1)*(2*n+1))/6;

        long val1=s1-s1n;
        long val2=s2-s2n;
        val2=val2/val1;

        long x=(val1+val2)/2;
        long y=x-val1;

        return new ArrayList<>(Arrays.asList((int)x,(int)y));
    }

    static ArrayList<Integer> Optimal2MissingandRepeating(ArrayList<Integer> arr,int n){
        int xor=0;

        for(int i=0;i<n;i++){
            xor^=arr.get(i);
            xor^=(i+1);
        }

        int bitno=0;
        while(true){
            if((xor & (1<<bitno)) !=0)
                break;
            bitno++;
        }
        int one=0,zero=0;
        for(int i=0;i<n;i++){
            if((arr.get(i) & (1<<bitno))!=0)
                one^=arr.get(i);
            else
                zero^=arr.get(i);
        }

        for(int i=1;i<=n;i++){
            if((i & (1<<bitno))!=0)
                one^=i;
            else
                zero^=i;
        }

        int count=0;

        for(int i=0;i<n;i++)
            if(arr.get(i)==one)
                count++;
        
        if(count==2)
            return new ArrayList<>(Arrays.asList(one,zero));
        else
            return new ArrayList<>(Arrays.asList(zero,one));
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        ArrayList<Integer> arr=new ArrayList<>();

        for(int i=0;i<n;i++)    arr.add(sc.nextInt());

        System.out.println(arr);

        System.out.println(Optimal2MissingandRepeating(arr,n));
    }
}
