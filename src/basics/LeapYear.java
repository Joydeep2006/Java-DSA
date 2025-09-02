import java.util.*;
public class LeapYear {
    public static void main(String args[]){
        System.out.print("Enter Any Year to Check Leap Year :");
        Scanner sc=new Scanner(System.in);
        int y=sc.nextInt();
        if(y%4==0)
        {
            if(y%100!=0||y%400==0)
            {
                System.out.print(y+" is A Leap Year");
            }
            else
            {
                System.out.print(y+" is not A Leap Year");
            }
        }
        else
        {
            System.out.print(y+" is not A Leap Year");
        }
        sc.close();
    }
}
