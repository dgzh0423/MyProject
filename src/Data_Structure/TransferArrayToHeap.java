package Data_Structure;
import java.util.Arrays;
/**
 * @author 15304
 */

public class TransferArrayToHeap {
    public static void main(String[] args){
        int[] numbers = {5,3,8,4,1,2};
        MaxHeap.heapify(numbers);
        System.out.println(Arrays.toString(numbers));
        System.out.println(MaxHeap.getKthLargest(numbers, 2));

    }
public static class MaxHeap {
    public static void heapify(int[] array) {
        int lastParentIndex = array.length / 2 - 1;
        for (int i = lastParentIndex; i >= 0; i--) {
            heapify(array, i);
        }
    }

    private static void heapify(int[] array, int index) {
        int largerIndex = index;

        int leftIndex = index * 2 + 1;
        if (leftIndex < array.length && array[leftIndex] > array[largerIndex]) {
            largerIndex = leftIndex;
        }

        int rightIndex = index * 2 + 2;
        if (rightIndex < array.length && array[rightIndex] > array[largerIndex]) {
            largerIndex = rightIndex;
        }

        if (index == largerIndex) {
            return;
        }

        swap(array, index, largerIndex);
        heapify(array, largerIndex);
    }

    private static void swap(int[] array, int first, int second) {
        var temp = array[first];
        array[first] = array[second];
        array[second] = temp;
    }

    public static int getKthLargest(int[] array, int k){
        if (k < 1 || k > array.length){
            throw new IllegalStateException();
        }
        HeapMain.Heap heap = new HeapMain.Heap();
        for (int number : array){
            heap.insert(number);
        }
        for (int i = 0; i < k -1; i++){
            heap.remove();
        }
        return heap.max();
    }
    }
}
