package BOJ.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1260 {
    static StringBuilder sb = new StringBuilder();
    static boolean[] visited;
    static int[][] connection;
    // N = 노드의 개수, M = 간선의 개수, V = 탐색을 시작할 노드 번호
    static int N, M, V;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        connection = new int[N + 1][N + 1];
        visited = new boolean[N + 1];

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int left_node = Integer.parseInt(st.nextToken());
            int right_node = Integer.parseInt(st.nextToken());
            // 연결 정보 저장
            connection[left_node][right_node] = 1;
            connection[right_node][left_node] = 1;
        }

        DFS(V);
        sb.append("\n");
        visited = new boolean[N + 1];
        BFS(V);
        System.out.println(sb);
    }

    public static void DFS(int node){
        /*
            방문 처리를 한다.
         */
        visited[node] = true;
        sb.append(node + " ");

        /*
            현재 노드가 탐색하려는 노드가 방문하지 않은 노드이고,
            1번부터 N번 노드까지 연결된 노드 중에 제일 먼저 발견된 노드를
            다음으로 방문한다.
        */
        for(int i = 1; i <= N; i++){
            if(!visited[i] && connection[node][i] == 1){
                DFS(i);
            }
        }
    }

    public static void BFS(int node){
        Queue<Integer> Q = new LinkedList<>();
        /*
            시작 지점부터 탐색할 수 있도록 Queue에 저장하고,
            시작 지점을 방문 처리한다.
        */
        Q.offer(node);
        visited[node] = true;

        while(!Q.isEmpty()){
            node = Q.poll();
            /*
                현재 노드를 방문했음을 기록한다.
            */
            sb.append(node + " ");

            /*
                현재 노드가 탐색하려는 노드가 방문하지 않은 노드이고,
                1번부터 N번 노드까지 연결된 노드 중에 제일 먼저 발견된 노드를
                다음으로 방문한다.
            */
            for(int i = 1; i <= N; i++){
                if(!visited[i] && connection[node][i] == 1){
                    Q.offer(i);
                    visited[i] = true;
                }
            }
        }
    }
}
