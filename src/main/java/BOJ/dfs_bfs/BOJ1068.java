package BOJ.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1068 {
    public static int solution(int n, int[] tree, int delete){
        if(delete == 0) return 0;

        int answer = 0;
        ArrayList<Integer>[] graph = new ArrayList[n];
        Queue<Integer> Q = new LinkedList<>();

        for(int i = 0; i < n; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i < tree.length; i++){
            if(tree[i] == -1) continue;
            graph[tree[i]].add(i);
        }

        Q.offer(0);


        while(!Q.isEmpty()){
            int current = Q.poll();

            for(int next : graph[current]){
                if(next == delete) continue;

                if(graph[next].isEmpty()) {
                    answer++;
                }

                else Q.offer(next);
            }

        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] tree = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < tree.length; i++){
            tree[i] = Integer.parseInt(st.nextToken());
        }

        int delete = Integer.parseInt(br.readLine());

        System.out.println(solution(n, tree, delete));
    }
}
