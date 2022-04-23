import java.util.Random;

public class Main {
    public static void main(String[] args) {

        Random random = new Random();
        int[] intArray = new int[10];

        // Generating random elements between -255 and 255 for array
        for (int i = 0; i < intArray.length; i++) {
            intArray[i] = random.nextInt(-255,255);
        }

        mergeSort(intArray, 0, intArray.length);

        // Printing array
        for (int i = 0; i < intArray.length; i++) {
            System.out.println(intArray[i]);
        }
    }

    public static void mergeSort(int[] input, int start, int end) {
        if (end - start < 2){
            return;
        }

        int mid = (start + end) / 2;

        mergeSort(input, start, mid);
        mergeSort(input, mid, end);
        merge(input, start, mid, end);
    }

    public static void merge(int[] input, int start, int mid, int end) {
        if (input[mid - 1] <= input[mid]){
            return;
        }

        int i = start;
        int j = mid;
        int tempIndex = 0;

        int[] temp = new int[end - start];

        while (i < mid && j < end){
            if (input[i] <= input[j]){
                temp[tempIndex++] = input[i++];
            }
            else{
                temp[tempIndex++] = input[j++];
            }
        }

        System.arraycopy(input, i, input, start + tempIndex, mid - i);
        System.arraycopy(temp, 0, input, start, tempIndex);
    }
}