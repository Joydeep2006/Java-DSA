import java.util.*;
public class PermComb {
    public static long fact(int n) {
        long f = 1;
        for (int i = 1; i <= n; i++) {
            f *= i;
        }
        return f;
    }

    public static long nCr(int n, int r) {
        if (r > n || r < 0) {
            System.out.println("Invalid input: Ensure 0 <= r <= n.");
            return -1;
        }
        long nfactorial = fact(n);
        long rfactorial = fact(r);
        long nrfactorial = fact(n - r);
        return nfactorial / (rfactorial * nrfactorial);
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter values of n and r to calculate nCr: ");
        int n = sc.nextInt();
        int r = sc.nextInt();

        long result = nCr(n, r);
        if (result != -1) {
            System.out.println("The value of " + n + "C" + r + " is " + result);
        }
        
        sc.close();
    }
}
