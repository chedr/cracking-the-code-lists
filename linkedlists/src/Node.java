/**
 * Created by user on 9/26/14.
 */
public class Node<E> {
    public E value;
    public Node next; //encapsulation is overrated ;)
    public Node(E value, Node next) {
        this.value = value;
        this.next = next;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        Node<E> current = this;
        while(current != null) {
            builder.append(current.value + " ");
            current = current.next;
        }
        return builder.toString();
    }

    public static Node<Integer> make_list() {
        return new Node(6, new Node(5, new Node(6, new Node(3, new Node(5, null)))));
    }
}