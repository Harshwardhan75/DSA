import java.util.*;

public class Recursion_Palindrome_Partitioning {

    static ArrayList<ArrayList<String>> PalindromPartition(String s){
        ArrayList<ArrayList<String>> result=new ArrayList<>();
        ArrayList<String> arr=new ArrayList<>();
        Partition(result,arr,s);
        return result;
    }

    static void Partition(ArrayList<ArrayList<String>> result,ArrayList<String> arr,String s){
        if(s.length()==0){
            result.add(new ArrayList<>(arr));
            return;
        }

        for(int i=1;i<=s.length();i++){
            if(isPalindrome(s.substring(0,i))){
                arr.add(s.substring(0,i));
                Partition(result, arr, s.substring(i));
                arr.remove(arr.size()-1);
            }
        }
    }

    static boolean isPalindrome(String s){
        int start=0,end=s.length()-1;

        while(start<end){
            if(s.charAt(start)!=s.charAt(end))
                return false;
            start++;
            end--;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.next();

        System.out.println(PalindromPartition(s));
    }
}