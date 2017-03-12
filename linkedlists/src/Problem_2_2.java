/**
 * Implement an algorithm to find the nth to last element of a singly linked list.
 */
public class Problem_2_2 {

    private static void remove_nlast(Node<Integer> list, int n) {
        //Since this is not a double linked list we can't just count to the end and go back n.
        int i;
        Node<Integer> current = list;
        Node<Integer> previous = null;
        for(i = 0; current != null; current = current.next, ++i);

        current = list;
        for(int j = 0; j < (i - n); previous = current, current = current.next, ++j);
        previous.next = current.next;
    }

    public static void main(String[] args) {
        final int nlast = 3;
        Node<Integer> list = Node.make_list();
        System.out.printf("remove_nlast(list, %d) Before: %s\n", nlast, list);
        remove_nlast(list, nlast);
        System.out.printf("remove_nlast(list, %d) After:  %s\n\n", nlast, list);
    }

}
