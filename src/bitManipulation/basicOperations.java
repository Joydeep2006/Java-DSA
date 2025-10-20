package BitManipulation;

public class basicOperations {
    // function to get the ith of a number 
    public static int getithBit(int num,int i){
        int bitMask = 1 << i;
        if((num & bitMask) == 1){
            return 1;
        }
        else{
            return 0;
        }
    }

    // function  to set the ith bit of a number and return the number 
    public static int setithBit(int num,int i){
        int bitMask = 1 << i;
        num = num | bitMask;
        return num;
    }

    // function to clear the ith bit of a number and return the number
    public static int clearithBit(int num,int i){
        int bitMask = ~( 1 << i); 
        num = num & bitMask;
        return num;
    }
    //
    public static void main(String[] args) {
        System.out.println(getithBit(5, 0)); // => 5 -> 101 so, i=0 is 1
        System.out.println(setithBit(5, 1)); // =>5 -> 101 so, i=0 is 111 -> 7
        System.out.println(clearithBit(5, 0)); // =>5 -> 101 so, i=0 is 100 -> 4
        
    }
}
