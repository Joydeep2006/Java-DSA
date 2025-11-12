public class ClearLastiBits {
    // function to clear last i bits of a number 
    public static int clearBits(int num,int i){
        int bitMask = (~0) << i;
        return num & bitMask;
    }

    // function to clear bits in a range 
    public static int clearBitsInRange(int num,int i,int j){
        int a = (~0)<<j+1;
        int b = (1<<i)-1;
        int bitMask = a|b;
        return num & bitMask;
    }
    public static void main(String[] args){
        System.out.println(clearBits(15, 2));
        System.out.println(clearBitsInRange(15, 1, 3));
        
    }
}
