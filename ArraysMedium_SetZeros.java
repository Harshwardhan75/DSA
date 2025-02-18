import java.util.*;

public class ArraysMedium_SetZeros {

    static void setRow(ArrayList<ArrayList<Integer>> matrix,int i){
        for(int j=0;j<matrix.get(0).size();j++)
            if(matrix.get(i).get(j)==1)
                matrix.get(i).set(j,-1);
    }

    static void setColumn(ArrayList<ArrayList<Integer>> matrix,int j){
        for(int i=0;i<matrix.size();i++)
            if(matrix.get(i).get(j)==1)
                matrix.get(i).set(j,-1);
    }

    static void BrutesetZero(ArrayList<ArrayList<Integer>> matrix){

        for(int i=0;i<matrix.size();i++){
            for(int j=0;j<matrix.get(0).size();j++){
                if(matrix.get(i).get(j)==0){
                    setRow(matrix,i);
                    setColumn(matrix,j);
                }
            }
        }

        for(int i=0;i<matrix.size();i++){
            for(int j=0;j<matrix.get(i).size();j++)
                if(matrix.get(i).get(j)==-1)
                    matrix.get(i).set(j,0);
        }
    }

    static void BettersetZero(ArrayList<ArrayList<Integer>> matrix){
        int[] row=new int[matrix.size()];
        int[] column=new int[matrix.get(0).size()];

        for(int i=0;i<matrix.size();i++){
            for(int j=0;j<matrix.get(0).size();j++){
                if(matrix.get(i).get(j)==0){
                    row[i]=1;
                    column[i]=1;
                }
            }
        }

        for(int i=0;i<matrix.size();i++){
            for(int j=0;j<matrix.get(0).size();j++){
                if(row[i]==1 || column[j]==1)
                    matrix.get(i).set(j,0);
            }
        }
    }

    static void OptimalsetZero(ArrayList<ArrayList<Integer>> matrix){
        int col0=1;

        for(int i=0;i<matrix.size();i++){
            for(int j=0;j<matrix.get(0).size();j++){
                if(matrix.get(i).get(j)==0){
                    if(j==0)
                        col0=0;
                    else    
                        matrix.get(0).set(j,0);
                    
                        matrix.get(i).set(0,0);
                }
            }
        }


        for(int i=matrix.size()-1;i>=0;i--){
            for(int j=matrix.get(0).size()-1;j>0;j--){
                if(matrix.get(i).get(0)==0 || matrix.get(0).get(j)==0)
                    matrix.get(i).set(j,0);
            }
        }

        for(int i=0;i<matrix.size();i++)
            if(col0==0)
                matrix.get(i).set(0,0);
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        ArrayList<ArrayList<Integer>> matrix=new ArrayList<>();
        for(int i=0;i<n;i++){
            ArrayList<Integer> arr=new ArrayList<>();
            for(int j=0;j<m;j++)
                arr.add(sc.nextInt());
            
            matrix.add(arr);
        }

        for(ArrayList<Integer> var: matrix)
            System.out.println(var);

        OptimalsetZero(matrix);

        System.out.println();
        for(ArrayList<Integer> var: matrix)
            System.out.println(var);
    }
}