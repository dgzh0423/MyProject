package Sort_Algorithm;
import java.util.Arrays;

public class ComparisonSort {
    public static void main(String[] args){
        int[] numbers1 = {7,3,1,4,6,2,5};
        BubbleSort bubble = new BubbleSort();
        bubble.bubbleSort(numbers1);
        System.out.println(Arrays.toString(numbers1));

        int[] numbers2 = {7,3,1,4,6,2,5};
        SelectionSort selection = new SelectionSort();
        selection.selectionSort(numbers2);
        System.out.println(Arrays.toString(numbers2));

        int[] numbers3 = {7,3,1,4,6,2,5};
        InsertionSort insertion = new InsertionSort();
        insertion.insertionSort(numbers3);
        System.out.println(Arrays.toString(numbers3));

        int[] numbers4 = {7,3,1,4,6,2,5};
        MergeSort merge = new MergeSort();
        merge.mergeSort(numbers4);
        System.out.println(Arrays.toString(numbers4));

        int[] numbers5 = {7,3,1,4,6,2,5};
        Quicksort quick = new Quicksort();
        quick.quickSort(numbers5);
        System.out.println(Arrays.toString(numbers5));
    }

    // best O(n)     worst O(n^2)
    // 从左到右,两两比较,swap它们
    // 每次遍历完,最大的值都会放到数组最右边
    public static class BubbleSort{
        public void bubbleSort(int[] array){
            boolean isSorted;
            for (var i = 0; i < array.length; i++){
                isSorted = true;
                for (var j = 1; j < array.length - i; j++){
                    if (array[j] < array[j-1]){
                        swap(array, j, j-1);
                        isSorted = false;
                    }
                }
                if (isSorted){
                    return;
                }
            }
        }
        private static void swap(int[] array, int first, int second) {
            var temp = array[first];
            array[first] = array[second];
            array[second] = temp;
        }
    }

    // best O(n^2)     worst O(n^2)
    // 每次遍历unsorted部分选出最小的元素，并与unsorted部分最左边的元素swap
    public static class SelectionSort{
        public void selectionSort(int[] array){
            for (int i = 0; i < array.length; i++){
                var minIndex = findMinIndex(array,i);
                swap(array, minIndex, i);
            }
        }

        public int findMinIndex(int[] array, int i){
            var minIndex = i;
            for (var j = i; j < array.length; j++){
                if (array[j] < array[minIndex]){
                    minIndex = j;
                }
            }
            return minIndex;
        }

        private static void swap(int[] array, int first, int second) {
            var temp = array[first];
            array[first] = array[second];
            array[second] = temp;
        }
    }

    // best O(n)     worst O(n^2)
    // 从index = 1的元素开始, 向sorted部分insert
    // 当current的元素小于sorted部分的元素时,将这些大于的元素向右shift一位
    // 最后将current的元素insert到空出来的位置
    public static class InsertionSort{
        public void insertionSort(int[] array){
            for (int i = 1; i < array.length; i++){
                int current = array[i];
                int j = i - 1;
                while(j >= 0 && array[j] > current){
                    array[j + 1] = array[j];
                    j--;
                }
                array[j + 1] = current;
            }
        }
    }

    // best O(nlog(n))     worst O(nlog(n))
    // divide: 先将array一直二分,分到不能再分
    // conquer: 再分别递归地将左右两边的sub-arrays合并排序
    // 最后再将已排好序的左右两个sub-arrays合并排序
    public static class MergeSort{
        public void mergeSort(int[] array){
            if (array.length < 2){
                return;
            }

            var middle = array.length / 2;
            var left = getLeft(array, middle);
            var right = getRight(array, middle);

            mergeSort(left);
            mergeSort(right);

            merge(left, right, array);
        }

        private int[] getLeft(int[] array, int middle){
            int [] left = new int[middle];
            for (int i = 0; i < middle; i++){
                left[i] = array[i];
            }
            return left;
        }
        private int[] getRight(int[] array, int middle){
            int[] right = new int[array.length - middle];
            for (int i = middle; i < array.length; i++){
                right[i - middle] = array[i];
            }
            return right;
        }

        private void merge(int[] left, int[] right, int[] result){
            int i = 0, j = 0, k = 0;
            while(i < left.length && j < right.length){
                if (left[i] <= right[j]){
                    result[k++] = left[i++];
                }
                else{
                    result[k++] = right[j++];
                }
            }
            while(i < left.length){
                result[k++] = left[i++];
            }
            while(j < right.length){
                result[k++] = right[j++];
            }
        }
    }

    // best O(nlog(n))     worst O(n^2)
    // 先设定一个pivot, 再将array划分成左右两个sub-arrays，左边的元素都<pivot, 右边的元素都>pivot,此时pivot的位置就排好了
    // 再递归地使用上面的操作来排序左边subarray的元素和右边subarray的元素
    public static class Quicksort{
        public void quickSort(int[] array){
            quickSort(array, 0, array.length - 1);
        }
        private void quickSort(int[] array, int start, int end){
            if (start >= end){
                return;
            }

            var boundary = partition(array, start, end);
            quickSort(array, start, boundary - 1);
            quickSort(array, boundary + 1, end);
        }

        private int partition(int[] array, int start, int end){
            var pivot = array[end];
            var boundary = start - 1;
            for(var i = start; i <= end; i++){
                if (array[i] <= pivot){
                    swap(array, i, ++boundary);
                }
            }
            return boundary;
        }

        private static void swap(int[] array, int first, int second) {
            var temp = array[first];
            array[first] = array[second];
            array[second] = temp;
        }
    }
}
