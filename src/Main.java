
import java.util.Random;
public class Main {
    private static final Random random = new Random();
    public static void main(String[] args) {
//        double timeForBobbleSort = timeForBubbleSort(5);
//        System.out.println("Время пузырьковой сортировки: "+timeForBobbleSort);
//        double timeForInsperetionSort = timeForSortInsertion(5);
//        System.out.println("Время вставочной сортировки: "+timeForInsperetionSort);
//        double timeForSelectSort = timeForSortSelection(5);
//        System.out.println("Время перебором: "+timeForSelectSort);
    }
    private static void swapElements(int[] arr, int indexA, int indexB) {
        int tmp = arr[indexA];
        arr[indexA] = arr[indexB];
        arr[indexB] = tmp;
    }
//    public static void sortSelection(int[] arr) {
//        for (int i = 0; i < arr.length - 1; i++) {
//            int minElementIndex = i;
//            for (int j = i + 1; j < arr.length; j++) {
//                if (arr[j] < arr[minElementIndex]) {
//                    minElementIndex = j;
//                }
//            }
//            swapElements(arr, i, minElementIndex);
//        }
//    }
//    public static void sortInsertion(int[] arr) {
//        for (int i = 1; i < arr.length; i++) {
//            int temp = arr[i];
//            int j = i;
//            while (j > 0 && arr[j - 1] >= temp) {
//                arr[j] = arr[j - 1];
//                j--;
//            }
//            arr[j] = temp;
//        }
//    }
//    public static void sortBubble(int[] arr) {
//        for (int i = 0; i < arr.length - 1; i++) {
//            for (int j = 0; j < arr.length - 1 - i; j++) {
//                if (arr[j] > arr[j + 1]) {
//                    swapElements(arr, j, j + 1);
//                }
//            }
//        }
//    }
//    private static double timeForBubbleSort(int iter){
//        double sum = 0;
//        for (int i = 0; i<iter;i++){
//            int[] array = generateArrays(100000);
//            long start = System.currentTimeMillis();
//            sortBubble(array);
//            long end = System.currentTimeMillis() - start;
//            sum+=end;
//        }
//        return sum/iter;
//    }
//    private static double timeForSortInsertion(int iter){
//        double sum = 0;
//        for (int i = 0; i<iter;i++){
//            int[] array = generateArrays(100000);
//            long start = System.currentTimeMillis();
//            sortInsertion(array);
//            long end = System.currentTimeMillis() - start;
//            sum+=end;
//        }
//        return sum/iter;
//    }
//    private static double timeForSortSelection(int iter){
//        double sum = 0;
//        for (int i = 0; i<iter;i++){
//            int[] array = generateArrays(100000);
//            long start = System.currentTimeMillis();
//            sortSelection(array);
//            long end = System.currentTimeMillis() - start;
//            sum+=end;
//        }
//        return sum/iter;
//    }
    private static int[] generateArrays(int bound){
        int[] array = new int[bound];
            for (int i =0; i < bound;i++){
                array[i] = random.nextInt(-100,100);
            }
            return array;
    }
}
