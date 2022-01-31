package arrays;

import java.util.Arrays;
import java.util.Scanner;

public class MinimumElementChallenge {

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int count = scanner.nextInt();
        scanner.nextLine();
        int[] array = readIntegers(count);
        System.out.println(findMin(array));
    }

    public static int[] readIntegers(int count){
        int[] array = new int[count];

        for (int i=0; i<array.length; i++ ){
            array[i] = scanner.nextInt();
            scanner.nextLine();
        }
        return array;
    }

    public static int findMin(int[] array){
        return Arrays.stream(array).min().getAsInt();
    }
}
