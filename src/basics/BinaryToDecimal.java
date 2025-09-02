import java.util.*;
public class BinaryToDecimal {
    public static int convert(int n){
        int deci=0;
        for(int i=0;n>0;i++)
        {
        int ld=n%10;
        if(ld!=0&&ld!=1)
        {
            return -1;
        }
        deci=(ld*(int)Math.pow(2,i)+deci);
        n=n/10;
        }
        return deci;
    }
    public static void main(String args[]){
        System.out.print("Enter A Binary Number :");
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int deci=convert(n);
        if(deci==-1)
        {
            System.out.print("Invalid Input");
           
        }
        else
        System.out.print(n+"'s decimal value is "+deci);
        sc.close();
    }
}
