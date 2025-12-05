public class Fibonacci {
    public static int fibo(int n,int fib[]){ // O(n)
        if(n == 0 || n == 1){
            return n;
        }
        if(fib[n] != 0){ // fib(n) is alreay calculated
            return fib[n];
        }
        fib[n] = fibo(n-1,fib) + fibo(n-2,fib);
        return fib[n];
    }
    public static void main(String[] args) {
        int n = 5;
        int fib[] = new int[n+1];
        System.out.println(fibo(n, fib));
    }
}
