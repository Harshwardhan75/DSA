import java.util.*;

public class ArraysHard_PascalTriangle {

    static int ncr(int row,int col){
        int result=1;
        for(int i=1;i<=col;i++){
            result=result*(row-i+1);
            result/=i;
        }
        return result;
    }

    static int Pascalsnth(int row,int col){
        int result=ncr(row-1,col-1);
        return result;
    }

    //Variety 2 Brute
    static ArrayList<Integer> PascalRow(int row){
        ArrayList<Integer> result=new ArrayList<>();
        for(int i=1;i<=row;i++){
             result.add(ncr(row-1,i-1));
        }
        return result;
    }

    //Variety 2 Optimal
    static ArrayList<Integer> PascalRow2(int row){
        ArrayList<Integer> result=new ArrayList<>();
        result.add(1);
        int r=1;
        row--;
        for(int i=0;i<row;i++){
            r=r*(row-i);
            r/=(i+1);
            result.add(r);
        }

        return result;
    }

    //Variety 3 Entire Pascal Triangle
    static void EntirePascalTriangle(ArrayList<ArrayList<Integer>> result,int n){
        ArrayList<Integer> arr;
        for(int i=1;i<=n;i++){
            result.add(PascalRow2(i));
        }
    }

    static void EntirePascalTriangle2(ArrayList<ArrayList<Integer>> result,int row){
        ArrayList<Integer> arr=new ArrayList<>();
        arr.add(1);
        result.add(arr);
        for(int i=1;i<row;i++){
            arr=new ArrayList<>();
            for(int j=0;j<=i;j++){
                if(j==0 || j==i)
                    arr.add(1);
                else   
                    arr.add(result.get(i-1).get(j-1)+result.get(i-1).get(j));
            }
            result.add(arr);
        }
    }



    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        
        //Variety 1
        // int row=sc.nextInt();
        // int col=sc.nextInt();

        // System.out.println(Pascalsnth(row,col));

        //variety 2 Print Entire row
        // int row=sc.nextInt();
        // ArrayList<Integer> result=PascalRow2(row);
        // System.out.println(result);

        //Variety 3 Print entire Pascal Triangle

        ArrayList<ArrayList<Integer>> result=new ArrayList<>();

        int n=sc.nextInt();
        EntirePascalTriangle2(result,n);
        System.out.println(result);
    }
}
