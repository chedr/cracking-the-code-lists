/**
 * Given a circular linked list, implement an algorithm which returns node at the beginning of the loop.
 * Input: A->B->C->D->E->C; Output: C
 */
public class Problem_2_5 {

    private static Character loop_start(Node<Character> list) {
        //So, since we're dealing with characters I'm just going to use flat memory (256 bytes) to account for
        //every 8 bit value. You could use a bit based memory too.
        boolean[] memory = new boolean[256];
        while(true) {
            if(memory[list.value])
                return list.value;
            else
                memory[list.value] = true;
            list = list.next;
        }
    }

    private static Node<Character> make_broken_list() {
        Node<Character> loop = new Node<Character>('C', new Node<Character>('D', new Node<Character>('E', null)));
        Node<Character> list = new Node<Character>('A', new Node<Character>('B', loop));
        Node<Character> current = list;
        while(current != null) {
            if(current.next == null) {
                current.next = loop;
                break;
            }
            current = current.next;
        }
        return list;
    }

    public static void main(String[] args) {
        Node<Character> list = make_broken_list();
        System.out.println(loop_start(list));
    }

}
