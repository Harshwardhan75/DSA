import java.util.*;

public class SlidingWindow_LongestSubstringWithatmostKdistinctcharacter {

    static int Brutelongeststring(String s,int k){
        int n=s.length();
        Map<Character,Integer> map=new HashMap<>();
        int max=0;            
        for(int i=0;i<n;i++){
            map.clear();
            for(int j=i;j<n;j++){
                char c=s.charAt(j);
                map.put(c,map.getOrDefault(c, 0)+1);
                if(map.size()<=k)
                    max=Math.max(max, j-i+1);
                else
                    break;
            }
        }

        return max;
    }

    static int Optimallongeststring1(String s,int k){
        int n=s.length();
        int l=0,r=0;
        int max=0;
        Map<Character,Integer> map=new HashMap<>();
        while(r<n){
            map.put(s.charAt(r),map.getOrDefault(s.charAt(r),0)+1);
            while(map.size()>k){
                map.put(s.charAt(l),map.get(s.charAt(l))-1);
                if(map.get(s.charAt(l))==0)
                    map.remove(s.charAt(l));
                l++;
            }

            if(map.size()<=k)
                max=Math.max(max,r-l+1);
            r++;
        }

        return max;
    }
    
    static int Optimallongeststring2(String s,int k){
        int n=s.length();
        int l=0,r=0;
        int max=0;
        Map<Character,Integer> map=new HashMap<>();
        while(r<n){
            map.put(s.charAt(r),map.getOrDefault(s.charAt(r),0)+1);
            if(map.size()>k){
                map.put(s.charAt(l),map.get(s.charAt(l))-1);
                if(map.get(s.charAt(l))==0)
                    map.remove(s.charAt(l));
                l++;
            }

            if(map.size()<=k)
                max=Math.max(max,r-l+1);
            r++;
        }

        return max;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.next();
        int k=sc.nextInt();

        System.out.println(Brutelongeststring(s,k));
        System.out.println(Optimallongeststring1(s,k));
        System.out.println(Optimallongeststring2(s,k));
    }
}
