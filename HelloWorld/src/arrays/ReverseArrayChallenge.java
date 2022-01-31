package arrays;

import java.util.Arrays;

public class ReverseArrayChallenge {
    private static int[] array = new int[] {10,20,30,60,88};
    private static int[] reversedArray = new int[array.length];

    public static void main(String[] args) {
        System.out.println(Arrays.toString(array));
        reverse(array);
        System.out.println(Arrays.toString(reversedArray));
    }

    public static void reverse(int[] array){
        for (int i=0; i<array.length; i++){
            reversedArray[i] = array[(array.length-1)-i];
        }
    }
}
