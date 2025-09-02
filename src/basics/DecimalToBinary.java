import java.util.*;
public class DecimalToBinary {
    public static int convert(int num)
    {
        int bin=0;
        int i=0,ld;
        while(num>0)
        {
            ld=num%2;
            bin=(ld*(int)Math.pow(10,i))+bin;
            num=num/2;
            i++;
        }
        return bin;
    }
    public static void main(String args[])
    {
        System.out.print("Enter A Decimal Number : ");
        Scanner sc=new Scanner(System.in);
        int num=sc.nextInt();
        if (num < 0) {
            System.out.println("Invalid input: Please enter a non-negative decimal number.");
        }
        else{
        int bin=convert(num);
        System.out.print(num+"'s Binary value is "+bin);
        }
        sc.close();
    }
    
}
