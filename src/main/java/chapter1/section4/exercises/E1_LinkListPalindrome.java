package chapter1.section4.exercises;

import org.junit.Test;
import util.LinkedListUtil.*;

import static util.LinkedListUtil.*;

/**
 * Created by riyang on 9/14/16.
 */
public class E1_LinkListPalindrome {

    /**
     * 1 -> 2 -> 3 -> 4 -> 4 <- 3 <- 2 <- 1
     * 1 -> 2 -> 3 -> 4 -> 5 <- 4 <- 3 <- 2 <- 1
     *
     * @return
     */
    public boolean isPalindrome(Node head) {
        // find middle node using fast-slow pointers
        Node middle = findMiddle(head);

        // reverseHalves 2nd half
        Node tail = reverse(middle);

        // two pointers: compare from two sides to middle
        Node leftCurrent = head;
        Node rightCurrent = tail;
        while(leftCurrent != null && rightCurrent !=null) {
            if(!leftCurrent.value.equals(rightCurrent.value)) {
                return false;
            } else {
                leftCurrent = leftCurrent.next;
                rightCurrent = rightCurrent.next;
            }
        }
        return true;
    }

    @Test
    public void test() {
        Integer[] ints = {1,2,3,4,4,3,2,1};
        Node head = toLinkedList(ints);
        System.out.println(isPalindrome(head));

        Integer[] ints1 = {1,2,3,4,5,3,2,1};
        Node head1 = toLinkedList(ints1);
        System.out.println(isPalindrome(head1));

        Integer[] ints2 = {1,2,3,4,5,4,3,2,1};
        Node head2 = toLinkedList(ints2);
        System.out.println(isPalindrome(head2));

        Integer[] ints3 = {1,2,3,4,5,6,3,2,1};
        Node head3 = toLinkedList(ints3);
        System.out.println(isPalindrome(head3));
    }
}
