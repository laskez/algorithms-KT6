import java.util.*;

public class Task3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) adj.add(new ArrayList<>());
        int[] indegree = new int[n + 1];

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            adj.get(a).add(b);
            indegree[b]++;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 1; i <= n; i++) {
            if (indegree[i] == 0) pq.add(i);
        }

        List<Integer> order = new ArrayList<>();
        while (!pq.isEmpty()) {
            int u = pq.poll();
            order.add(u);
            for (int v : adj.get(u)) {
                indegree[v]--;
                if (indegree[v] == 0) pq.add(v);
            }
        }

        if (order.size() < n) {
            System.out.println(-1);
            return;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (i > 0) sb.append(' ');
            sb.append(order.get(i));
        }
        System.out.println(sb);
    }
}