import java.util.Scanner;

public class Trie_CountDistinctSubString {
    static class Node{
        Node[] links=new Node[26];

        boolean containsKey(char c){
            return links[c-'a']!=null;
        }

        void put(char c,Node node){
            links[c-'a']=node;
        }

        Node get(char c){
            return links[c-'a'];
        }
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.next();

        System.out.println(countDistinctSubstring(s));
    }

    static int countDistinctSubstring(String s){
        int n=s.length();
        Node root=new Node();
        int count=0;

        for(int i=0;i<n;i++){
            Node temp=root;
            for(int j=i;j<n;j++){
                if(!temp.containsKey(s.charAt(j))){
                    temp.put(s.charAt(j), new Node());
                    count++;
                }
                temp=temp.get(s.charAt(j));
            }
        }

        return count+1;
    }

}
