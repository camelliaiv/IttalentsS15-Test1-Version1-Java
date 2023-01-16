import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int tries = 0;
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        while (true) {
            System.out.println("Import a characters: ");
            String text = sc.nextLine();
            String[] letters = text.split(" ");
            if (!validateInput(letters)) {
                System.out.println("Invalid input.");
                continue;
            }
            tries++;
            if (!checkForBingo(letters)) {
                continue;
            }
            System.out.println("BINGO");
            alphabet = checkForEnd(letters, alphabet);
            if (alphabet == " ") {
                System.out.println("Tries: " + tries);
                break;
            }
        }


    }

    private static String checkForEnd(String[] letters, String alphabet) {
        for (int i = 0; i < alphabet.length(); i++) {
            if (alphabet.length() == 1) {
                return " ";
            }
            if (letters[0].charAt(0) == alphabet.charAt(i)) {
                if (i == 0) {
                    alphabet = alphabet.substring(1);
                    break;
                }
                if (i == alphabet.length() - 1) {
                    alphabet = alphabet.substring(0, alphabet.length() - 1);
                    break;
                }
                alphabet = alphabet.substring(0, i).concat(alphabet.substring(i + 1, alphabet.length()));
                break;
            }
        }
        return alphabet;
    }

    private static boolean checkForBingo(String[] letters) {
        if (!(letters[0].equals(letters[1]) && letters[1].equals(letters[2]))) {
            return false;
        }
        return true;
    }

    private static boolean validateInput(String[] letters) {
        if (letters.length != 3) {
            return false;
        }
        for (int i = 0; i < letters.length; i++) {
            if (letters[i].length() != 1) {
                return false;
            }
            if (!(letters[i].charAt(0) >= 'A' && letters[i].charAt(0) <= 'Z')) {
                return false;
            }
        }
        return true;
    }
}
