import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class StackQueue_AsteroidCollisions {

    static ArrayList<Integer> asteroidcollision(int[] arr){
        Stack<Integer> st=new Stack<>();
        int n=arr.length;
        for(int i=0;i<n;i++){
            if(arr[i]>0)
                st.push(arr[i]);
            else{
                while(!st.isEmpty() && st.peek()>0 && st.peek()<Math.abs(arr[i]))
                    st.pop();
                
                if(!st.isEmpty() && st.peek()==Math.abs(arr[i]))
                    st.pop();
                else if(st.isEmpty() || st.peek()<0)
                    st.push(arr[i]);
            }
        }

        return new ArrayList<>(st);
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];

        for(int i=0;i<n;i++)
            arr[i]=sc.nextInt();
        
        System.out.println(asteroidcollision(arr));
    }
}