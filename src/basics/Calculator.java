import java.util.*;
public class Calculator {
    public static void main(String args[])
    {
        System.out.println("Enter Two numbers :");
        Scanner sc=new Scanner(System.in);
        float a=sc.nextFloat();
        float b=sc.nextFloat();
        System.out.println("Enter The Opration between the Two numbers :");
        char op=sc.next().charAt(0);
        switch (op){
            case '+':System.out.println("Sum of "+a+" and "+b+" is "+(a+b));
                break;
            case '-':System.out.println("Substraction of "+a+" and "+b+" is "+(a-b));
                break;    
            case '*':System.out.println("Multiplication of "+a+" and "+b+" is "+(a*b));
                break;
            case '/':System.out.println("Diviison of "+a+" and "+b+" is "+(a/b));
                break;
            case '%':System.out.println("Remainder of "+a+"and"+b+" is "+(a%b));
                break;
            default:System.out.print("wrong opration");
                break;
        }
    sc.close();
    }
    
}
