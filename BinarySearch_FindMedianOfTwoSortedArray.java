import java.util.Scanner;

public class BinarySearch_FindMedianOfTwoSortedArray {

    static double BruteMedian(int[] a,int[] b){
        int n=a.length;
        int m=b.length;
        
        int[] c=new int[n+m];

        int i=0,j=0,k=0;

        while(i<n && j<m){
            if(a[i]<b[j])
                c[k++]=a[i++];
            else
                c[k++]=b[j++];
        }

        while(i<n)  c[k++]=a[i++];
        while(j<m)  c[k++]=b[j++];

        if(c.length%2==1)   
            return (double)c[c.length/2];
        else 
            return (double)(c[(c.length/2)-1]+c[c.length/2])/2.0;
    }

    static double BetterMedian(int[] a,int[] b){
        int n=a.length;
        int m=b.length;
        int cnt=0;
        int x=n+m;
        int ind1=x/2-1;
        int ind2=x/2;
        int ele1=-1,ele2=-1;

        int i=0,j=0;

        while(i<n && j<m){
            if(a[i]<b[j]){
                if(cnt==ind1)   ele1=a[i];
                if(cnt==ind2)   ele2=a[i];
                i++;cnt++;
            }
            else{
                if(cnt==ind1)   ele1=b[j];
                if(cnt==ind2)   ele2=b[j];
                j++;cnt++;
            }
        }

        while(i<n){
            if(cnt==ind1)   ele1=a[i];
            if(cnt==ind2)   ele2=a[i];
            i++;cnt++;
        }

        while(j<m){
            if(cnt==ind1)   ele1=b[j];
            if(cnt==ind2)   ele2=b[j];
            j++;cnt++;
        }

        if(x%2==1)
            return (double)ele2;
        else
            return (double)(ele1+ele2)/2.0;
    }

    static double OptimalMedian(int[] a,int[] b){
        int n=a.length;
        int m=b.length;
        if(n>m) return OptimalMedian(b, a);

        int low=0,high=n;
        int left=(n+m+1)/2;
        while(low<=high){
            int mid1=(low+high)/2;
            int mid2=left-mid1;
            int l1=Integer.MIN_VALUE;
            int l2=Integer.MIN_VALUE;
            int r1=Integer.MAX_VALUE;
            int r2=Integer.MAX_VALUE;
            if(mid1-1>=0)   l1=a[mid1-1];
            if(mid2-1>=0)   l2=b[mid2-1];
            if(mid1<n)  r1=a[mid1];
            if(mid2<m)  r2=b[mid2];

            if(l1<r2 && l2<r1){
                if((n+m)%2==1)
                    return (double)Math.max(l1, l2);
                else
                    return (double)(Math.max(l1, l2)+Math.min(r1, r2))/2.0;
            }
            else if(l1>r2){
                high=mid1-1;
            }
            else
                low=mid1+1;
        }

        return 0.0;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int[] arr1=new int[n];
        int[] arr2=new int[m];
        for(int i=0;i<n;i++)    arr1[i]=sc.nextInt();
        for(int i=0;i<m;i++)    arr2[i]=sc.nextInt();
        System.out.println(OptimalMedian(arr1,arr2));
    }
}