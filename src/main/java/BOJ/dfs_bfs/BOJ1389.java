package BOJ.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ1389 {
    static int N, M;

    /*
        BFS를 통해 한 사람의 케빈 베이컨 수를 구한다.
    */
    public static int BFS(int start, ArrayList<Integer>[] graph){
        int[] dist = new int[N + 1];
        int count = 0;
        Arrays.fill(dist, -1);
        dist[start] = 0;

        Queue<Integer> Q = new LinkedList<>();
        dist[start] = 0;
        Q.offer(start);

        while(!Q.isEmpty()){
            int current = Q.poll();

            for(int next : graph[current]){
                if(dist[next] != -1) continue;
                dist[next] = dist[current] + 1;
                count += dist[next];
                Q.offer(next);
            }
        }

        return count;
    }

    public static void main(String[] args) throws IOException {
        int answer = 0;
        int minKevin = Integer.MAX_VALUE;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        ArrayList<Integer>[] graph = new ArrayList[N + 1];

        for(int i = 0; i <= N; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i = 1; i <= M; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph[u].add(v);
            graph[v].add(u);
        }

        for(int i = 1; i <= N; i++){
            int kevin = BFS(i, graph);
            if(kevin < minKevin){
                minKevin = kevin;
                answer = i;
            }
        }

        System.out.println(answer);
    }
}
