import java.util.*;

/**
 * Write a program to sort a stack in ascending order. You should not make any assumptions about how the stack is
 * implemented. Only use push, pop, peek and empty functions.
 */
public class Problem_3_6 {

    private static void sort_stack(Stack stack) {
        Queue buffer = new PriorityQueue(); //Don't think this is what they had in mind!
        while(!stack.empty()) {
            buffer.add(stack.pop());
        }
        while(!buffer.isEmpty()) {
            stack.push(buffer.remove());
        }
    }

    public static void main(String[] args) {
        final Character[] chrs = new Character[]{'A','B','C','D','E'};
        Stack<Character> stack = new Stack<Character>();
        for(Character ch : chrs) {
            stack.push(ch);
        }
        Collections.shuffle(stack);
        System.out.printf("Before: %s\n", stack);
        sort_stack(stack);
        System.out.printf("After:  %s\n", stack);
    }
}
