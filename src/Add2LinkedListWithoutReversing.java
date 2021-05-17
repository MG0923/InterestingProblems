import java.util.HashMap;
import java.util.Map;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

/*5->3->7->8
 *5->3->7->8
 * Result : 1->0->7->5->6
 * */
/*5->3->7->8
 *4->7->8->9
 * Result : 1->0->1->6->7
 * */
/*0
 *4->7->8->9
 * Result : 4->7->8->9
 * */
public class Add2LinkedListWithoutReversing {
    private static Node resNode;

    static class Node {
        int data;
        Node next;
        Map<Node, Node> pre = new HashMap<>();
        Node previous = null;
        Node tail = null;

        Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }

        Node(Node head) {
            while (head != null) {
                tail = head;
                pre.put(head, previous);
                previous = head;
                head = head.next;
            }
        }

        Node getPrevious(Node curr) {
            return pre.get(curr);
        }

        Node getTail() {
            return tail;
        }
    }

    private static void insertBefore(int data) {
        Node newNode = new Node(data, null);
        if (isNull(resNode)) {
            resNode = newNode;
            return;
        }
        newNode.next = resNode;
        resNode = newNode;
    }

    private static void printList(Node head) {
        if (isNull(head)) {
            System.out.println("LinkedList is empty");
        }
        while (nonNull(head)) {
            System.out.print(head.data + "->");
            head = head.next;
        }
    }

    private static void add(Node head, Node head1) {
        int carry = 0;
        int sum;

        Node list1 = new Node(head);
        Node list2 = new Node(head1);

        Node tail = list1.getTail();
        Node tail1 = list2.getTail();

        while (tail != null && tail1 != null) {
            sum = tail.data + tail1.data + carry;
            insertBefore(sum % 10);
            carry = sum / 10;
            tail = list1.getPrevious(tail);
            tail1 = list2.getPrevious(tail1);
        }
        while (tail != null) {
            sum = tail.data + carry;
            insertBefore(sum % 10);
            tail = list1.getPrevious(tail);
        }
        while (tail1 != null) {
            sum = tail1.data + carry;
            insertBefore(sum % 10);
            tail1 = list2.getPrevious(tail1);
        }
        if (carry > 0) {
            insertBefore(carry);
        }

        System.out.println();
        System.out.println("Result List");
        printList(resNode);
    }

    public static void main(String[] args) {
        Node d = new Node(8, null);
        Node c = new Node(7, d);
        Node b = new Node(3, c);
        Node a = new Node(5, b);

        Node c1 = new Node(3, null);
        Node b1 = new Node(2, c1);
        Node a1 = new Node(1, b1);

        printList(a);
        System.out.println();
        printList(a1);
        add(a, a1);
    }
}