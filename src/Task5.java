import java.util.Scanner;

public class Task5 {
    static int[] parent, rank;

    static int find(int x) {
        while (parent[x] != x) {
            parent[x] = parent[parent[x]];
            x = parent[x];
        }
        return x;
    }

    static void union(int a, int b) {
        int ra = find(a), rb = find(b);
        if (ra == rb) return;
        if (rank[ra] < rank[rb]) { int t = ra; ra = rb; rb = t; }
        parent[rb] = ra;
        if (rank[ra] == rank[rb]) rank[ra]++;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();

        parent = new int[2 * n + 1];
        rank = new int[2 * n + 1];
        for (int i = 1; i <= 2 * n; i++) parent[i] = i;

        StringBuilder sb = new StringBuilder();
        boolean broken = false;

        for (int i = 0; i < q; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int r = sc.nextInt();

            if (broken) {
                sb.append("NO\n");
                continue;
            }

            if (r == 0) {
                union(u, v);
                union(u + n, v + n);
            } else {
                union(u, v + n);
                union(u + n, v);
            }

            if (find(u) == find(u + n)) {
                broken = true;
                sb.append("NO\n");
            } else {
                sb.append("YES\n");
            }
        }
        System.out.print(sb);
    }
}