package Data_Structure;
import java.util.Arrays;
/**
 * @author 15304
 */

public class HeapMain {
    public static void main(String[] args){
        Heap heap = new Heap();
        heap.insert(10);
        heap.insert(5);
        heap.insert(17);
        heap.insert(4);
        heap.insert(22);
        //        22
        //    17      10
        //  4    5
        System.out.println(heap.remove());
        System.out.println(heap.remove());
        System.out.println(heap.max());
        System.out.println();

        // Heap Sort
        int[] numbers = {5,3,6,1,4,2};
        Heap heap1 = new Heap();
        for (int number: numbers){
            heap1.insert(number);
        }

        for (int i = 0; i < numbers.length; i++){
            numbers[i] = heap1.remove();
        }
        System.out.println(Arrays.toString(numbers));
        System.out.println();

        // PriorityQueueWithHeap
        PriorityQueueWithHeap pq = new PriorityQueueWithHeap();
        pq.enqueue(10);
        pq.enqueue(20);
        pq.enqueue(30);
        System.out.println(pq.dequeue());


    }
    // Max Heap
    public static class Heap{
        private final int[] items = new int[10];
        private int size;

        public void insert(int value){
            if (isFull()){
                throw new IllegalStateException();
            }
            items[size++] = value;
            bubbleUp();
        }
        private void bubbleUp(){
            int index = size - 1;
            while (index > 0 && items[index] > items[parentOf(index)]) {
                swap(index, parentOf(index));
                index = parentOf(index);
            }
        }

        public int remove(){
            if (isEmpty()){
                throw new IllegalStateException();
            }
            int root = items[0];
            items[0] = items[--size];
            bubbleDown();

            return root;
        }
        private void bubbleDown(){
            int index = 0;
            while (index <= size && (!isValidParent(index))){
                int largerChildIndex = largerChildIndexOf(index);
                swap(index, largerChildIndex);
                index = largerChildIndex;
            }
        }

        private int largerChildIndexOf(int index){
            if (!hasLeftChild(index)){
                return index;
            }
            if (!hasRightChild(index)){
                return leftChildIndexOf(index);
            }
            return (leftChildOf(index) > rightChildOf(index)) ?
                    leftChildIndexOf(index) : rightChildIndexOf(index);
        }
        private int leftChildOf(int index){
            return items[leftChildIndexOf(index)];
        }
        private int leftChildIndexOf(int index){
            return index * 2 + 1;
        }
        private int rightChildOf(int index){
            return items[rightChildIndexOf(index)];
        }
        private int rightChildIndexOf(int index){
            return index * 2 + 2;
        }
        private boolean hasLeftChild(int index){
            return leftChildIndexOf(index) <= size;
        }
        private boolean hasRightChild(int index){
            return rightChildIndexOf(index) <= size;
        }

        private int parentOf(int index){
            return (index-1) / 2;
        }
        private boolean isValidParent(int index){
            if (!hasLeftChild(index)){
                return true;
            }
            if (!hasRightChild(index)){
                return items[index] >= leftChildOf(index);
            }
            return items[index] >= leftChildOf(index) && items[index] >= rightChildOf(index);
        }

        private boolean isFull(){
            return size == items.length;
        }
        private boolean isEmpty(){
            return size == 0;
        }
        private void swap(int first, int second){
            var temp = items[first];
            items[first] = items[second];
            items[second] = temp;
        }
        public int max(){
            if (isEmpty()){
                throw new IllegalStateException();
            }
            return items[0];
        }
    }

    public static class PriorityQueueWithHeap{
        private Heap heap = new Heap();
        public void enqueue(int item){
            heap.insert(item);
        }
        public int dequeue(){
            if (isEmpty()){
                throw new IllegalStateException();
            }
            return heap.remove();
        }
        public boolean isEmpty(){
            return heap.isEmpty();
        }
    }
}
