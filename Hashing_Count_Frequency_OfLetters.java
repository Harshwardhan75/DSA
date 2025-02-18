import java.util.*;

public class Hashing_Count_Frequency_OfLetters {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();

        ArrayList<Integer> hash = new ArrayList<>(Collections.nCopies(26, 0));
        for (int i = 0; i < s.length(); i++) {
            hash.set((int) (s.charAt(i) - 'a'), hash.get(s.charAt(i) - 'a') + 1);
        }

        int q = sc.nextInt();
        ArrayList<Integer> query = new ArrayList<>(q);
        for(int i=0;i<q;i++){
            char x=sc.next().charAt(0);
            int y=x-'a';
            query.add(i,hash.get(y));
        }

        System.out.println(query);
    }
}
