package BitManipulation;

public class PowerOf2 {
    public static boolean isPowerOfTwo(int n) {
        if(n <= 0){
            return false;
        }
        if((n &(n-1))== 0){
            return true;
        }
        else{
            return false;
        }
    }
    public static void main(String[] args) {
        
    }
}
