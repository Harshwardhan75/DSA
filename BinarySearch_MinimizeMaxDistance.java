import java.util.*;
public class BinarySearch_MinimizeMaxDistance {

    static double BruteMinofMaxDistance(int[] arr,int station){
        int n=arr.length;
        int[] section_between=new int[n-1];

        for(int gasStation=1;gasStation<=station;gasStation++){
            double maxDifference=-1.0;
            int index=-1;
            for(int i=0;i<n-1;i++){
                double diff=(double)(arr[i+1]-arr[i])/(section_between[i]+1);
                if(diff>maxDifference){
                    maxDifference=diff;
                    index=i;
                }
            }
            section_between[index]++;
        }

        double result=Integer.MIN_VALUE;
        for(int i=0;i<section_between.length;i++){
            result=Math.max(result, (double)(arr[i+1]-arr[i])/(section_between[i]+1));
        }
        return result;
    }

    public static class Pair{
        double difference;
        int index;
    
        Pair(double diff,int index){
            this.difference=diff;
            this.index=index;
        }
    }

    static double BetterMinofMaxDistance(int[] arr,int station){
        int n=arr.length;
        int[] section_between=new int[n-1];
        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->Double.compare(b.difference,a.difference));

        for(int i=0;i<n-1;i++){
            Pair newpair=new Pair((double)(arr[i+1]-arr[i]), i);
            pq.add(newpair);
        }

        for(int gasStation=1;gasStation<=station;gasStation++){
            Pair temp=pq.poll();
            int index=temp.index;
            section_between[index]++;
            double newdifference=(double)(arr[index+1]-arr[index])/(section_between[index]+1);
            // System.out.println(newdifference);
            Pair newPair=new Pair(newdifference, index);
            pq.add(newPair);
        }

        return pq.peek().difference;
    }

    static int noOfStationPlaced(int[] arr,double dist){
        int count=0;
        for(int i=0;i<arr.length-1;i++){
            int placed=(int)((arr[i+1]-arr[i])/dist);
            if(placed*dist==(arr[i+1]-arr[i])/dist)
                placed--;
            count+=placed;
        }
        return count;
    }

    static double OptimalMinofMaxDistance(int[] arr,int station){
        double low=0,high=Integer.MIN_VALUE;

        for(int i=0;i<arr.length-1;i++)
            high=Math.max(high, arr[i+1]-arr[i]);

        while(high-low>1e-6){
            double mid=(low+high)/2;
            int placedstation=noOfStationPlaced(arr,mid);
            if(placedstation<=station)
                high=mid;
            else
                low=mid;
        }

        return Math.round(high*1e6)/1e6;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int gasStation=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++)    arr[i]=sc.nextInt();

        System.out.println(OptimalMinofMaxDistance(arr,gasStation));
    }
}