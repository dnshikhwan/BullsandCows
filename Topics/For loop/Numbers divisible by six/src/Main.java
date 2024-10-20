import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // start coding here

        // input how many numbers of elements
        int number = scanner.nextInt();
        // scan all the elements of inputs
        int sum = 0;
        for (int i = 0; i < number; i++){
           int element = scanner.nextInt();
           // determine if the element are divisible by 6
           if (element % 6 == 0){
               sum += element;
           }
        }

        // output the sum of the element
        System.out.println(sum);
        scanner.close();
    }
}