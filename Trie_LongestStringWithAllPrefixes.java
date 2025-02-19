import java.util.Scanner;

public class Trie_LongestStringWithAllPrefixes {
    
    static class Trie{
        static class Node{
            Node[] links=new Node[26];
            boolean flag=false;

            boolean containsKey(char c){
                return links[c-'a']!=null;
            }

            void put(char c,Node node){
                links[c-'a']=node;
            }

            Node get(char c){
                return links[c-'a'];
            }

            void setEnd(){
                flag=true;
            }

            boolean isEnd(){
                return flag;
            }
        }

        Node root;

        Trie(){
            root=new Node();
        }

        void insert(String word){
            Node temp=root;

            for(char c: word.toCharArray()){
                if(!temp.containsKey(c))
                    temp.put(c, new Node());
                
                temp=temp.get(c);
            }
            temp.setEnd();
        }

        boolean checkIfPrefixExists(String word){
            Node temp=root;
            boolean flag=true;
            for(char c: word.toCharArray()){
                if(!temp.containsKey(c))
                    return false;
                
                temp=temp.get(c);
                flag = flag & temp.isEnd();
            }

            return flag;
        }
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        String[] value=new String[n];

        for(int i=0;i<n;i++)
            value[i]=sc.next();
        
        System.out.println(longestString(value));
    }

    static String longestString(String[] value){
        int n=value.length;
        Trie trie=new Trie();

        for(String s: value)
            trie.insert(s);
        
        String longest="";

        for(String s: value){
            if(trie.checkIfPrefixExists(s)){
                if(s.length()>longest.length())
                    longest=s;
                else
                if(s.length()==longest.length()
                && s.compareTo(longest)<0)
                    longest=s;
            }
        }

        return longest;
    }
    
}
