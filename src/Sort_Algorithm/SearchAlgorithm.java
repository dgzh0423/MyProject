package Sort_Algorithm;

public class SearchAlgorithm {
    public static void main(String[] args){
        int[] numbers1 = {7,3,1,4,6,2,5};
        LinearSearch linear = new LinearSearch();
        System.out.println(linear.linearSearch(numbers1, 3));

        int[] numbers2 = {1,2,3,4,5,6,7};
        BinarySearch binary = new BinarySearch();
        System.out.println(binary.binarySearchRecursive(numbers2, 3));
        System.out.println(binary.binarySearchIterative(numbers2, 3));

        int[] numbers3 = {1,2,3,4,5,6,7};
        TernarySearch ternary = new TernarySearch();
        System.out.println(ternary.ternarySearch(numbers3, 4));

        int[] numbers4 = {1,2,3,4,5,6,7};
        JumpSearch jump = new JumpSearch();
        System.out.println(jump.jumpSearch(numbers4, 5));

        int[] numbers5 = {1,2,3,4,5,6,7};
        ExponentialSearch exponential = new ExponentialSearch();
        System.out.println(exponential.exponentialSearch(numbers5, 6));
    }

    public static class LinearSearch{
        public int linearSearch(int[] array, int target){
            for (var i = 0; i < array.length; i++){
                if (array[i] == target){
                    return i;
                }
            }
            return -1;
        }
    }

    //用于排好序的数组
    public static class BinarySearch{
        public int binarySearchRecursive(int[] array, int target){
            return binarySearchRecursive(array, target, 0, array.length - 1);
        }
        private static int binarySearchRecursive(int[] array, int target, int left, int right){
            if (right < left){
                return -1;
            }
            int middle = (left + right) / 2;
            if (array[middle] == target){
                return middle;
            }
            if (target < array[middle]){
                return binarySearchRecursive(array, target, left, middle - 1);
            }
            return binarySearchRecursive(array, target, middle + 1, right);
        }

        public int binarySearchIterative(int[] array, int target){
            var left = 0;
            var right = array.length - 1;
            while(left <= right){
                var middle = (left + right) / 2;

                if (array[middle] == target){
                    return middle;
                }
                if (target < array[middle]){
                    right = middle - 1;
                }
                else {
                    left = middle + 1;
                }
            }
            return -1;
        }
    }

    // 用于排好序的数组：三分数组
    public static class TernarySearch{
        public int ternarySearch(int[] array, int target){
            return ternarySearch(array, target, 0, array.length - 1);
        }
        private int ternarySearch(int[] array, int target, int left, int right){
            if (left > right){
                return -1;
            }
            int partitionSize = (right - left) / 3;
            int mid1 = left + partitionSize;
            int mid2 = right - partitionSize;

            if (target == array[mid1]){
                return mid1;
            }
            if (target == array[mid2]){
                return mid2;
            }
            if (target < array[mid1]){
                return ternarySearch(array, target, left, mid1 - 1);
            }
            if (target > array[mid2]){
                return  ternarySearch(array, target, mid2 + 1, right);
            }
            return ternarySearch(array, target, mid1 + 1, mid2 - 1);
        }
    }

    // 用于排好序的数组： 先分成多个block， 再判断target在哪个block里，最后用linearSearch找target
    public static class JumpSearch{
        public int jumpSearch(int[] array, int target){
            int blockSize = (int) Math.sqrt(array.length);
            int start = 0;
            int next = blockSize;
            while(start < array.length && array[next - 1] < target){
                start = next;
                next += blockSize;
                if (next > array.length){
                    next = array.length;
                }
            }
            for(var i = start; i < next; i++){
                if (array[i] == target){
                    return i;
                }
            }
            return -1;
        }
    }

    //用于排好序的数组： 从bound = 1开始
    //如果target不在范围里，就bound * 2，直到target落在范围里或者bound > array.length
    //再用binarySearchRecursive找target
    public static class ExponentialSearch{
        public int exponentialSearch(int[] array, int target){
            int bound = 1;
            while(bound < array.length && array[bound] < target){
                bound *= 2;
            }
            int left = bound / 2;
            int right = Math.min(bound, array.length - 1);
            return BinarySearch.binarySearchRecursive(array, target, left, right);
        }
    }
}