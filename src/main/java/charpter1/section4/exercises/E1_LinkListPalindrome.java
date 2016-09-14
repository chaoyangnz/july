package charpter1.section4.exercises;

import charpter1.section1.exercises.E1_ReverseLinkList;
import org.junit.Test;

/**
 * Created by riyang on 9/14/16.
 */
public class E1_LinkListPalindrome {
    private static class Node<T> {
        public T value;
        Node next;

        public Node(T value) {
            this.value = value;
        }
    }

    private Node<Integer> head;

    public void init(int[] ints) {
        head = new Node(ints[0]);
        Node tail = head;
        for(int i=1; i < ints.length; ++i) {
            tail.next = new Node(ints[i]);
            tail = tail.next;
        }
    }

    /**
     * 1 -> 2 -> 3 -> 4 -> 4 <- 3 <- 2 <- 1
     * 1 -> 2 -> 3 -> 4 -> 5 <- 4 <- 3 <- 2 <- 1
     *
     * @return
     */
    public boolean isPalindrome() {
        Node fast = head;
        Node slow = head;

        // find middle node using fast-slow pointers
        while(fast != null) {
            slow = slow.next;
            if(fast.next != null) {
                fast = fast.next.next;
            } else {
                break;
            }
        }
        Node middle = slow;

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

    private Node reverse(Node head) {
        Node current = head;
        Node newHead = null;
        while(current != null) {
            Node next = current.next;

            current.next = newHead;
            newHead = current;
            current = next;
        }
        return newHead;
    }

    @Test
    public void test() {
        int[] ints = {1,2,3,4,4,3,2,1};
        init(ints);
        System.out.println(isPalindrome());

        int[] ints1 = {1,2,3,4,5,3,2,1};
        init(ints1);
        System.out.println(isPalindrome());

        int[] ints2 = {1,2,3,4,5,4,3,2,1};
        init(ints2);
        System.out.println(isPalindrome());

        int[] ints3 = {1,2,3,4,5,6,3,2,1};
        init(ints3);
        System.out.println(isPalindrome());
    }
}
