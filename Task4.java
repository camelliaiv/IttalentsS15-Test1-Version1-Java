import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) {

        int length = readArrayLength();
        char[][] array = new char[length][length];
        fillArray(array);
        printTriangles(array);
    }

    private static void printTriangles(char[][] arr) {
        int mid = arr.length / 2;
        printFirstTriangle(arr, mid);
        printSecondTriangle(arr, mid);
    }

    private static void printSecondTriangle(char[][] arr, int mid) {
        int start = mid;
        int end = arr[mid].length / 2;

        for (int row = 1; row <= mid + 1; row++) {
            for (int spaces = 0; spaces < mid - row + 1; spaces++) {
                System.out.print(" ");
            }

            for (int symbol = 0; symbol < (row * 2) - 1; symbol++) {
                System.out.print(arr[start][end]);
                end++;
            }
            System.out.println();
            start++;
            end = (arr[mid].length / 2) - row;
        }
    }

    private static void printFirstTriangle(char[][] arr, int mid) {

        int start = mid;
        int end = arr[mid].length / 2;

        for (int row = 1; row <= mid + 1; row++) {
            for (int spaces = 0; spaces < mid - row + 1; spaces++) {
                System.out.print(" ");
            }

            for (int symbol = 0; symbol < (row * 2) - 1; symbol++) {
                System.out.print(arr[start][end]);
                end++;
            }
            System.out.println();
            start--;
            end = (arr[mid].length / 2) - row;
        }
    }


    private static void fillArray(char[][] array) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.println("Enter a character:");
                array[i][j] = sc.next().charAt(0);
            }
        }
    }

    private static int readArrayLength() {
        Scanner sc = new Scanner(System.in);
        int num;
        do {
            System.out.println("Enter a number: ");
            num = sc.nextInt();
        } while (num % 2 == 0);
        return num;
    }
}
