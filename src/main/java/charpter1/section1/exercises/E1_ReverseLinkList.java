package charpter1.section1.exercises;

import org.junit.Test;

import static util.LinkedListUtil.*;

/**
 * 1. 链表翻转。给出一个链表和一个数k，比如，链表为1→2→3→4→5→6，k=2，则翻转后2→1→6→5→4→3，
 * 若k=3，翻转后3→2→1→6→5→4，若k=4，翻转后4→3→2→1→6→5，用程序实现。
 * X^t Y^t = (YX)^t
 */
public class E1_ReverseLinkList {

    /**
     * Time complexity: O(N + k)
     *
     * @param head
     * @param k
     */
    public void reverseHalves(final Node head, final int k) {
        Node current = head;
        int count = 1;
        boolean tail = false;

        Node newHead = null; // final head after reverse
        while(current != null) {

            if(current.next == null && !tail) { // original tail
                current.next = head;
                tail = true;
            }

            if(count == k) { // found the kth node: cut the linked list after this node
                Node next = current.next;
                current.next = null;
                current = next;
            } else if(count > k) { // reverse after cutting node
                Node next = current.next;
                current.next = newHead;
                newHead = current;
                current = next;
            } else {
                current = current.next;
            }

            count++;
        }

        print(newHead);
    }

    @Test
    public void test() {
        Node head = toLinkedList(new Integer[] {1,2,3,4,5,6});
        reverseHalves(head, 2);

        head = toLinkedList(new Integer[] {1,2,3,4,5,6});
        reverseHalves(head, 3);

        head = toLinkedList(new Integer[] {1,2,3,4,5,6});
        reverseHalves(head, 4);
    }
}
