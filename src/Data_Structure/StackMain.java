package Data_Structure;
import java.util.*;


/**
 * @author 15304
 */
public class StackMain {
    public static void main(String[] args){
        String string = "abnormal";
        StringReverse sr = new StringReverse();
        System.out.println(sr.reverse(string));

        String s2 = "<1+2>";
        Expression exp = new Expression();
        System.out.println(exp.isBalanced(s2));

        Stack stack = new Stack();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        System.out.println(stack);
        System.out.println("Peek: " + stack.peek());
        System.out.println("Pop: " + stack.pop());
        System.out.println("Pop: " + stack.pop());
        System.out.println("Pop: " + stack.pop());
        System.out.println(stack);
        System.out.println(stack.isEmpty());
    }

    public static class Stack{
        private final int[] items = new int[5];
        private int count;

        public void push(int item){
            if (count == items.length){
                throw new StackOverflowError();
            }
            items[count] = item;
            count++;
        }
        public int pop(){
            if (isEmpty()){
                throw new IllegalArgumentException();
            }
            count--;
            return items[count];
        }
        public int peek(){
            if (isEmpty()){
                throw new IllegalStateException();
            }
            return items[count-1];
        }
        public boolean isEmpty(){
            return count == 0;
        }
        @Override
        public String toString(){
            return Arrays.toString(Arrays.copyOfRange(items, 0, count));
        }
    }

    public static class StringReverse {
        public String reverse(String input){
            if (input == null){
                throw new IllegalArgumentException();
            }
            java.util.Stack<Character> stack = new java.util.Stack<>();
            for (char ch: input.toCharArray()){
                stack.push(ch);
            }
            StringBuilder reversed = new StringBuilder();
            while (!stack.empty()){
                reversed.append(stack.pop());
            }
            return reversed.toString();
        }
    }

    public static class Expression {
        private final List<Character> leftBrackets = Arrays.asList('(', '{', '[', '<');
        private final List<Character>rightBrackets = Arrays.asList(')', '}', ']', '>');
        public boolean isBalanced(String input){
            java.util.Stack<Character> stack = new java.util.Stack<>();
            for (char ch: input.toCharArray()){
                if (isLeftBracket(ch)){
                    stack.push(ch);
                }
                if (isRightBracket(ch)){
                    if (stack.empty()){return false;}

                    var top = stack.pop();
                    if (!bracketMatch(top, ch)){
                        return false;
                    }
                }
            }
            return stack.empty();
        }

        private boolean isLeftBracket(char ch){
            return leftBrackets.contains(ch);
        }
        private boolean isRightBracket(char ch){
            return rightBrackets.contains(ch);
        }
        private boolean bracketMatch(char left, char right){ return leftBrackets.indexOf(left) == rightBrackets.indexOf(right); }
    }
}
