import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // start coding here

        // gets number n
        int n = scanner.nextInt();
        // get grades
        int a = 0;
        int b = 0;
        int c = 0;
        int d = 0;
        for (int i = 0; i <= n; i++){
            // sum of the grades
            String grade = scanner.nextLine();
            if (grade.equals("A")){
                a += 1;
            } else if (grade.equals("B")){
                b += 1;
            } else if (grade.equals("C")){
                c += 1;
            } else if (grade.equals("D")){
                d += 1;
            }
        }
        // print the total of each grades
        System.out.printf("%s %s %s %s", d, c, b, a);

        scanner.close();
    }
}
