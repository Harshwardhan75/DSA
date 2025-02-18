import java.util.*;

public class Arrays_UnionOfTwoSets {

    static Set<Integer> Union(ArrayList<Integer> arr1,ArrayList<Integer> arr2){
        Set<Integer> set=new HashSet<>();
        for(int i=0;i<arr1.size();i++)  set.add(arr1.get(i));
        for(int i=0;i<arr2.size();i++)  set.add(arr2.get(i));

        return set;
    }

    static int back(ArrayList<Integer> arr){
        if(arr.size()!=0)
            return arr.get(arr.size()-1);
        else return (int)Double.POSITIVE_INFINITY;
    }
    //Function to return a list containing the union of the two arrays.
    public static ArrayList<Integer> findUnion(int arr1[], int arr2[])
    {
        // add your code here
        ArrayList<Integer> union=new ArrayList<>();
        int i=0,j=0;
        int n=arr1.length;
        int m=arr2.length;
        
        while(i<n && j<m){
            if(arr1[i]<=arr2[j]){
                if(union.size()==0||union.get(union.size()-1)!=arr1[i])
                    union.add(arr1[i]);
                i++;
            }
            else{
                if(union.size()==0||union.get(union.size()-1)!=arr2[j])
                    union.add(arr2[j]);
                j++;
            }
        }
        
        while(i<n){
            if(union.size()==0||union.get(union.size()-1)!=arr1[i])
                    union.add(arr1[i]);
                i++;
        }
        while(j<m){
            if(union.size()==0||union.get(union.size()-1)!=arr2[j])
                    union.add(arr2[j]);
                j++;
        }
        return union;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int m=sc.nextInt();
        ArrayList<Integer> arr1=new ArrayList<>();
        for(int i=0;i<m;i++)    arr1.add(sc.nextInt());

        int n=sc.nextInt();
        ArrayList<Integer> arr2=new ArrayList<>();
        for(int i=0;i<n;i++)    arr2.add(sc.nextInt());
        
        //Pass simple Array
        System.out.println(findUnion(arr1,arr2));
    }
}
