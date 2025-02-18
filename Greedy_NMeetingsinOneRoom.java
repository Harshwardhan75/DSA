import java.util.*;

public class Greedy_NMeetingsinOneRoom {

    static int maxMeetings(int[] start,int[] end){
        ArrayList<int[]> arr=new ArrayList<>();
        int n=start.length;
        for(int i=0;i<n;i++)
        arr.add(new int[]{start[i],end[i]});
        
        Collections.sort(arr,(a,b)->Integer.compare(a[1],b[1]));
        
        int count=0;
        int freetime=arr.get(0)[1];
        for(int i=1;i<n;i++){
            if(arr.get(i)[0]>=freetime){
                freetime=arr.get(i)[1];
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] start=new int[n];
        int[] end=new int[n];

        for(int i=0;i<n;i++)
            start[i]=sc.nextInt();

        for(int i=0;i<n;i++)
            end[i]=sc.nextInt();
        
        System.out.println(maxMeetings(start,end));
    }
}
