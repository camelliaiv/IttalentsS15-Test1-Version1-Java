import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();
        findWords(text);
    }

    private static void findWords(String text) {
        text = text.toLowerCase();
        String[] words = text.split(" ");
        checkForPointAndCommas(words);
        checkForEquality(words);
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words.length; j++) {
                if (words[j].contains(words[i])) {
                    if (words[i].equals(words[j]) || words[i].length() > words[j].length()) {
                        continue;
                    }
                    System.out.println(words[i] + " in " + words[j] + ";");
                }
            }
        }
    }

    private static void checkForEquality(String[] words) {
        for (int i = words.length - 1; i >= 0; i--) {
            for (int j = words.length - 1; j >= 0; j--) {
                if (i != j && words[i].equals(words[j])) {
                    words[i] = " ";
                }
            }
        }
    }

    private static void checkForPointAndCommas(String[] words) {
        for (int i = 0; i < words.length; i++) {
            if (words[i].endsWith(".") || words[i].endsWith(",")) {
                words[i] = words[i].substring(0, words[i].length() - 1);
            }
        }
    }
}
