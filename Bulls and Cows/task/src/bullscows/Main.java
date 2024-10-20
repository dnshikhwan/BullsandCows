package bullscows;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Input the length of the secret code:");
        int lenOfCode = 0;
        String temp = "";
        try {
            temp = scanner.next();
            lenOfCode = Integer.parseInt(temp);
        } catch (NumberFormatException e) {
            System.out.println("Error: \"" + temp + "\" isn't a valid number.");
            System.exit(0);
        }

        if (lenOfCode == 0) {
            System.out.println("Error: length of secret code cannot be 0");
            System.exit(0);
        }

        System.out.println("Input the number of possible symbols in the code:");
        int numOfSymbol = scanner.nextInt();
        if (numOfSymbol < lenOfCode) {
            System.out.println("Error: it's not possible to generate a code with a length of " + lenOfCode
                    + " with " + numOfSymbol + " unique symbols.");
            System.exit(0);
        }

        // handle error if input is larger than 36
        if (lenOfCode > 36 || numOfSymbol > 36) {
            System.out.println("Error: maximum number of possible symbols in the code is 36 (0-9, a-z).");
            System.exit(0);
        } else {

            int count = 1;
            while (count <= 36) {
                Game game = new Game();
                StringBuilder secretCode = generateSecretCode(lenOfCode, numOfSymbol);

                gameStart(lenOfCode, numOfSymbol);
                System.out.println("Okay, let's start a game!");

                int numOfTurn = 1;
                while (game.getBulls() != lenOfCode) {
                    System.out.println("Turn " + numOfTurn + ":");
                    grader(scanner, game, secretCode);

                    if (game.getBulls() > 0 && game.getCows() > 0) {
                        System.out.println("Grade: " + game.getBulls() + " bull" + (game.getBulls() <= 1 ? "" : "s") +
                                " and " + game.getCows() + " cow" + (game.getCows() <= 1 ? "" : "s"));
                    } else if (game.getBulls() > 0 && game.getCows() == 0) {
                        System.out.println("Grade: " + game.getBulls() + " bull" + (game.getBulls() <= 1 ? "" : "s"));
                    } else if (game.getBulls() == 0 && game.getCows() > 0) {
                        System.out.println("Grade: " + game.getCows() + " cow" + (game.getCows() <= 1 ? "" : "s"));
                    } else if (game.getBulls() == 0 && game.getCows() == 0) {
                        System.out.println("Grade: None");
                    }

                    numOfTurn++;
                }

                if (game.getBulls() == lenOfCode) {
                    gameEnded();
                    break;
                }

                count++;
            }


        }

        scanner.close();
    }

    public static void gameStart(int lenOfCode , int numOfSymbol) {
        StringBuilder asterisk = new StringBuilder();

        for (int i = 0; i < lenOfCode; i++) {
            asterisk.append('*');
        }

        StringBuilder text = new StringBuilder();
        text.append("The secret is prepared: " + asterisk + " (0-9, a-a).");


        // need to check later
        if (numOfSymbol > 10) {
            char letter = (char) ('a' + numOfSymbol - 11);
            text.replace(text.length() - 3, text.length() - 2, String.valueOf(letter));
        }

        System.out.println(text);
    }

    public static void gameEnded() {
        System.out.println("Congratulations! You guessed the secret code.");
    }

    public static void grader(Scanner scanner, Game game, StringBuilder secretCode) {
//        System.out.println(secretCode);
        String guess = scanner.next();

        if (guess.length() != secretCode.length()) {
            System.out.println("Error: guess length is not the same as the secret code length");
            System.exit(0);
        }

        char[] guessArray = guess.toCharArray(); // {1, 2, 3, 4}
        char[] secretCodeArray = secretCode.toString().toCharArray(); // {9, 3, 0, 5}

        // initialize bulls and cows and reset the field in game method
        game.setBulls(0);
        game.setCows(0);
        int bulls = 0;
        int cows = 0;

        for (int i = 0; i < guessArray.length; i++) {
            for (int j = 0; j < secretCodeArray.length; j++) {
                // find if guess is present in secret code
                if (guessArray[i] == secretCodeArray[j]) {
                    // if index is the same, bulls++
                    if (i == j) {
                        bulls++;
                        break;
                    } else {
                        // else cows++
                        cows++;
                        break;
                    }
                }
            }
        }


        if (bulls > 0 && cows > 0) {
            game.setBulls(bulls);
            game.setCows(cows);
        } else if (bulls > 0 && cows == 0) {
            game.setBulls(bulls);
        } else if (bulls == 0 && cows > 0) {
            game.setCows(cows);
        } else if (bulls == 0 && cows == 0){
            game.setBulls(0);
            game.setCows(0);
        }
    }

    // generate random secret code based on specified length but must not greater than 10
    public static StringBuilder generateSecretCode(int lenOfCode, int numOfSymbol) {
        StringBuilder secretCode = new StringBuilder();

        Random random = new Random();

        for (int i = 0; i < lenOfCode; i++) {
            String randomChar = "";

            if (numOfSymbol == 10) {
                randomChar = Integer.toString(random.nextInt(10));
            } else {
                randomChar  = String.valueOf((char) (random.nextInt(numOfSymbol - 11) + 'a'));
            }

            while(secretCode.toString().contains(randomChar)) {
                randomChar = Integer.toString(random.nextInt(10));
            }

            secretCode.append(randomChar);
        }

        while (secretCode.charAt(0) == '0') {
            secretCode.replace(0,1, Integer.toString(random.nextInt(10)));
        }

        return secretCode;
    }
}
