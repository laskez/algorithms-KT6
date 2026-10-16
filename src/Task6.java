import java.util.*;

public class Task6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        sc.nextLine();

        String[] words = new String[n];
        for (int i = 0; i < n; i++) words[i] = sc.nextLine().trim();

        List<Set<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < k; i++) adj.add(new HashSet<>());
        int[] indegree = new int[k];

        for (int i = 0; i + 1 < n; i++) {
            String a = words[i], b = words[i + 1];
            int len = Math.min(a.length(), b.length());
            boolean found = false;
            for (int j = 0; j < len; j++) {
                int ca = a.charAt(j) - 'a';
                int cb = b.charAt(j) - 'a';
                if (ca != cb) {
                    if (!adj.get(ca).contains(cb)) {
                        adj.get(ca).add(cb);
                        indegree[cb]++;
                    }
                    found = true;
                    break;
                }
            }
            if (!found && a.length() > b.length()) {
                System.out.println("IMPOSSIBLE");
                return;
            }
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < k; i++) {
            if (indegree[i] == 0) pq.add(i);
        }

        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            int u = pq.poll();
            sb.append((char) ('a' + u));
            for (int v : adj.get(u)) {
                indegree[v]--;
                if (indegree[v] == 0) pq.add(v);
            }
        }

        if (sb.length() < k) {
            System.out.println("IMPOSSIBLE");
        } else {
            System.out.println(sb);
        }
    }
}