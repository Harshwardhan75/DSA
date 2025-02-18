import java.util.Scanner;

public class SlidingWindowMinimumWindowSubstring {

    static String BruteMinSubstring(String s,String t){
        int minlength=Integer.MAX_VALUE;
        int sindex=-1;
        
        for(int i=0;i<s.length();i++){
            int[] hash=new int[256];
            for(int j=0;j<t.length();j++)
                hash[t.charAt(j)]++;
            int count=0;
            int m=t.length();

            for(int j=i;j<s.length();j++){
                if(hash[s.charAt(j)]>0)
                    count++;
                
                hash[s.charAt(j)]--;
                if(count==m){
                    if(j-i+1<minlength){
                        minlength=Math.min(minlength,j-i+1);
                        sindex=i;
                        break;
                    }
                }
            }
        }

        return sindex==-1?"":s.substring(sindex,sindex+minlength);
    }

    static String OptimalMinSubstring(String s,String t){
        int[] hash=new int[256];
        for(int i=0;i<t.length();i++)
            hash[t.charAt(i)]++;
        int m=t.length();
        int left=0,right=0;
        int sindex=-1, minlength=Integer.MAX_VALUE;
        int n=s.length();
        int count=0;
        while(right<n){
            if(hash[s.charAt(right)]>0)
                count++;
            hash[s.charAt(right)]--;

            while(count==m && left<=right){
                if(right-left+1<minlength){
                    sindex=left;
                    minlength=right-left+1;
                }
                hash[s.charAt(left)]++;
                if(hash[s.charAt(left)]>0)
                    count--;
                
                left++;
            }
            right++;
        }

        return sindex==-1?"":s.substring(sindex,sindex+minlength);
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.next();
        String t=sc.next();
        System.out.println(BruteMinSubstring(s,t));
        System.out.println(OptimalMinSubstring(s,t));
    }
}
