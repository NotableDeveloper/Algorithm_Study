package Other;

import java.util.*;

/*
    가중치가 있는 그래프 문제.

    각 은행마다 수수료가 주어지고 최소한의 수수료로
    1번 은행에서 목적지 은행에 송금하기.
*/
public class PostFee {
    public static int solution(int N, int K, int[][] fees) {
        // 그래프를 나타내기 위한 인접 리스트 생성
        List<int[]>[] graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        // 그래프 초기화
        for (int[] fee : fees) {
            int u = fee[0];
            int v = fee[1];
            int cost = fee[2];
            graph[u].add(new int[]{v, cost});
            graph[v].add(new int[]{u, cost});
        }

        // 다익스트라 알고리즘을 위한 우선순위 큐
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.offer(new int[]{1, 0}); // 시작 정점은 1번 은행이고 수수료는 0원

        // 최소 수수료를 저장하는 배열
        int[] minFees = new int[N + 1];
        Arrays.fill(minFees, Integer.MAX_VALUE);
        minFees[1] = 0; // 시작 정점의 수수료는 0원

        // 다익스트라 알고리즘 수행
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int curNode = cur[0];
            int curFee = cur[1];

            if (curNode == K) { // 목적지에 도달하면 최소 수수료 반환
                return curFee;
            }

            // 현재 노드에서 인접한 노드들을 탐색
            for (int[] next : graph[curNode]) {
                int nextNode = next[0];
                int nextFee = next[1];

                // 현재까지의 수수료와 인접한 노드로의 수수료를 합한 값이
                // 기존에 저장된 최소 수수료보다 작으면 업데이트
                if (minFees[nextNode] > curFee + nextFee) {
                    minFees[nextNode] = curFee + nextFee;
                    pq.offer(new int[]{nextNode, minFees[nextNode]});
                }
            }
        }

        // 목적지에 도달할 수 없는 경우 -1 반환
        return -1;
    }

    public static void main(String[] args) {
        int[][] fees = new int[][]{{1, 2, 1000}, {2, 3, 1000}, {2, 4, 3500}, {3, 4, 1000}, {4, 5, 1000}};
        System.out.println(solution(5, 4, fees));
    }
}
