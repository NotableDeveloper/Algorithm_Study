package BOJ.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ1068 {
    static int N;
    static ArrayList<Integer>[] graph;
    static int result = 0;
    static int root = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        /*
            Tree는 그래프의 한 종류이므로, 그래프처럼 표현해준다.
            graph[0] 은 루트 노드에 연결된 자식 노드가 저장되고,
            graph[N] 은 N번 노드에 연결된 자식 노드가 저장되어 있다.
        */
        graph = new ArrayList[N];

        for (int i = 0; i < N; i++) {
            graph[i] = new ArrayList<>();
        }

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            int parent = Integer.parseInt(st.nextToken());
            if (parent != -1) graph[parent].add(i);
            else root = i;
        }

        int delete = Integer.parseInt(br.readLine());

        bfs(delete);
        System.out.println(result);
    }

    public static void bfs(int delete) {
        Queue<Integer> q = new LinkedList<>();

        /*
            삭제할 노드가 루트 노드이면 바로 종료한다.
        */
        if (root == delete) return;

        q.offer(root);

        while (!q.isEmpty()) {
            /*
                현재 노드와 연결된 자식 노드들을 탐색하면서
                자식 노드의 개수를 카운팅한다.
            */
            int current = q.poll();
            int child = 0;

            for (int next : graph[current]) {
                /*
                    연결된 자식 노드가 삭제할 노드가 아니라면
                    다음에 탐색하기 위해 큐에 넣고, 자식 노드의 수를 늘려준다.
                */
                if (next != delete) {
                    q.offer(next);
                    child++;
                }
            }

            /*
                현재 노드가 자식 노드를 모두 탐색했음에도 그 수가 0이라면
                리프 노드라는 의미이므로 정답의 개수를 하나 올려준다.
            */
            if (child == 0) result++;
        }
    }
}