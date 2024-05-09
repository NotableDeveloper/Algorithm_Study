package BOJ.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ1068 {
    static int N;
    static ArrayList<Integer>[] graph;
    static int result = 0;
    static int start = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        graph = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            graph[i] = new ArrayList<>();
        }

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            int parent = Integer.parseInt(st.nextToken());
            if (parent != -1) graph[parent].add(i);
            else start = i;
        }

        int delete = Integer.parseInt(br.readLine());

        bfs(delete);
        System.out.println(result);
    }

    public static void bfs(int delete) {
        Queue<Integer> q = new LinkedList<>();

        if (start == delete) return;

        q.offer(start);

        while (!q.isEmpty()) {
            int node = q.poll();
            int count = 0;

            for (int next : graph[node]) {
                if (next != delete) {
                    q.offer(next);
                    count++;
                }
            }

            if (count == 0) result++;
        }
    }
}