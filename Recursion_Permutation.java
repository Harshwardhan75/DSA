import java.util.*;

public class Recursion_Permutation {

    static void permutation(ArrayList<Integer> result,int arr[],boolean[] visited){
        if(arr.length==result.size()){
            System.out.println(result);
            return ;
        }

        for(int i=0;i<arr.length;i++){
            if(!visited[i]){
                visited[i]=true;
                result.add(arr[i]);
                permutation(result, arr, visited);
                result.remove(result.size()-1);
                visited[i]=false;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int [] arr=new int[n];

        for(int i=0;i<n;i++)    arr[i]=sc.nextInt();

        boolean[] visited=new boolean[n];
        ArrayList<Integer> result=new ArrayList<>();
        permutation(result,arr,visited);
    }
}
