import java.util.Scanner;

public class Trie_ImplementTrie_I {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] operation = new String[n];
        String[] value = new String[n];
        for (int i = 0; i < n; i++) {
            operation[i] = sc.next();
            value[i] = sc.next();
        }

        Execute(operation, value);
    }

    static class Trie {
        static class Node {
            Node[] links = new Node[26];
            boolean flag = false;

            boolean containsKey(char c) {
                return links[c - 'a'] != null;
            }

            void put(char c, Node node) {
                links[c - 'a'] = node;
            }

            Node get(char c) {
                return links[c - 'a'];
            }

            void setEnd() {
                flag = true;
            }

            boolean isEnd() {
                return flag;
            }
        }

        Node root;

        Trie() {
            this.root = new Node();
        }

        void insert(String word) {
            Node temp = root;

            for (char c : word.toCharArray()) {
                if (!temp.containsKey(c))
                    temp.put(c, new Node());
                temp = temp.get(c);
            }
            temp.setEnd();
        }

        boolean search(String word) {
            Node temp = root;

            for (char c : word.toCharArray()) {
                if (!temp.containsKey(c))
                    return false;
                temp = temp.get(c);
            }

            return temp.isEnd();
        }

        boolean startsWith(String prefix) {
            Node temp = root;

            for (char c : prefix.toCharArray()) {
                if (!temp.containsKey(c))
                    return false;
                temp = temp.get(c);
            }

            return true;
        }
    }

    static void Execute(String[] operation, String[] value) {
        Trie trie = new Trie();
        int n = operation.length;

        for (int i = 0; i < n; i++) {
            if (operation[i].equals("insert")) {
                trie.insert(value[i]);
                System.out.println("Inserted");
            }
            if (operation[i].equals("search"))
                System.out.println(trie.search(value[i]));
            if (operation[i].equals("startwith"))
                System.out.println(trie.startsWith(value[i]));
        }
    }
}
