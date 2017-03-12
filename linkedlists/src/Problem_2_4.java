/**
 * You have two numbers represented by a linked list, where each node contains a single digit.
 * The digits are stored in reverse order, such that the 1's digit is at the head of the list.
 * Write a function that adds the two numbers and returns the sum as a linked list:
 * Input: (3->1->5) + (5->9->2) = (8->0->8)
 */
public class Problem_2_4 {

    private static Node<Integer> sum_list(Node<Integer> num1, Node<Integer> num2) {
        Node<Integer> p1, p2, result;
        p1 = num1;
        p2 = num2;
        result = new Node<Integer>(0, null);
        Node<Integer> prev_ptr = null;
        Node<Integer> result_ptr = result;
        boolean carry = false;
        while(true) {
            if(p1 == null && p2 == null && !carry) {
                prev_ptr.next = null; //remove trailing 0
                break;
            }

            int sum = 0;

            if(p1 != null) {
                sum += p1.value;
                p1 = p1.next;
            }

            if(p2 != null) {
                sum += p2.value;
                p2 = p2.next;
            }

            if(carry) {
                sum += 1;
            }

            if(sum > 9) {
                sum = sum - 10;
                carry = true;
            } else {
                carry = false;
            }

            result_ptr.value = sum;
            result_ptr.next = new Node<Integer>(0, null);
            prev_ptr = result_ptr;
            result_ptr = result_ptr.next;
        }
        return result;
    }

    public static void main(String[] args) {
        Node<Integer> num1 = new Node<Integer>(3, new Node<Integer>(1, new Node<Integer>(5, null)));
        Node<Integer> num2 = new Node<Integer>(5, new Node<Integer>(9, new Node<Integer>(2, null)));
        System.out.printf("%s + %s = %s\n", num1, num2, sum_list(num1, num2));
    }

}
