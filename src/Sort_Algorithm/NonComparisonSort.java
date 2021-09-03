package Sort_Algorithm;
import java.util.*;


public class NonComparisonSort {
    public static void main(String[] args){
        int[] numbers1 = {2,3,1,4,5,2,5};
        CountingSort counting = new CountingSort();
        counting.countingSort(numbers1);
        System.out.println(Arrays.toString(numbers1));

        int[] numbers2 = {7,3,1,4,6,2,5};
        BucketSort bucket = new BucketSort();
        bucket.bucketSort(numbers2,3);
        System.out.println(Arrays.toString(numbers2));
    }

    // O(n)
    // 先创建一个用于count原array中的元素个数的数组[0, 原数组最大的元素]
    // 再按顺序将元素按个数依次放入原array中
    public static class CountingSort{
        public void countingSort(int[] array){
            if (array.length == 0){
                return;
            }
            var max = getMaxValue(array);
            countingSort(array, max);
        }
        private void countingSort(int[] array, int max){
            int[] counts = new int[max + 1];
            for (var value : array){
                counts[value]++;
            }

            var k = 0;
            for (int i = 0; i < counts.length; i++){
                for (int j = 0; j < counts[i]; j++){
                    array[k++] = i;
                }
            }
        }
        private int getMaxValue(int[] array){
            var max = array[0];
            for(int i = 1; i < array.length; i++){
                if (max < array[i]){
                    max = array[i];
                }
            }
            return max;
        }
    }

    // best : O(n)         worst : O(n^2)
    // 首先创建一个buckets array
    // 再根据 item / numberOfBuckets 的值将每个元素放到对应的bucket里并排好序
    // 最后按照bucket的顺序将元素取出放回原array
    public static class BucketSort{
        public void bucketSort(int[] array, int numberOfBuckets){
            if (numberOfBuckets <= 0){
                throw new ArithmeticException();
            }
            var buckets = createBuckets(array, numberOfBuckets);
            var i = 0;
            for (var bucket: buckets){
                Collections.sort(bucket);
                for (var item: bucket){
                    array[i++] = item;
                }
            }
        }
        private List<List<Integer>> createBuckets(int[] array, int numberOfBuckets){
            List<List<Integer>> buckets = new ArrayList<>();
            for (var i = 0; i < numberOfBuckets; i++){
                buckets.add(new ArrayList<>());
            }
            for (var item: array){
                buckets.get(item / numberOfBuckets).add(item);
            }
            return buckets;
        }
    }
}
