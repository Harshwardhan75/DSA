import java.util.*;

public class Greedy_FractionalKnapsack {

    static double ComparatorFK(ArrayList<int[]> arr,int capacity){
        Collections.sort(arr,new Comparator<int[]>(){
            public int compare(int[] a,int[] b){
                double bx=(double)b[0]/b[1];
                double ax=(double)a[0]/a[1];
                return Double.compare(bx, ax);
            }
        });
        double total=0;
        for(int i=0;i<arr.size();i++){
            if(arr.get(i)[1]<=capacity){
                capacity-=arr.get(i)[1];
                total+=arr.get(i)[0];
            }
            else{
                total+=((double)arr.get(i)[0]/arr.get(i)[1])*capacity;
                capacity=0;
                break;
            }
        }

        return total;
    }

    static class Pair{
        int value;
        int weight;
        double fraction;
        Pair(int v,int w){
            value=v;
            weight=w;
            fraction=(double)v/w; 
        }
    }

    static double PriorityQueueFK(ArrayList<int[]> arr,int capacity){
        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->Double.compare(b.fraction, a.fraction));
        for(int[] i: arr)
            pq.offer(new Pair(i[0],i[1]));
        
        double total=0;
        while(!pq.isEmpty()){
            Pair p=pq.poll();

            if(p.weight<=capacity){
                total+=p.value;
                capacity-=p.weight;
            }
            else{
                total+=p.fraction*capacity;
                capacity=0;
                break;
            }
        }        

        return total;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int capacity=sc.nextInt();
        ArrayList<int[]> arr=new ArrayList<>();
        for(int i=0;i<n;i++){
            arr.add(new int[]{sc.nextInt(),sc.nextInt()});
        }

        System.out.println(ComparatorFK(arr,capacity));
        System.out.println(PriorityQueueFK(arr,capacity));
    }
}
