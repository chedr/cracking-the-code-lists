/**
 * Implement an algorithm to delete a node in the middle of a single linked list, given
 * only access to that node.
 * EXAMPLE
 * Input: the node ‘c’ from the linked list a->b->c->d->e
 * Result: nothing is returned, but the new linked list looks like a->b->d->e
 */
public class Problem_2_3 {

    private static void remove_by(Node<Character> list, Node<Character> target) {
        Node<Character> current = list;
        Node<Character> previous = null;
        while(current != null) {
            if(current.value == target.value) {
                previous.next = current.next;
                return;
            }
            previous = current;
            current = current.next;
        }
    }

    public static void main(String[] args) {
        Node<Character> target = new Node<Character>('C', new Node<Character>('D', new Node<Character>('E', null)));
        Node<Character> list = new Node<Character>('A', new Node<Character>('B', target));
        System.out.printf("Before remove_by: %s\n", list);
        remove_by(list, target);
        System.out.printf("After remove_by:  %s\n", list);
    }

}
