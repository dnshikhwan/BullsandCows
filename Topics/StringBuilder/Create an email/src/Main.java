import java.util.Scanner;

class EmployeeManagement {

    public static String createEmail(String name, String surname) {
        StringBuilder temp = new StringBuilder();

        temp.append(name);
        temp.append(surname);
        temp.append("@work.net");

        return temp.toString();
    }

    // Don't change the code below
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String name = scanner.next();
        String surname = scanner.next();

        String completeEmail = createEmail(name, surname);

        System.out.println(completeEmail);
    }
}