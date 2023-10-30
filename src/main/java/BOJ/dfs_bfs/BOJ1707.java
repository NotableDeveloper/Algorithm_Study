package BOJ.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class BOJ1707_TestCase{
  private List<Integer>[] graph;

  private static final int RED = 1;

  /*
    colors[1] = 1 -> 1번 노드의 색이 빨간색
    colors[0] = 0 -> 1번 노드에 색칠이 되어있지 않음
    colors[1] = -1 -> 1번 노드의 색이 파란색
   */
  private int[] colors;

  /*
    그래프와 색상 정보 테이블 초기화
   */
  public BOJ1707_TestCase(int V){
    graph = new ArrayList[V + 1];
    colors = new int[V + 1];

    for(int i = 1; i <= V; i++){
      graph[i] = new ArrayList<>();
    }
  }

  /*
    그래프 연결
   */
  public void setADJ(int a, int b){
    graph[a].add(b);
  }

  public String solution(){
    boolean flag = false;

    for(int vertex = 1; vertex < graph.length; vertex++){
      if(colors[vertex] == 0) flag = isBipartite(vertex, RED);
      if(!flag) break;
    }

    if (flag) return "YES";
    else return "NO";
  }

  private boolean isBipartite(int start, int color) {
    Queue<Integer> Q = new LinkedList<>();
    // 1번 노드부터 탐색하는 것으로 시작
    Q.offer(start);
    colors[start] = color;

    while(!Q.isEmpty()){
      int current = Q.poll();

      for(int next : graph[current]){
        // 동일한 색이면 이분 그래프가 아님
        if(colors[current] == colors[next]) return false;

        // 인접 노드를 반대되는 색으로 칠함
        if(colors[next] == 0){
          colors[next] = colors[current] * -1;
          Q.add(next);
        }
      }
    }

    return true;
  }
}

public class BOJ1707 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int K = Integer.parseInt(br.readLine());
    BOJ1707_TestCase[] testCases = new BOJ1707_TestCase[K];


    for(int i = 0; i < K; i++){
      String[] input = br.readLine().split(" ");
      int V = Integer.parseInt(input[0]);
      int E = Integer.parseInt(input[1]);

      testCases[i] = new BOJ1707_TestCase(V);

      for(int j = 0; j < E; j++){
        input = br.readLine().split(" ");
        int a = Integer.parseInt(input[0]);
        int b = Integer.parseInt(input[1]);

        testCases[i].setADJ(a, b);
      }
    }

    for(BOJ1707_TestCase tc : testCases){
      System.out.println(tc.solution());
    }
    }
}
