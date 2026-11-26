import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class DijkstraMatrix {
    static final int INF = 1_000_000_000;

    public static void dijkstraWithPaths(int[][] matrix, int startVertex) {
        int n = matrix.length;
        int src = startVertex - 1;

        int[] dist = new int[n];
        int[] parent = new int[n];
        boolean[] visited = new boolean[n];

        Arrays.fill(dist, INF);
        Arrays.fill(parent, -1);
        dist[src] = 0;

        for (int step = 0; step < n; step++) {
            int u = -1;
            int bestDist = INF;
            for (int i = 0; i < n; i++) {
                if (!visited[i] && dist[i] < bestDist) {
                    bestDist = dist[i];
                    u = i;
                }
            }

            if (u == -1) {
                break;
            }

            visited[u] = true;

            for (int v = 0; v < n; v++) {
                int w = matrix[u][v];
                if (!visited[v] && u != v && w > 0 && w < INF) {
                    if (dist[u] + w < dist[v]) {
                        dist[v] = dist[u] + w;
                        parent[v] = u;
                    }
                }
            }
        }

        System.out.println("=== KET QUA DIJKSTRA TU DINH " + startVertex + " ===");
        for (int v = 0; v < n; v++) {
            if (v == src) {
                continue;
            }

            if (dist[v] >= INF) {
                System.out.println(startVertex + " - " + (v + 1) + ": Khong co duong di");
                continue;
            }

            List<Integer> path = new ArrayList<>();
            for (int curr = v; curr != -1; curr = parent[curr]) {
                path.add(curr + 1);
            }
            Collections.reverse(path);

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < path.size(); i++) {
                if (i > 0) sb.append(" -> ");
                sb.append(path.get(i));
            }

            System.out.println(startVertex + " - " + (v + 1) + " (d = " + dist[v] + "): " + sb);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhap so dinh n: ");
        int n = sc.nextInt();

        int[][] adjMatrix = new int[n][n];
        System.out.println("Nhap ma tran ke (nhap 0 cho duong cheo chinh, nhap -1 hoac so lon >= 1000000000 neu khong co duong di):");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int val = sc.nextInt();
                if (i == j) {
                    adjMatrix[i][j] = 0;
                } else if (val < 0 || val >= INF) {
                    adjMatrix[i][j] = INF;
                } else {
                    adjMatrix[i][j] = val;
                }
            }
        }

        System.out.print("Nhap dinh bat dau (1.." + n + "): ");
        int startVertex = sc.nextInt();

        dijkstraWithPaths(adjMatrix, startVertex);
        sc.close();
    }
}