import java.util.*;
public class OddOrEven {
    public static void main(String args[])
    {
     System.out.print("Enter A Number To Check Even or Odd :");
     Scanner sc= new Scanner(System.in);
     int x=sc.nextInt();
     if(x%2==0)
     {
        System.out.print(x+" is An Even Number");
     }
     else
     {
        System.out.print(x+" Is An Odd Number");
     }
     sc.close();
    }
}
