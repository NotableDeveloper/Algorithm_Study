package Inflearn.Advanced.Chap08;

import java.util.*;

class AirPlane implements Comparable<AirPlane>{
    int index;
    int cost;

    public AirPlane(int index, int cost){
        this.index = index;
        this.cost = cost;
    }

    @Override
    public int compareTo(AirPlane airPlane) {
        return Integer.compare(this.cost, airPlane.cost);
    }
}

public class Chap08_01 {
    public static int solution(int n, int[][] flights, int s, int e, int k) {
        ArrayList<AirPlane>[] graph = new ArrayList[n + 1];

        for(int i = 0; i < n; i++){
            graph[i] = new ArrayList<>();
        }

        int[] costs = new int[n];
        Arrays.fill(costs, Integer.MAX_VALUE);

        for(int[] flight : flights){
            int first = flight[0];
            int second = flight[1];
            int cost = flight[2];

            graph[first].add(new AirPlane(second, cost));
        }

        Queue<AirPlane> Q = new LinkedList<>();
        Q.offer(new AirPlane(s, 0));
        costs[s] = 0;

        int L = 0;

        while(!Q.isEmpty()){
            AirPlane current = Q.poll();

            for(AirPlane next : graph[current.index]) {
                if(current.cost + next.cost < costs[next.index]) {
                    costs[next.index] = current.cost + next.cost;
                    Q.offer(new AirPlane(next.index, costs[current.index]));
                }
            }

            L++;
            if(L > k) break;
        }

        if(costs[e] == Integer.MAX_VALUE) return -1;
        else return costs[e];
    }

    /*
        환승 제한이 없을 경우의 최소 비용 구하기
    */
    public static int DijkstraWithPQ(int n, int[][] flights, int s, int e, int k){
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        boolean[] check = new boolean[n];
        List<AirPlane>[] graph = new ArrayList[n];
        PriorityQueue<AirPlane> pq = new PriorityQueue<>();

        for(int i = 0; i < n; i++) graph[i] = new ArrayList<>();

        for(int[] fligh : flights){
            int first = fligh[0];
            int second = fligh[1];
            int cost = fligh[2];

            graph[first].add(new AirPlane(second, cost));
        }

        dist[s] = 0;
        pq.offer(new AirPlane(s, 0));

        while(!pq.isEmpty()){
            AirPlane current = pq.poll();

            if(check[current.index]) continue;

            check[current.index] = true;

            for(AirPlane next : graph[current.index]){
                if(dist[next.index] > dist[current.index] + next.cost){
                    dist[next.index] = dist[current.index] + next.cost;
                    pq.offer(new AirPlane(next.index, dist[current.index]));
                }
            }
        }

        if(dist[e] == Integer.MAX_VALUE) return -1;
        else return dist[e];
    }

    public static void main(String[] args) {
        int[][] flights = {
                {0, 1, 10}, {1, 2, 20}, {0, 2, 70}, {0, 3, 100},
                {1, 3, 80}, {2, 3, 10}, {2, 4, 30}, {3, 4, 10}
        };

        System.out.println(solution(5, flights, 0, 3, 1));
    }
}
