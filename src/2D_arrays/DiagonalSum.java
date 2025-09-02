import java.util.*;
public class DiaogonalSum {
    public static void main(String args[]){
        //Input the Matrix
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter A Matrix");
        int[][]matrix=new int[3][3];
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                matrix[i][j]=sc.nextInt();
            }
        }
        //Show the Matrix
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                System.out.print(matrix[i][j]+"  ");
            }
            System.out.println();
        }
        //Calculate Diagonal Sum
        int ps=0;
        int ss=0;
        for(int i=0;i<matrix.length;i++)
        {
            ps+=matrix[i][i];
            ss+=matrix[i][matrix.length-i-1];



        }
        System.out.print("Sum of Elements of the Primary Diagonal is : \n"+ps);
        System.out.print("Sum of Elements of the Secondary Diagonal is : "+ss);
        sc.close();

    }
    
}
