import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

/*5->3->7->8
 *   3->7->8
 * Result : 5->7->5->6
 * */
/*5->3->7->8
 *4->7->8->9
 * Result : 1->0->1->6->7
 * */
/*0
 *4->7->8->9
 * Result : 4->7->8->9
 * */
public class Add2LinkedListByReversing {

    private static Node resHead;

    static class Node {
        int data;
        Node next;

        Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    private static void insert(int data) {
        Node newNode = new Node(data, null);
        if (isNull(resHead)) {
            resHead = newNode;
            return;
        }
        Node curr = resHead;
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = newNode;
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
        Node list1 = reverseLinkedList(head);
        Node list2 = reverseLinkedList(head1);

        System.out.println("\nReversed Lists");
        printList(list1);
        System.out.println();
        printList(list2);

        int carry = 0;
        int sum;
        while (list1 != null && list2 != null) {
            sum = list1.data + list2.data + carry;
            insert(sum % 10);
            carry = sum / 10;
            list1 = list1.next;
            list2 = list2.next;
        }
        while (list1 != null) {
            sum = list1.data + carry;
            insert(sum % 10);
            list1 = list1.next;
        }
        while (list2 != null) {
            sum = list2.data + carry;
            insert(sum % 10);
            list2 = list2.next;
        }
        if (carry > 0) {
            insert(carry);
        }

        System.out.println("\nResult List");
        printList(resHead);
    }

    private static Node reverseLinkedList(Node head) {
        Node curr = head;
        Node prev = null;
        Node next;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
        return head;
    }

    public static void main(String[] args) {
        Node d = new Node(8, null);
        Node c = new Node(7, d);
        Node b = new Node(3, c);
        Node a = new Node(5, b);

        Node d1 = new Node(2, null);
        Node c1 = new Node(6, d1);
        Node b1 = new Node(4, c1);
        Node a1 = new Node(5, b1);

        printList(a);
        System.out.println();
        printList(a1);

        add(a, a1);
    }
}
