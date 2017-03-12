import java.util.Stack;

/**
 * Implement a MyQueue class which implements a queue using two stacks.
 */
public class Problem_3_5 {

    private static class MyQueue<E> {
        private Stack<E> stack1, stack2;
        public MyQueue() {
            this.stack1 = new Stack<E>();
            this.stack2 = new Stack<E>();
        }
        public void enqueue(E e) {
            this.stack1.push(e);
        }
        public E dequeue() {
            if(!this.stack2.empty()) {
                return this.stack2.pop();
            }
            while(!this.stack1.empty()) {
                this.stack2.push(this.stack1.pop());
            }
            return this.stack2.pop();
        }
        public boolean empty() {
            return this.stack1.empty() && this.stack2.empty();
        }
    }

    public static void main(String[] args) {
        final Character[] chrs = new Character[]{'A','B','C','D','E'};
        MyQueue<Character> queue = new MyQueue<Character>();
        for(Character ch : chrs) {
            System.out.printf("enqueue -> %c\n", ch);
            queue.enqueue(ch);
        }
        while(!queue.empty()) {
            System.out.printf("dequeue -> %c\n", queue.dequeue());
        }
    }
}
