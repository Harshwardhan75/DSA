import java.util.*;

public class SlidingWindow_LongestRepeatingCharacterReplacement {

    static int BruteLongestRepeating(String s,int k){
        int max=0;
        int n=s.length();

        for(int i=0;i<n;i++){
            int[] hash=new int[26];
            int maxf=0;
            for(int j=i;j<n;j++){
                hash[s.charAt(j)-'A']++;
                maxf=Math.max(maxf,hash[s.charAt(j)-'A']);
                int changes=(j-i+1)-maxf;
                if(changes<=k)
                    max=Math.max(max, j-i+1);
                else
                    break;
            }
        }

        return max;
    }


    static int OptimalLongestRepeating1(String s,int k){
        int n=s.length();
        int l=0,r=0,max=0,maxf=0;
        int[] hash=new int[26];

        while(r<n){
            hash[s.charAt(r)-'A']++;
            maxf=Math.max(maxf,hash[s.charAt(r)-'A']);
            int changes=(r-l+1)-maxf;

            while(changes>k){
                hash[s.charAt(l)-'A']--;
                for(int i=0;i<26;i++)
                    maxf=Math.max(maxf, hash[i]);
                l++;
                changes=r-l+1-maxf;
            }

            if(changes<=k)
                max=Math.max(max,r-l+1);
            r++;
        }

        return max;
    }
    
    static int OptimalLongestRepeating2(String s,int k){
        int n=s.length();
        int l=0,r=0,max=0,maxf=0;
        int[] hash=new int[26];

        while(r<n){
            hash[s.charAt(r)-'A']++;
            maxf=Math.max(maxf,hash[s.charAt(r)-'A']);
            int changes=(r-l+1)-maxf;

            if(changes>k){
                hash[s.charAt(l)-'A']--;
                l++;
                changes=r-l+1-maxf;
            }

            if(changes<=k)
                max=Math.max(max,r-l+1);
            r++;
        }

        return max;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.next();
        int k=sc.nextInt();
        
        System.out.println(BruteLongestRepeating(s,k));
        System.out.println(OptimalLongestRepeating1(s,k));
        System.out.println(OptimalLongestRepeating2(s,k));
    }
}
