/**
 * Write code to remove duplicates from an unsorted linked list.
 * How would you solve this problem if a temporary buffer is not allowed?
 */
public class Problem_2_1 {

    private static boolean contains(Node<Integer> list, int k, int n) {
        Node<Integer> current = list;
        for(int i = 0; i < n && current != null; ++i) {
            if(current.value == k) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    private static void remove_dupes(Node<Integer> list) {
        //You could use a hashmap and count the occurrences and remove the current element if it's
        //currently in the map.
        //Unfortunately, the standard Java linked list impl does not allow access to the node objects.
        //Things like list.remove(idx) or list.get(idx) would result in O(n) behavior.
        //Instead, we will opt in for the algorithm that does not use a memory buffer as the question suggests and
        //use our own linkedlist impl.
        Node<Integer> current = list;
        Node<Integer> previous = null;
        int n = 0;
        while(current != null) {
            if(contains(list, current.value, n)) {
                previous.next = current.next;
                current = current.next;
                continue;
            }
            previous = current;
            current = current.next;
            ++n;
        }
    }

    public static void main(String[] args) {
        Node<Integer> list = Node.make_list();
        System.out.printf("remove_dupes Before: %s\n", list);
        remove_dupes(list);
        System.out.printf("remove_dupes After:  %s\n\n", list);
    }

}
