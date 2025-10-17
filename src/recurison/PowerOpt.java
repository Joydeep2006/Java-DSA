import java.util.*;
public class PowerOpt {
    // it is valid only for positive power 
    public static int power(int x,int n){
        if(n==0){
            return 1;
        }
        int halfpower=power(x, n/2);
        if(n%2!=0){
            return x*halfpower*halfpower;
        }
        else{
        return halfpower*halfpower;
        }
    }
    public static double calPow(double x,int n){
        if(n == 0){
            return 1;
        }
        if(x == 0){
            return 0;
        }
        if(n == 1){
            return x;
        }
        if(n == -1){
            return 1/x;
        }
        long binForm = n;
        double ans = 1;
        if(n<0){
            x = 1/x;
            binForm = -1 * binForm;
        }
        while(binForm>0){
            if(binForm%2 == 1){
                ans = ans *x;
            }
            binForm = binForm /2;
            x = x * x;
        }
        return ans;
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter Value of x and n in x^n");
        double x=sc.nextDouble();
        int n=sc.nextInt();
        System.out.println(x +"^"+ n + " = "+calPow(x,n));
        sc.close();
    }
    
}
