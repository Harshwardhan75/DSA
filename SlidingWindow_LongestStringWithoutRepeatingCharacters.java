import java.util.Scanner;

public class SlidingWindow_LongestStringWithoutRepeatingCharacters {

    static int BrutelongestSubstring(String s) {
        int n = s.length();
        int max = 0;
        for (int i = 0; i < n; i++) {
            int[] hash = new int[256];
            for (int j = i; j < n; j++) {
                if (hash[s.charAt(j)] == 1)
                    break;
                max = Math.max(max, j - i + 1);
                hash[s.charAt(j)] = 1;
            }
        }

        return max;
    }

    static int OptimallongestSubstring(String s) {
        int n = s.length();
        int l = 0, r = 0;
        int[] hash = new int[256];
        int max = 0;
        for (int i = 0; i < 256; i++)
            hash[i] = -1;
        while (r < n) {
            if (hash[s.charAt(r)] != -1) {
                if (hash[s.charAt(r)] >= l)
                    l = hash[s.charAt(r)] + 1;
            }
            max = Math.max(max, r - l + 1);
            hash[s.charAt(r)] = r;
            r++;
        }
        return max;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();

        System.out.println(OptimallongestSubstring(s));
    }
}
