import java.util.Scanner;

public class SlidingWindow_SubstringContainingAllThreeCharacters {

    static int BruteAllThree1(String s){
        int n=s.length();
        int count=0;
        for(int i=0;i<n;i++){
            int[] hash=new int[3];
            for(int j=i;j<n;j++){
                hash[s.charAt(j)-'a']=1;
                if(hash[0]+hash[1]+hash[2]==3)
                    count++;
            }
        }

        return count;
    }
    static int BruteAllThree2(String s){
        int n=s.length();
        int count=0;
        for(int i=0;i<n;i++){
            int[] hash=new int[3];
            for(int j=i;j<n;j++){
                hash[s.charAt(j)-'a']=1;
                if(hash[0]+hash[1]+hash[2]==3){
                    count+=n-j;
                    break;
                }
            }
        }

        return count;
    }

    static int OptimalAllThree1(String s){
        int n=s.length();
        int count=0;
        int[] hash=new int[3];
        hash[0]=hash[1]=hash[2]=-1;
        int r=0;
        while(r<n){
            hash[s.charAt(r)-'a']=r;
            //if can be eliminated
            if(hash[0]!=-1 && hash[1]!=-1 && hash[2]!=-1)
                count+=Math.min(hash[0],Math.min(hash[1],hash[2]))+1;
            r++;
        }

        return count;
    }
    
    static int OptimalAllThree2(String s){
        int n=s.length();
        int count=0;
        int[] hash=new int[3];
        int r=0,l=0;
        while(r<n){
            hash[s.charAt(r)-'a']++;
            while(hash[0]>0 && hash[1]>0 && hash[2]>0){
                hash[s.charAt(l)-'a']--;
                l++;
            }
            count+=r-l+1;
            r++;
        }


        return (n*(n+1)/2)-count;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.next();

        System.out.println(OptimalAllThree2(s));
    }
}
