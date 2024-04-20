package Other;

import java.util.*;

class BankFee implements Comparable<BankFee>{
    int index;

    int fee;

    public BankFee(int index, int fee){
        this.index = index;
        this.fee = fee;
    }

    @Override
    public int compareTo(BankFee bankFee) {
        return Integer.compare(this.fee, bankFee.fee);
    }
}

/*
    가중치가 있는 그래프 문제.

    각 은행마다 수수료가 주어지고 최소한의 수수료로
    첫 번째 은행에서 목적지 은행에 송금하기.
*/
public class PostFee {
    public static int solution(int N, int K, int[][] fees) {
        boolean[] check = new boolean[N + 1];
        int[] dist = new int[N + 1];

        ArrayList<BankFee>[] graph = new ArrayList[N + 1];

        for(int i = 0; i <= N; i++){
            graph[i] = new ArrayList<>();
        }

        /*
            graph 초기화 작업을 한다.
            graph[N]에는 N번째 은행과 인접한 은행과 그 은행으로
            송금할 때의 비용을 담는다.
        */
        for(int[] fee : fees){
            int sendBank = fee[0];
            int receiveBank = fee[1];
            int cost = fee[2];

            graph[sendBank].add(new BankFee(receiveBank, cost));
        }

        // 다른 은행들의 가중치를 모두 무한으로 초기화한다.
        Arrays.fill(dist, Integer.MAX_VALUE);

        // 시작 은행인 1번 은행은 가중치를 0으로 둔다.
        dist[1] = 0;
        PriorityQueue<BankFee> pq = new PriorityQueue<>();

        // 첫 번째 은행을 Queue에 넣는다.
        pq.offer(new BankFee(1, 0));


        // 우선순위 큐가 빌 때까지 반복한다.
        while(!pq.isEmpty()){
            /*
                큐의 가장 앞에 있는 값을 가져온다. 이 값은 현재 큐에 있는
                값 중에서 출발지로부터 가장 작은 비용으로 올 수 있는 은행이 된다.
            */
            int currentBank = pq.poll().index;

            // 현재 은행이 방문 상태이면 그 다음으로 적은 비용의 은행을 방문한다.
            if(check[currentBank]) continue;

            // 현재 은행을 방문하기 전에 방문 처리를 한다.
            check[currentBank] = true;

            // 현재 은행과 인접한 은행들을 살펴본다.
            for(BankFee nextBank : graph[currentBank]){
                /*
                    출발 은행에서 현재 방문한 은행까지의 비용이 다음 은행까지 가려는 비용보다 작다면
                    비용을 계산하는 배열을 갱신한다.
                */
                if(dist[nextBank.index] > dist[currentBank] + nextBank.fee){
                    dist[nextBank.index] = dist[currentBank] + nextBank.fee;
                    // 다음 은행을 방문하기 위해 우선순위 큐에 넣는다.
                    pq.offer(new BankFee(nextBank.index, dist[currentBank]));
                }
            }
        }


        /*
            비용을 계산하는 배열에서 도착 은행의 값을 반환하면
            출발지로부터 해당 은행까지의 비용을 알 수 있다.
        */
        return dist[K];
    }

    public static void main(String[] args) {
        int[][] fees = new int[][]{{1, 2, 1000}, {2, 3, 1000}, {2, 4, 3500}, {3, 4, 1000}, {4, 5, 1000}};

        System.out.println(solution(5, 4, fees));
    }
}
