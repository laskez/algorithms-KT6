import java.util.Scanner;

public class Task4 {
    static class Node {
        long value;
        Node next;
        Node(long value) { this.value = value; }
    }

    static Node reverseKGroup(Node head, int k) {
        Node dummy = new Node(0);
        dummy.next = head;
        Node groupPrev = dummy;

        while (true) {
            Node kth = groupPrev;
            for (int i = 0; i < k && kth != null; i++) kth = kth.next;
            if (kth == null) break;

            Node groupNext = kth.next;
            Node prev = groupNext, cur = groupPrev.next;
            while (cur != groupNext) {
                Node next = cur.next;
                cur.next = prev;
                prev = cur;
                cur = next;
            }

            Node tmp = groupPrev.next;
            groupPrev.next = kth;
            groupPrev = tmp;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        Node head = null, tail = null;
        for (int i = 0; i < n; i++) {
            long v = sc.nextLong();
            Node node = new Node(v);
            if (head == null) head = tail = node;
            else { tail.next = node; tail = node; }
        }

        head = reverseKGroup(head, k);

        StringBuilder sb = new StringBuilder();
        Node node = head;
        while (node != null) {
            sb.append(node.value).append(' ');
            node = node.next;
        }
        System.out.println(sb.toString().trim());
    }
}