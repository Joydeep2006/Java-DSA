package BitManipulation;
import java.util.*;
public class CheckOddOrEven {
    public static void check(int n){
        int bitMask = 1;
        if((n&bitMask) == 1){
            System.out.println("Odd Number");
        }
        else{
            System.out.println("Even Number");
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a Number : ");
        int num = sc.nextInt();
        check(num);
        sc.close();
        
    }
}
