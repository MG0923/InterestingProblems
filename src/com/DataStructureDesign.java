package com;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

/*
 *insertFirst(value):- value inserted head of the list Time Complexity O(1)
 *insertLast(value):- value inserted last of the list Time Complexity O(1)
 *deleteValue(val):- delete the value from the list if the list contains multiple values then it should delete only first occurrence expected time complexity O(1).
 *isExist(value):- return the true if value exist in the data structure otherwise false, expected time complexity O(1)
 */
public class DataStructureDesign {
    static Node head;
    static Node tail;
    static Map<Integer, Set<Node>> map = new HashMap<>();

    static class Node {
        int data;
        Node next;
        Node prev;

        Node(int data) {
            this.data = data;
        }
    }

    public static void insertAtBegin(int data) {
        Node node = new Node(data);
        Set<Node> nodes = new LinkedHashSet<>();
        if (head == null) {
            head = node;
            tail = node;
            nodes.add(node);
            map.put(data, nodes);
            return;
        }

        insertInMap(data, node, nodes);

        Node curr = head;

        head = node;
        head.next = curr;
        curr.prev = head;
    }

    public static void insertAtLast(int data) {
        if (tail == null) {
            System.out.println("Invalid");
            return;
        }
        Node node = new Node(data);
        Set<Node> nodes = new LinkedHashSet<>();

        insertInMap(data, node, nodes);

        Node cur = tail;
        tail = node;
        tail.prev = cur;
        cur.next = tail;
    }

    public static void delete(int data) {
        if (search(data)) {
            Set<Node> nodes = map.get(data);
            Node toBeDeleted = nodes.iterator().next();
            Node tempPrev = toBeDeleted.prev;
            Node tempNext = toBeDeleted.next;

            if (tempPrev == null && tempNext == null) {
                System.out.println("Only single node exist. Deleting");
                head = null;
                tail = null;
                map.remove(data);
            } else if (tempPrev == null) {
                System.out.println("First Node. Deleting head");
                head = tempNext;
                head.prev = null;
            } else if (tempNext == null) {
                System.out.println("Last Node. Deleting tail");
                tail = tempPrev;
                tail.next = null;
            } else {
                tempPrev.next = tempNext;
                tempNext.prev = tempPrev;
            }
            if (nodes.size() > 1) {
                nodes.remove(toBeDeleted);
                map.replace(data, nodes);
            } else {
                map.remove(data);
            }
        } else {
            System.out.println("Key not exist");
        }
    }

    public static boolean search(int data) {
        return map.containsKey(data);
    }

    private static void insertInMap(int data, Node node, Set<Node> nodes) {
        if (map.containsKey(data)) {
            nodes = map.get(data);
            nodes.add(node);
            map.replace(data, nodes);
        }
        nodes.add(node);
        map.put(data, nodes);
    }

    public static void printList() {
        Node cur = head;
        if (cur == null) {
            System.out.println("Invalid");
            return;
        }

        while (cur != null) {
            int prev = cur.prev == null ? 0 : cur.prev.data;
            System.out.print(prev + "::" + cur.data + "->");
            cur = cur.next;
        }
    }

    public static void main(String[] args) {
        insertAtBegin(10);
        insertAtBegin(50);
        insertAtBegin(30);
        insertAtLast(40);
        insertAtLast(50);
        System.out.println("Before Deletion: ");
        printList();
        delete(50);
        System.out.println("\nAfter Deletion: ");
        printList();
    }
}
