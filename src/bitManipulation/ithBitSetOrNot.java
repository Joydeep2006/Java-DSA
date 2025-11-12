public class ithBitSetOrNot {
    // to check the ith bit in the number is 0 or 1(set)
    public static boolean ithBit(int num,int i){
        int bitMask = 1 << i;
        if((num & bitMask) == 1){
            return true;
        }
        else{
            return false;
        }
    }
    public static void main(String[] args) {
        System.out.println(ithBit(5, 1)); // 5 -> 101 i=0th bit is 1(set)
    }
    
}
