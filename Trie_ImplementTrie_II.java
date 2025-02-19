import java.util.Scanner;

public class Trie_ImplementTrie_II {

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

    static void Execute(String[] operation,String[] value){
        int n=value.length;
        Trie trie=new Trie();

        for(int i=0;i<n;i++){
            if(operation[i].equals("insert")){
                System.out.println("Inserted");
                trie.insert(value[i]);
            }
            if(operation[i].equals("countwordsequalsto"))
                System.out.println(trie.countWordsEqualTo(value[i]));
            if(operation[i].equals("countwordsstartingwith"))
                System.out.println(trie.countWordsStartingWith(value[i]));
            if(operation[i].equals("erase")){
                System.out.println("Erased");
                trie.erase(value[i]);
            }
        }
    }

    static class Trie {
        static class Node {
            Node[] links = new Node[26];
            int endsWith = 0;
            int countPrefix = 0;

            boolean containsKey(char c) {
                return links[c - 'a'] != null;
            }

            void put(char c, Node node) {
                links[c - 'a'] = node;
            }

            Node get(char c) {
                return links[c - 'a'];
            }

            void incrementEndsWith() {
                endsWith++;
            }

            void decrementEndsWith() {
                endsWith--;
            }

            void incrementPrefix() {
                countPrefix++;
            }

            void decrementPrefix() {
                countPrefix--;
            }

            int getEndsWith() {
                return endsWith;
            }

            int getPrefix() {
                return countPrefix;
            }
        }

        Node root;

        Trie() {
            root = new Node();
        }

        void insert(String word){
            Node temp=root;

            for(char c: word.toCharArray()){
                if(!temp.containsKey(c))
                    temp.put(c, new Node());
                
                temp=temp.get(c);
                temp.incrementPrefix();
            }
            temp.incrementEndsWith();
        }

        int countWordsEqualTo(String word){
            Node temp=root;

            for(char c: word.toCharArray()){
                if(!temp.containsKey(c))
                    return 0;
                
                temp=temp.get(c);
            }
            return temp.getEndsWith();
        }

        int countWordsStartingWith(String word){
            Node temp=root;

            for(char c: word.toCharArray()){
                if(!temp.containsKey(c))
                    return 0;
                temp=temp.get(c);
            }

            return temp.getPrefix();
        }

        void erase(String word){
            Node temp=root;

            for(char c: word.toCharArray()){
                if(!temp.containsKey(c))
                    return;
                
                temp=temp.get(c);
                temp.decrementPrefix();
            }

            temp.decrementEndsWith();
        }

    }

}
