import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

/*
Imagine a literal stack of plates. If the stack gets too high, it might topple. Therefore, in real life, we would likely
start a new stack when the previous stack exceeds some threshold. Implement a data structure SetOfStacks that mimics this.
SetOfStacks should be composed of several stacks, and should create a new stack once the previous one exceeds capacity.
SetOfStack.push() and SetOfStacks.pop() should behave identically to a single stack. Also include popAt(idx) which pops
from a specific sub-stack.
 */
public class Problem_3_3 {

    private static class SetOfStacks<E> {
        private ArrayList<Stack<E>> stacks;
        private final int limit;
        public SetOfStacks(int limit) {
            this.stacks = new ArrayList<Stack<E>>();
            this.limit = limit;
            this.stacks.add(new Stack<E>());
        }
        @Override
        public String toString() {
            StringBuilder builder = new StringBuilder();
            for(int i = 0; i < this.stacks.size(); ++i) {
                builder.append("stack[" + i + "]: " + this.stacks.get(i) + "\n");
            }
            return builder.toString();
        }

        public void push(E e) {
            for(Stack<E> s : this.stacks) {
                if(s.size() < this.limit) {
                    s.push(e);
                    return;
                }
            }
            Stack<E> newstack = new Stack<E>();
            newstack.push(e);
            this.stacks.add(newstack);
        }

        public E popAt(int idx) {
            Stack<E> s = this.stacks.get(idx);
            E e = null;
            if(!s.empty()) {
                e = s.pop();
                if(s.empty()) {
                    this.stacks.remove(idx);
                }
            }
            return e;
        }

        public E pop() {
            return this.popAt(0);
        }

    }

    public static void main(String[] args) {
        final int limit = 3;
        SetOfStacks<Character> stack = new SetOfStacks<Character>(limit);

        for(Character ch : new Character[]{'A','B','C','D','E'}) {
            stack.push(ch);
            System.out.printf("pushing '%c'\n%s\n", ch, stack);
        }

        System.out.printf("pop, got '%c'\n%s\n", stack.pop(), stack);
        System.out.printf("popAt(1), got '%c'\n%s\n", stack.popAt(1), stack);

    }

}
