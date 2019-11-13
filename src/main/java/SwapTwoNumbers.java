import java.util.Scanner;

public class SwapTwoNumbers {


    public static void main(String[] args) {
        int a, b, temp;
        Scanner scanner = new Scanner(System.in);
        a = scanner.nextInt();
        b = scanner.nextInt();
        System.out.println("Before Swapping \n x = "+a+ "\n y = "+b);

        temp = a;
        a = b;
        b = temp;

        System.out.println("print the value after swapping\n x = "+a+ "\n y = "+b);
        System.out.println("just print to the console");
    }
}
