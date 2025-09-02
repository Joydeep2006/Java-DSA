import java.util.*;
public class SqArea {
    public static void main(String args[]){
    System.out.print("Enter the length of the Side of Sqaure :");
    Scanner sc = new Scanner(System.in);
    int x=sc.nextInt();
    int area=x*x;
    System.out.print("The area of the Square is:");
    System.out.print(area);
    sc.close(); 
    }
}
