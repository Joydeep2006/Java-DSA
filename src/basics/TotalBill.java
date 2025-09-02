import java.util.*;

public class TotalBill {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the amount of Pencils:");
        int p = sc.nextInt();

        System.out.println("Enter the amount of Pens:");
        int pen = sc.nextInt();

        System.out.println("Enter the amount of Erasers:");
        int er = sc.nextInt();

        // Correcting the tax calculation
        float total = (pen * 10) + (p * 5) + (er * 5);
        float bill = total * 1.18f;  // Applying 18% tax correctly

        System.out.printf("Your total bill is: %.2f", bill); // Formatting output to 2 decimal places

        sc.close(); // Closing scanner to prevent resource leak
    }
}
