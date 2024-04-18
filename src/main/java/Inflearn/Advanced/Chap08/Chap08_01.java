package Inflearn.Advanced.Chap08;

import java.util.*;

public class Chap08_01 {
    public static int solution(int n, int[][] flights, int s, int e, int k) {
        /*
            그래프를 나타내기 위한 인접 리스트를 생성하고
            초기화한다.
        */
        ArrayList<ArrayList<int[]>> graph = new ArrayList<>();

        for(int i = 0; i < n; i++){
            graph.add(new ArrayList<int[]>());
        }

        /*
            출발지에서 목적지까지 드는 비용을 담는 배열 생성.
            매번 탐색할 때마다 최소한의 비용으로 갱신된다.
        */
        int[] costs = new int[n];
        Arrays.fill(costs, 1000000000);

        /*
            그래프에 출발지 -> 목적지, 비용 으로 초기화
        */
        for(int[] flight : flights){
            graph.get(flight[0]).add(new int[]{flight[1], flight[2]});
        }

        /*
            BFS 방식으로 탐색 시작하기 위해 Queue를 선언하고 초기화.
            또, 시작 지점은 비용이 0이므로 함께 초기화한다.
        */
        Queue<int[]> Q = new LinkedList<>();
        Q.offer(new int[]{s, 0});
        costs[s] = 0;

        /*
            환승 횟수를 점검하기 위해 카운팅 변수 선언 및 초기화.
        */
        int L = 0;

        while(!Q.isEmpty()){
            /*
                현재 Level의 길이 == 현재 레벨에서 탐색해야 하는 노드의 수
            */
            int len = Q.size();

            /*
                현재 Level의 노드 수만큼 탐색한다.
            */
            for(int i = 0; i < len; i++){
                int[] p = Q.poll();

                int now = p[0];
                int now_cost = p[1];

                /*
                    현재 있는 도시와 인접한 도시를 탐색한다.
                */
                for(int[] x : graph.get(now)){
                    int next = x[0];
                    int next_cost = x[1];

                    /*
                        현재 도시에서 다음 도시로 가는 비용을 비교해본다.
                        지금까지의 비용 < costs에 기록된 비용
                        이라면 costs의 내용을 갱신하고, 다음 도시로 이동한다.
                    */
                    if(now_cost + next_cost < costs[next]){
                        costs[next] = now_cost + next_cost;
                        Q.offer(new int[]{next, costs[next]});
                    }
                }
            }

            /*
                현재 레벨 수를 올리면서, 환승 횟수를 넘겼으면
                BFS 탐색을 종료한다.
            */
            L++;
            if(L > k) break;
        }

        if(costs[e] == 1000000000) return -1;
        else return costs[e];
    }

    public static void main(String[] args) {
        int[][] flights = {
                {0, 1, 10}, {1, 2, 20}, {0, 2, 70}, {0, 3, 100},
                {1, 3, 80}, {2, 3, 10}, {2, 4, 30}, {3, 4, 10}
        };

        System.out.println(solution(5, flights, 0, 3, 1));
    }
}
