import java.util.Scanner;

public class Task2 {
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

        parent = new int[n + 1];
        rank = new int[n + 1];
        for (int i = 1; i <= n; i++) parent[i] = i;

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < q; i++) {
            int type = sc.nextInt();
            int u = sc.nextInt();
            int v = sc.nextInt();
            if (type == 1) {
                union(u, v);
            } else {
                sb.append(find(u) == find(v) ? "YES" : "NO").append('\n');
            }
        }
        System.out.print(sb);
    }
}