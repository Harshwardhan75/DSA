import java.util.*;

public class Arrays_IntersectionOfTwoArrays {
    //n*m
    static ArrayList<Integer> Intersection(ArrayList<Integer> A,ArrayList<Integer> B){
        ArrayList<Integer> inter=new ArrayList<>();
        int[] visited=new int[B.size()];
        for(int i=0;i<A.size();i++){
            for(int j=0;j<B.size();j++){
                if(A.get(i)==B.get(j) && visited[j]==0){
                    visited[j]=1;
                    inter.add(A.get(i));
                    break;
                }
            }
        }

        return inter;
    }

    static ArrayList<Integer> OptimalIntersection(ArrayList<Integer> A,ArrayList<Integer> B){
        ArrayList<Integer> inter=new ArrayList<>();
        int i=0,j=0;

        while(i<A.size() && j<B.size()){
            if(A.get(i)==B.get(j)){
                inter.add(A.get(i));
                i++;
                j++;
            }
            else if(A.get(i)<B.get(i))
                i++;
            else 
                j++;
        }
        return inter;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        ArrayList<Integer> A=new ArrayList<>();
        ArrayList<Integer> B=new ArrayList<>();

        int n=sc.nextInt();
        for(int i=0;i<n;i++)    A.add(sc.nextInt());

        int m=sc.nextInt();
        for(int i=0;i<m;i++)    B.add(sc.nextInt());

        System.out.println(OptimalIntersection(A,B));
    }
}
