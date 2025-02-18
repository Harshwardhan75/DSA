import java.util.*;

public class Recursion_GeneratePowerSetString {

    static ArrayList<String> IterativePowerSet(String s){
        ArrayList<String> result=new ArrayList<>();
        int n=s.length();
        for(int i=0;i<(1<<n);i++){
            String str="";
            for(int j=0;j<n;j++){
                if((i&(1<<j))!=0)
                    str+=s.charAt(j);
            }
            result.add(str);
        }
        return result;
    }

    static ArrayList<String> RecursivePowerSet(String s){
        ArrayList<String> result=new ArrayList<>();
        generatePowerSet(result,s,"",0);
        return result;
    }

    static void generatePowerSet(ArrayList<String> result,String s,String str,int selected){
        if(selected==s.length()){
            result.add(str);
            return;
        }

        generatePowerSet(result, s, str+s.charAt(selected), selected+1);
        generatePowerSet(result, s, str, selected+1);
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.next();
        System.out.println(RecursivePowerSet(s));
    }
}
