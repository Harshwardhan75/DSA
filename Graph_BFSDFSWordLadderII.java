import java.util.*;
import javax.naming.spi.DirStateFactory;

public class Graph_BFSDFSWordLadderII {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String start = sc.next();
        String end = sc.next();
        int n = sc.nextInt();
        List<String> wordList = new ArrayList<>();
        for (int i = 0; i < n; i++)
            wordList.add(sc.next());

        System.out.println(wordLadderII(start, end, wordList));
    }

    static ArrayList<ArrayList<String>> wordLadderII(String start, String end, List<String> wordList) {
        Queue<ArrayList<String>> que = new LinkedList<>();
        que.offer(new ArrayList<>(Arrays.asList(start)));
        Set<String> set = new HashSet<>(wordList);
        ArrayList<ArrayList<String>> result=new ArrayList<>();
        while (!que.isEmpty()) {
            int size=que.size();
            ArrayList<String> rem=new ArrayList<>();

            for(int j=1;j<=size;j++){
                ArrayList<String> arr=que.poll();
                int n=arr.size();
                String last=arr.get(n-1);
                if(last.equals(end))
                {
                    result.add(arr);
                    continue;
                }

                for(int i=0;i<last.length();i++){
                    char[] c=last.toCharArray();
                    for(char ch='a';ch<='z';ch++){
                        c[i]=ch;
                        String newString = new String(c);

                        if(set.contains(newString)){
                            ArrayList<String> temp=new ArrayList<>(arr);
                            rem.add(newString);
                            temp.add(newString);
                            que.offer(temp);
                        }
                    }
                }
            }

            for(String s: rem)
                set.remove(s);
        }

        return result;
    }
}
