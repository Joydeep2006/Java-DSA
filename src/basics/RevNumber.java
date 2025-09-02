import java.util.*;
public class RevNumber {
    public static void main(String args[]){
        System.out.print("Enter A Number :");
        Scanner sc =new Scanner(System.in);
        int num=sc.nextInt();
        int rev=0;
        int ld;
        while(num>0)
        {
         ld=num%10;
         num=num/10;
         rev=(rev*10)+ld;
        }
        System.out.print("Reverse of This "+num+" is "+rev);
        sc.close();   
    }
}
