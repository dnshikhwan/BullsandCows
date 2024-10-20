import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();

        System.out.println(productOfAllInteger(a, b));
        scanner.close();
    }

    public static int productOfAllInteger(int a, int b) {
        int result = 1;
        for (int i = a; i < b; i++) {
            result *= i;
        }
        return result;
    }
}