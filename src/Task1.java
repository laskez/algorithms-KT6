import java.util.Scanner;

public class Task1 {
    static class Node {
        long value;
        Node next;
        Node(long value) { this.value = value; }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Node head = null, tail = null;
        for (int i = 0; i < n; i++) {
            long v = sc.nextLong();
            Node node = new Node(v);
            if (head == null) head = tail = node;
            else { tail.next = node; tail = node; }
        }

        Node prev = null, cur = head;
        while (cur != null) {
            Node next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        head = prev;

        StringBuilder sb = new StringBuilder();
        Node node = head;
        while (node != null) {
            sb.append(node.value).append(' ');
            node = node.next;
        }
        System.out.println(sb.toString().trim());
    }
}