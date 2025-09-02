import java.util.*;
public class IncomeTax {
    public static void main(String args[])
    {
        System.out.print("Enter Your Annual Income : ");
        Scanner sc=new Scanner(System.in);
        double x=sc.nextFloat();
        double t;
        if(x<500000)
        {
            t=0;
        }
        else if(x>=500000&&x<1000000)
        {
            t=x*.2d;
        }
        else
        {
            t=x*.3d;
        }
        System.out.print("Your income Tax is :"+t);
        sc.close();
    }
}
