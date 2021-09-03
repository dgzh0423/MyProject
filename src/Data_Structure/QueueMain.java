package Data_Structure;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Stack;

/**
 * @author 15304
 */

public class QueueMain {
    public static void main(String[] args){
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(10);
        queue.add(20);
        queue.add(30);
        System.out.println(queue);
        reverseQueue(queue);
        System.out.println(queue);
        System.out.println();

        ArrayQueue arrayQueue = new ArrayQueue(5);
        arrayQueue.enqueue(40);
        arrayQueue.enqueue(50);
        arrayQueue.enqueue(60);
        arrayQueue.enqueue(70);
        arrayQueue.enqueue(80);
        System.out.println(arrayQueue);
        System.out.println(arrayQueue.dequeue());
        System.out.println(arrayQueue.dequeue());
        System.out.println(arrayQueue);
        arrayQueue.enqueue(90);
        arrayQueue.enqueue(100);
        System.out.println(arrayQueue);
        System.out.println(arrayQueue.peek());
        System.out.println(arrayQueue.isFull());
        System.out.println();

        QueueWithTwoStacks queue2 = new QueueWithTwoStacks();
        queue2.enqueues(10);
        queue2.enqueues(20);
        queue2.enqueues(30);
        System.out.println(queue2);
        System.out.println(queue2.dequeues());
        System.out.println(queue2);
        System.out.println(queue2.peeks());
        System.out.println(queue2.areEmpty());
        System.out.println();

        PriorityQueue priorityQueue = new PriorityQueue();
        priorityQueue.add(3);
        priorityQueue.add(5);
        priorityQueue.add(1);
        priorityQueue.remove();
        System.out.println(priorityQueue);
    }

    // Reverse a queue using a Stack
    public static void reverseQueue(Queue<Integer> queue){
        Stack<Integer> stack = new Stack<>();
        while (!queue.isEmpty()){
            stack.push(queue.remove());
        }
        while (!stack.isEmpty()){
            queue.add(stack.pop());
        }
    }

    public static class ArrayQueue{ // Building a queue using an array
        private int[]items;
        private int rear;
        private int front;
        private int count;

        public ArrayQueue(int capacity){
            items = new int[capacity];
        }

        public void enqueue(int item){
            if (count == items.length){
                throw new IllegalStateException();
            }
            items[rear] = item;
            rear = (rear+1) % items.length;
            count++;
        }

        public int dequeue(){
            var item = items[front];
            items[front] = 0;
            front = (front+1) % items.length;
            count--;
            return item;
            /*
            return items[front++];
            */
        }

        public int peek(){
            if (isEmpty()){
                throw new IllegalStateException();
            }
            return items[front];
        }
        public boolean isEmpty(){
            return count == 0;
        }
        public boolean isFull(){
            return count == items.length;
        }
        @Override
        public String toString(){
            return Arrays.toString(items);
        }
    }

    public static class QueueWithTwoStacks{ // Building a queue using two stacks
        private Stack<Integer> stack1 = new Stack<>();
        private Stack<Integer> stack2 = new Stack<>();

        public void enqueues(int item){
            stack1.push(item);
        }

        public int dequeues(){
            if (areEmpty()){
                throw new IllegalStateException();
            }
            if (stack2.isEmpty()){
                while (!stack1.isEmpty()){
                    stack2.push(stack1.pop());
                }
            }
            return stack2.pop();
        }

        public int peeks(){
            if (areEmpty()){
                throw new IllegalStateException();
            }
            if (stack2.isEmpty()){
                while (!stack1.isEmpty()){
                    stack2.push(stack1.pop());
                }
            }
            return stack2.peek();
        }

        public boolean areEmpty(){
            return stack1.isEmpty() && stack2.isEmpty();
        }
        @Override
        public String toString(){
            if (stack1.isEmpty()){
                return Arrays.toString(stack2.toArray());
            }
            else{
                return Arrays.toString(stack1.toArray());
            }
        }
    }

    public static class PriorityQueue{ // Building a PriorityQueue using an Array
        private final int[] items1 = new int[5];
        private int count;

        public void add(int item){
            if (isFull()){
                throw new IllegalStateException();
            }
            var i = shiftItemsToInsert(item);
            items1[i] = item;
            count++;
        }
        public int shiftItemsToInsert(int item){
            int i;
            for (i = count - 1; i>=0; i--){
                if (items1[i] > item){
                    items1[i+1] = items1[i];
                }
                else {
                    break;
                }
            }
            return i + 1;
        }

        public void remove(){
            if (isEmpty()){
                throw new IllegalStateException();
            }
            --count;
            var prior = items1[count];
            System.out.println(prior);
            items1[count] = 0;
        }

        public boolean isEmpty(){
            return count == 0;
        }
        public boolean isFull(){
            return count == items1.length;
        }
        @Override
        public String toString(){
            return Arrays.toString(items1);
        }
    }
}
