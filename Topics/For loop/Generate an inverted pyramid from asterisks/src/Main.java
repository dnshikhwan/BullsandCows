import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Get the number of rows for the pyramid
        int n = scanner.nextInt();
        // For each row..
        // write a loop that starts at 'n' and ends at 1 (hint: you can use a decrement)
        // For each column..
        // write another loop inside the first one that starts at the current row number and ends at 1
        // print an asterisk ('*') without going to the next line (use 'System.out.print' instead of 'println')
        // After each row, print a newline character ('\n')

        for (int i = n; i >= 1; i--){
            for (int j = i; j >= 1; j--){
                System.out.print("*");
            }
            System.out.print("\n");
        }

        scanner.close();
    }
}