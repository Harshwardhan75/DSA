import java.util.*;

public class Graph_TOPOSORTAlienDictionary {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int k=sc.nextInt();

        String[] dict=new String[n];

        for(int i=0;i<n;i++)
            dict[i]=sc.next();
        
        System.out.println(AlienDictionary(dict,k));
    }

    static ArrayList<Character> AlienDictionary(String[]dict,int k){
        int n=dict.length;
        Map<Character,ArrayList<Character>> map=new HashMap<>();
        int[] freq=new int[k];

        for(int i=0;i<n-1;i++){
            char[] c=find(dict[i],dict[i+1]);
            if(c.length==0) continue;
            ArrayList<Character> arr=map.getOrDefault(c[0],new ArrayList<>());
            arr.add(c[1]);
            freq[c[1]-'a']++;
            map.put(c[0],arr);
        }

        Queue<Character> que=new LinkedList<>();
        for(int i=0;i<k;i++){
            if(freq[i]==0)
                que.offer((char)('a'+i));
        }
        ArrayList<Character> result=new ArrayList<>();

        while(!que.isEmpty()){
            char c=que.poll();
            result.add(c);

            if(map.containsKey(c)){
                for(char i: map.get(c)){
                    freq[i-'a']--;
                    if(freq[i-'a']==0)
                        que.offer(i);
                }
            }
        }

        return result;
    }

    static char[] find(String s1,String s2){
        int n=Math.min(s1.length(), s2.length());

        for(int i=0;i<n;i++){
            if(s1.charAt(i)!=s2.charAt(i))
                return new char[]{s1.charAt(i),s2.charAt(i)};
        }

        return new char[]{};
    }
}
