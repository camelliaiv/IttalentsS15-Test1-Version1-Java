import java.util.Arrays;
import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {

        int[] array = new int[importArrayLength()];
        fillArray(array, 0);
        int[] secondArray = new int[4];
        secondArray = makeCalculations(array, secondArray, 0, 0, 0, 1, 1);
        System.out.println(Arrays.toString(secondArray));
    }

    private static int[] makeCalculations(int[] array, int[] secondArray, int index, int sum, int sub, int prod, int div) {
        if (array.length == index) {
            secondArray[0] = sum;
            secondArray[1] = sub;
            secondArray[2] = prod;
            secondArray[3] = div;
            return secondArray;
        }

        sum += array[index];
        sub -= array[index];
        prod *= array[index];
        div /= array[index];
        return makeCalculations(array, secondArray, ++index, sum, sub, prod, div);
    }

    private static void fillArray(int[] array, int index) {
        Scanner sc = new Scanner(System.in);
        if (index == array.length) {
            return;
        }
        System.out.println("Enter a number: ");
        array[index] = sc.nextInt();
        fillArray(array, ++index);
    }

    private static int importArrayLength() {
        Scanner sc = new Scanner(System.in);
        int num;
        do {
            System.out.println("Import the array's length: ");
            num = sc.nextInt();
        } while (num <= 0);
        return num;
    }
}
