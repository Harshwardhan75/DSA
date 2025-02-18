import java.util.Scanner;

public class Greedy_Candy {

    static int BruteFindMaxCandy(int[] ratings){
        int n=ratings.length;
        int[] left=new int[n];
        int[] right=new int[n];
        left[0]=right[n-1]=1;

        for(int i=1;i<n;i++){
            if(ratings[i]>ratings[i-1])
                left[i]=left[i-1]+1;
            else
                left[i]=1;
        }
        
        for(int i=n-2;i>=0;i--){
            if(ratings[i]>ratings[i+1])
                right[i]=right[i+1]+1;
            else
                right[i]=1;
        }

        int sum=0;
        for(int i=0;i<n;i++)
            sum+=Math.max(left[i], right[i]);
        
        return sum;
    }

    static int OptimalFindMaxCandy1(int[] ratings){
        int n=ratings.length;
        int[] left=new int[n];
        left[0]=1;

        for(int i=1;i<n;i++){
            if(ratings[i]>ratings[i-1])
                left[i]=left[i-1]+1;
            else
                left[i]=1;
        }
        int right=1,sum=Math.max(left[n-1],right);

        for(int i=n-2;i>=0;i--){
            right=ratings[i]>ratings[i+1]?right+1:1;
            sum+=Math.max(left[i], right);    
        }
        
        return sum;
    }

    static int OptimalFindMaxCandy2(int[] ratings){
        int sum=1;
        int i=1;
        int n=ratings.length;
        while(i<n){
            if(ratings[i]==ratings[i-1]){
                sum++;
                i++;
                continue;
            }

            int peak=1;
            while(i<n && ratings[i]>ratings[i-1])
            {
                peak++;
                sum+=peak;
                i++;
            }

            int down=1;
            while(i<n && ratings[i]<ratings[i-1]){
                sum+=down;
                down++;
                i++;
            }

            if(down>peak)   sum+=down-peak;
        }

        return sum;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];

        for(int i=0;i<n;i++)
            arr[i]=sc.nextInt();
        
        System.out.println(BruteFindMaxCandy(arr));
        System.out.println(OptimalFindMaxCandy1(arr));
        System.out.println(OptimalFindMaxCandy2(arr));
    }    
}
