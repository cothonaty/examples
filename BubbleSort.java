/**
 * @author John L
 */
public class BubbleSort {
    static int count = 0;

    public static void main(String[] args) {
        int[] array = {5, 4, 3, 8, 7, 6, 8, 8, 9, 0, 1};
        bubbleSortForEach(array);
        System.out.println("For-Each: ");

        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println("\n" + count);

        int[] array2 = {5, 4, 3, 8, 7, 6, 8, 8, 9, 0, 1};
        count = 0;
        System.out.println("While: ");
        bubbleSortWhile(array2);
        for (int num : array2) {
            System.out.print(num + " ");
        }
        System.out.println("\n" + count);
    }

    static void bubbleSortWhile(int[] array2) {
        boolean swapped = true;
        while (swapped) {
            swapped = false;
            for (int i = 0; i < array2.length - 1; i++) {
                if (array2[i] > array2[i + 1]) {
                    int temp = array2[i];
                    array2[i] = array2[i + 1];
                    array2[i + 1] = temp;
                    swapped = true;
                    count++;
                }
            }
        }
    }
    static void bubbleSortForEach(int[] array) {
        int n = array.length;
        boolean swapped;

        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    count++;
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
    }
}
