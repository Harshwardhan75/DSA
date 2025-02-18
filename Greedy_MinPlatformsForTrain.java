import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Greedy_MinPlatformsForTrain {

    static int BruteFindMinPlatforms(int[] arr,int[] dep){
        int n=arr.length;
        int maxcount=0;
        for(int i=0;i<n;i++){
            int count=1;
            for(int j=i+1;j<n;j++){
                if(arr[j]<=dep[i] && dep[j]>=arr[i])
                    count++;
                maxcount=Math.max(maxcount, count);
            }
        }

        return maxcount;
    }

    static class Pair{
        int time;
        String status;
        Pair(int t,String s){
            this.time=t;
            this.status=s;
        }
    }
    static int OptimalFindMinPlatforms1(int[] arr,int[] dep){
        ArrayList<Pair> time=new ArrayList<>();
        int n=arr.length;
        for(int i=0;i<n;i++){
            time.add(new Pair(arr[i],"A"));
            time.add(new Pair(dep[i],"D"));
        }

        Collections.sort(time,(a,b)->Integer.compare(a.time,b.time));

        int count=0;
        int maxcount=0;

        for(Pair p: time){
            if(p.status.equals("A"))
                count++;
            else    
                count--;
            maxcount=Math.max(maxcount, count);
        }

        return maxcount;
    }

    static int OptimalFindMinPlatforms2(int[] arr,int[] dep){
        int n=arr.length;
        int p1=0,p2=0;
        int count=0,maxcount=0;

        while(p1<n){
            if(arr[p1]<=dep[p2]){
                count++;
                p1++;
            }
            else{
                count--;
                p2++;
            }
            maxcount=Math.max(maxcount, count);
        }

        return maxcount;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];
        int[] dep=new int[n];

        for(int i=0;i<n;i++)
            arr[i]=sc.nextInt();

        for(int i=0;i<n;i++)
            dep[i]=sc.nextInt();
        
        System.out.println(BruteFindMinPlatforms(arr,dep));
        System.out.println(OptimalFindMinPlatforms1(arr,dep));
        System.out.println(OptimalFindMinPlatforms2(arr,dep));
    }
}
