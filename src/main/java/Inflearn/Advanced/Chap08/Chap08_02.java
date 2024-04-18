package Inflearn.Advanced.Chap08;

import java.util.*;

public class Chap08_02 {
    public static int solution(int[][] routes, int s, int e) {
        int answer = 0;
        /*
            HashMap에 "역의 번호, 역의 호선" 쌍으로 저장한다.
            예를 들어, "1, 2" 라고 저장하면 1번 역은 2호선이라는 의미이다.
        */
        HashMap<Integer, HashSet<Integer>> graph = new HashMap<>();
        int n = routes.length;

        /*
            지하철 노선 그래프를 초기화한다.
        */
        for (int i = 0; i < n; i++) {
            for (int x : routes[i]) {
                /*
                    Key 값이 존재하는 경우, 해당 Key의 Value를 반환하고,
                    존재하지 않으면 해당 Key와 Value를 넣고 Null 반환.
                */
                graph.putIfAbsent(x, new HashSet<Integer>());
                graph.get(x).add(i);
            }
        }


        Queue<Integer> Q = new LinkedList<>();
        /*
            탐색을 완료한 지하철 노선도를 체크한다.
            지하철 역을 체크하는 것이 아니다.
        */
        int[] ch = new int[n];
        Q.offer(s);
        int L = 0;

        while (!Q.isEmpty()) {
            int len = Q.size();
            for (int i = 0; i < len; i++) {
                int curStop = Q.poll();
                /*
                    현재 역이 속한 노선을 탐색
                */
                for (int line : graph.get(curStop)) {
                    if (ch[line] == 1) continue;
                    ch[line] = 1;
                    /*
                        아직 탐색하지 않은 노선이라면 도착지가 나올 때까지 탐색
                    */
                    for (int stop : routes[line]) {
                        /*
                            Level가 환승 횟수이므로 도착역을 찾으면
                            그대로 반환하면서 BFS 탐색을 종료
                        */
                        if (stop == e) return L;
                        Q.offer(stop);
                    }
                }
            }
            L++;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[][]{{1, 2, 3, 4, 5, 6, 19}, {2, 7, 8, 13}, {5, 9, 10}, {9, 11, 12, 18}, {13, 14, 15}, {14, 12, 16, 17}}, 1, 12));
    }
}

