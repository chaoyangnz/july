package charpter1.section1.exercises;

import org.junit.Test;

/**
 * 1. 链表翻转。给出一个链表和一个数k，比如，链表为1→2→3→4→5→6，k=2，则翻转后2→1→6→5→4→3，
 * 若k=3，翻转后3→2→1→6→5→4，若k=4，翻转后4→3→2→1→6→5，用程序实现。
 * X^t Y^t = (YX)^t
 */
public class E1_ReverseLinkList {
    private static class Node<T> {
        public T value;
        Node next;

        public Node(T value) {
            this.value = value;
        }
    }

    public void init(int[] ints) {
        head = new Node(ints[0]);
        Node tail = head;
        for(int i=1; i < ints.length; ++i) {
            tail.next = new Node(ints[i]);
            tail = tail.next;
        }
    }

    private Node<Integer> head;

    public void reverse(int k) {
        Node current = head;
        int count = 1;
        Node tail = null;
        Node newHead = null;
        while(current != null) {
            if(count == k) {
                newHead = current.next;
                current.next = null;
                current = newHead;
            }
            if(current.next == null) {
                tail = current;
            }
            count++;
            current = current.next;
        }
        tail.next = head;
        head = newHead;
        reverse();

        Node node = head;
        while(node != null) {
            System.out.print(node.value + "\t");
            node = node.next;
        }
        System.out.println();

    }

    private void reverse() {
        Node current = head;
        Node newHead = null;
        while (current != null) {
            Node prev = current;
            current = current.next;
            prev.next = newHead;
            newHead = prev;
        }
        head = newHead;
    }

    @Test
    public void test() {
        init(new int[] {1,2,3,4,5,6});
        reverse(2);

        init(new int[] {1,2,3,4,5,6});
        reverse(3);

        init(new int[] {1,2,3,4,5,6});
        reverse(4);
    }
}
