import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

public class RemoveNodeWhenHeadNotKnown {

    static class Node {
        int data;
        Node next;

        Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    private static void removeNodeHeadNotKnown(Node node) {
        if (isNull(node)) {
            System.out.println("Linked list is empty");
            return;
        }
        if (isNull(node.next)) {
            System.out.println("This is the last Node head cannot be deleted");
            return;
        }
        Node temp = node.next;
        node.data = temp.data;
        node.next = temp.next;
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

    public static void main(String[] args) {
        Node d1 = new Node(2, null);
        Node c1 = new Node(6, d1);
        Node b1 = new Node(4, c1);
        Node a1 = new Node(5, b1);

        printList(a1);
        removeNodeHeadNotKnown(a1.next.next);
        System.out.println("\nAfter deletion");
        printList(a1);
    }
}
