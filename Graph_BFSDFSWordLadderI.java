import java.util.*;

public class Graph_BFSDFSWordLadderI {

    static class Pair {
        String s;
        int level;

        Pair(String s, int level) {
            this.s = s;
            this.level = level;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String start = sc.next();
        String end = sc.next();
        int n = sc.nextInt();
        List<String> wordList = new ArrayList<>();
        for (int i = 0; i < n; i++)
            wordList.add(sc.next());

        System.out.println(ladderLength(start, end, wordList));
    }

    static int ladderLength(String start, String end, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);
        Queue<Pair> que = new LinkedList<>();
        que.offer(new Pair(start, 1));

        while (!que.isEmpty()) {
            String s = que.peek().s;
            int level = que.peek().level;
            que.poll();

            if (s.equals(end))
                return level;

            for (int i = 0; i < s.length(); i++) {
                char[] c = s.toCharArray();
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    c[i] = ch;

                    String newString = new String(c);
                    if (set.contains(newString)) {
                        que.offer(new Pair(newString, level + 1));
                        set.remove(newString);
                    }
                }
            }
        }
        return 0;
    }
}
