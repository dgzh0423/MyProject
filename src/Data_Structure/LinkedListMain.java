package Data_Structure;

import java.util.Arrays;
import java.util.NoSuchElementException;

/**
 * @author 15304
 */
public class LinkedListMain {
    public static void main(String[] args){
        var list = new LinkedList();
        list.addLast(10);
        list.addLast(20);
        list.addLast(30);
        list.addFirst(5);
        System.out.println(Arrays.toString(list.toArray()));
        list.reverse();
        System.out.println(Arrays.toString(list.toArray()));
        System.out.println(list.indexOf(30));
        System.out.println(list.getSize());
        System.out.println(list.contains(10));
    }

    public static class LinkedList {
        private static class Node {
            private final int value;
            private LinkedList.Node next;
            public Node(int value){
                this.value = value;
            }
        }

        private LinkedList.Node first;
        private LinkedList.Node last;
        private int size;

        public void addLast(int item){
            var node = new LinkedList.Node(item);
            if (isEmpty()) {
                first = last = node;
            }
            else{
                last.next = node;
                last = node;
            }
            size++;
        }

        public void addFirst(int item){
            var node = new LinkedList.Node(item);
            if (isEmpty()){
                first = last = node;
            }
            else {
                node.next = first;
                first = node;
            }
            size++;
        }

        public int indexOf(int item){
            int index = 0;
            var current = first;
            while (current != null){
                if (current.value == item) {
                    return index;
                }
                current = current.next;
                index++;
            }
            return -1;
        }

        public boolean contains(int item){
            return indexOf(item) != -1;
        }

        public void removeFirst(){
            if (isEmpty()){
                throw new NoSuchElementException();
            }
            if (first == last) {
                first = last = null;
            }
            else {
                var second = first.next;
                first.next = null;
                first = second;
            }
            size--;
        }

        public void removeLast(){
            if (isEmpty()){
                throw new NoSuchElementException();
            }
            if (first == last) {
                first = last = null;
            }
            else {
                last = getPreviousNode(last);
                if (last != null) {
                    last.next = null;
                }
            }
            size--;
        }

        private LinkedList.Node getPreviousNode(LinkedList.Node node){
            var current = first;
            while (current != null){
                if (current.next == node){
                    return current;
                }
                current = current.next;
            }
            return null;
        }

        public void reverse(){
            if (isEmpty()){
                return;
            }

            var previous = first;
            var current = first.next;
            while (current != null){
                var next = current.next;
                current.next = previous;
                previous = current;
                current = next;
            }
            last = first;
            last.next = null;
            first = previous;
        }

        public int getKthFromTheEnd(int k){
            if (isEmpty()){
                throw new IllegalStateException();
            }
            if (k<1){
                throw new IllegalArgumentException();
            }
            var a = first;
            var b = first;
            for (int i = 0; i < k-1; i++){
                b = b.next;
                if (b == null){
                    throw new IllegalArgumentException();
                }
            }
            while (b != last){
                a = a.next;
                b = b.next;
            }
            return a.value;
        }

        private boolean isEmpty(){
            return first == null;
        }

        public int getSize(){
            return size;
        }

        public int[] toArray(){
            int[] array = new int[size];
            var current = first;
            int index = 0;
            while (current != null){
                array[index] = current.value;
                index++;
                current = current.next;
            }
            return array;
        }

    }

}
