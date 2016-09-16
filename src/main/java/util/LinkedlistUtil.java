package util;

import org.junit.Test;

/**
 * Created by richard on 9/16/16.
 */
public class LinkedListUtil {
    public static class Node<T> {
        public T value;
        public Node<T> next;
    }

    /**
     * Initialize a linked list from an array
     *
     * @param arr
     * @param <T>
     * @return
     */
    public static <T> Node<T> toLinkedList(T[] arr) {
        Node<T> head = null;

        Node<T> tail = head;
        for(T elem : arr) {
            Node<T> node = new Node<T>();
            node.value = elem;
            if(head == null) {
                head = node;
            } else {
                tail.next = node;
            }
            tail = node;

        }
        return head;
    }

    public static <T> void print(Node<T> head) {
        Node<T> current = head;
        StringBuilder sb = new StringBuilder();
        while(current != null) {
            sb.append(current.value).append("⤑");
            current = current.next;
        }
        sb.deleteCharAt(sb.length()-1);
        System.out.println(sb.toString());
    }

    /**
     * Reverse a linked list
     *
     * @param head
     * @param <T>
     * @return
     */
    public static <T> Node<T> reverse(Node<T> head) {
        Node<T> newHead = null;

        Node<T> current = head;
        while(current != null) {
            Node<T> next = current.next;
            current.next = newHead;
            newHead = current;
            current = next;
        }
        return newHead;
    }

    /**
     * Find the middle node using a fast-slow pointer pair
     *
     * @param head
     * @param <T>
     * @return
     */
    public static <T> Node<T> findMiddle(Node<T> head) {
        Node<T> slow = head;
        Node<T> fast = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    @Test
    public void test() {
        Character[] chars = {'a', 'b', 'c', 'd', 'e'};
        Node head = toLinkedList(chars);
        Node middle = findMiddle(head);
        System.out.println(middle.value);

        chars = new Character[]{'a', 'b', 'c', 'd', 'e', 'f'};
        head = toLinkedList(chars);
        middle = findMiddle(head);
        System.out.println(middle.value);
    }


}
