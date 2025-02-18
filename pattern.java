import java.util.Scanner;

/**
 * pattern1
 */
public class pattern {
    
    static void Pattern1(int n){
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++)
                System.out.print("* ");
            
                System.out.println();
        }
    }
    
    static void Pattern2(int n){
        for(int i=0;i<n;i++){
            for(int j=0;j<=i;j++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }
    
    static void Pattern3(int n){
        for(int i=1;i<=n;i++){
            for(int j=1;j<=i;j++)
                System.out.printf("%d ",j);
            System.out.println();
        }
    }
    
    static void Pattern4(int n){
        for(int i=1;i<=n;i++){
            for(int j=1;j<=i;j++)
                System.out.printf("%d ",i);
            System.out.println();
        }
    }
    
    static void Pattern5(int n){
        for(int i=0;i<n;i++){
            for(int j=0;j<n-i;j++)
                System.out.printf("* ");
            
            System.out.println();
        }
    }
    
    static void Pattern6(int n){
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n-i+1;j++)
                System.out.printf("%d ",j);
            
            System.out.println();
        }
    }
    
    static void Pattern7(int n){
        for(int i=0;i<n;i++){
            for(int j=0;j<n-i-1;j++) 
                System.out.print(" ");
            for(int j=0;j<2*i+1;j++)
                System.out.print("*");
            
            System.out.println();
        }
    }
    
    static void Pattern8(int n){
        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++)
                System.out.print("  ");

            for(int j=1;j<=2*(n-i)-1;j++)
                System.out.print("* ");
                
            System.out.println();
        }
    }
    
    static void Pattern9(int n){
        for(int i=0;i<n;i++){
            for(int j=0;j<n-i-1;j++)
                System.out.print(" ");

            for(int j=0;j<2*i+1;j++)
                System.out.print("*");

            System.out.println();
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++)
                System.out.print(" ");
            
            for(int j=0;j<2*(n-i)-1;j++)
                System.out.print("*");
            
            System.out.println();
        }
    }
    
    static void Pattern10(int n){
        for(int i=1;i<=(2*n)-1;i++){
            int stars=i;
            if(i>n) stars=(2*n)-i;
            for(int j=1;j<=stars;j++)
                System.out.print("*");
            
            System.out.println();
        }
    }
    
    static void Pattern11(int n){
        for(int i=0;i<n;i++){
            int start=0;
            if(i%2==0) start=1;
            for(int j=0;j<=i;j++){
                System.out.printf("%d ",start);
                start=1-start;
            }
            System.out.println();
        }
    }
    
    static void Pattern12(int n){
        for(int i=1;i<=n;i++){
            for(int j=1;j<=i;j++)
                System.out.printf("%d",j);
            
            for(int k=0;k<2*(n-i);k++)
                System.out.print(" ");
            
            for(int j=i;j>=1;j--)
                System.out.printf("%d",j);
            
            System.out.println();
        }
    }

    static void Pattern13(int n){
        int x=1;

        for(int i=1;i<=n;i++){
            for(int j=1;j<=i;j++)
                System.out.printf("%d ",x++);
            
            System.out.println();
        }
    }
    
    static void Pattern14(int n){
        for(int i=1;i<=n;i++){
            for(int j='A';j<='A'+i-1;j++){
                System.out.printf("%c ",j);
            }
            System.out.println();
        }
    }
    
    static void Pattern15(int n){
        for(int i=0;i<n;i++){
            for(int j='A';j<'A'+n-i;j++)
                System.out.printf("%c ",j);
            
            System.out.println();
        }
    }
    
    static void Pattern16(int n){
        int x='A';
        for(int i=0;i<n;i++){
            for(int j=0;j<=i;j++)
                System.out.printf("%c ",x+i);
            
            System.out.println();           
        }
    }
    
    static void Pattern17(int n){
        for(int i=0;i<n;i++){
            int x='A';
            for(int j=0;j<n-i-1;j++)
                System.out.print(" ");
            
            for(int k=0;k<2*i+1;k++){
                System.out.printf("%c",x);
                if(k>=i) x--;
                else x++;
            }
            System.out.println();
        }
    }

    static void Pattern18(int n){
        for(int i=0;i<n;i++){
            for(int start='E'-i;start<='E';start++){
                System.out.printf("%c ",start);
            }
            System.out.println();
        }
    }
    
    static void Pattern19(int n){
        for(int i=0;i<n;i++){
            for(int j=0;j<n-i;j++)
                System.out.print("* ");
            
            for(int k=0;k<2*i;k++)
                System.out.print("  ");
            
            for(int j=0;j<n-i;j++)
                System.out.print("* ");
            
            System.out.println();
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<=i;j++)
                System.out.print("* ");
            
            for(int k=0;k<2*(n-i-1);k++)
                System.out.print("  ");
            
            for(int j=0;j<=i;j++)
                System.out.print("* ");
            
            System.out.println();
        }
    }
    
    static void Pattern20(int n){
        for(int i=1;i<=2*n-1;i++){
            int stars=i;
            int spaces=2*(n-i);
            if(i>n) {stars=2*n-i; spaces=(i-n)*2;}
            for(int j=0;j<stars;j++)
                System.out.print("*");
            for(int k=0;k<spaces;k++)
                System.out.print(" ");
            for(int j=0;j<stars;j++)
                System.out.print("*");
            
            System.out.println();
        }
    }
    
    static void Pattern21(int n){
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i==0 || j==0 || i==n-1 || j==n-1)
                    System.out.print("* ");
                else
                    System.out.print("  ");
            }
            System.out.println();
        }
    }
    
    static void Pattern22(int n){
        for(int i=1;i<=2*n-1;i++){
            for(int j=1;j<=2*n-1;j++){
                int top=i-1;
                int bottom=(2*n-1)-(i);
                int left=j-1;
                int right=(2*n-1)-(j);

                System.out.printf("%d ",n-Math.min(Math.min(top,bottom),Math.min(left,right)));
            }
            System.out.println();
        }
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        Pattern22(n);
        sc.close();
    }    
}