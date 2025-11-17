public class GridWays {
    // to get the factorial of a number 
    public static int fact(int n){
        int ans = 1;
        for(int i=n;i>0;i--){
            ans = ans *i;
        }
        return ans;
    }
    // count no. of ways to go from source to destination
    public static int countWays(int i,int j,int m,int n){ //=> O(2^(m+n))
        // base case - reached destination 
        if(i == m-1 && j == n-1){
            return 1;
        }
        // base case -2 boundary crossed
        else if(i == m || j == n){
            return 0;
        }

        return countWays(i+1, j, m, n) + countWays(i, j+1, m, n);
    }
    // optimized way to calculate no. of ways
    public static int countWays(int m,int n){ // => O(m+n)
        // using permutations we derive this formula 
        return fact(m-1+n-1)/(fact(m-1)*fact(n-1));

    }
    public static void main(String[] args) {
        int m =3,n=3;
        System.out.println("Total no. of Ways : "+ countWays(0, 0, m, n));
        System.out.println("Total no. of Ways : "+ countWays(m, n));
        
    }
}
