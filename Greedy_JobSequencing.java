import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Greedy_JobSequencing {
    static class Job{
        int id;
        int deadline;
        int profit;
        Job(int id,int deadline,int profit){
            this.id=id;
            this.profit=profit;
            this.deadline=deadline;
        }
    }

    static ArrayList<Integer> FindMinJobs(Job[] jobs){
        int n=jobs.length;

        Arrays.sort(jobs,(a,b)->Integer.compare(b.profit, a.profit));
        int maxdeadline=-1;

        for(int i=0;i<n;i++)
            maxdeadline=Math.max(maxdeadline, jobs[i].deadline);
        
        int[] days=new int[maxdeadline+1];
        int totalprofit=0;
        int count=0;
        for(int i=0;i<n;i++){
            Job jb=jobs[i];
            for(int j=jb.deadline;j>=1;j--){
                if(days[j]==0){
                    days[j]=jb.id;
                    totalprofit+=jb.profit;
                    count++;
                    break;
                }
            }
        }

        return new ArrayList<>(Arrays.asList(count,totalprofit));
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        Job[] jobs=new Job[n];

        for(int i=0;i<n;i++)
            jobs[i]=new Job(sc.nextInt(),sc.nextInt(),sc.nextInt());
        
        System.out.println(FindMinJobs(jobs));
    }
}
