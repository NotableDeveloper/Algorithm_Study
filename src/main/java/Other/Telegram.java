package Other;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

class CITY implements Comparable<CITY>{
    int number;
    int cost;

    public CITY(int number, int cost) {
        this.number = number;
        this.cost = cost;
    }

    @Override
    public int compareTo(CITY c) {
        return Integer.compare(this.cost, c.cost);
    }
}

public class Telegram {
    public static void solution(int n, int c, int[][] cites){
        ArrayList<CITY>[] graph = new ArrayList[n + 1];
        PriorityQueue<CITY> pq = new PriorityQueue<>();

        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        for(int i = 0; i <= n; i++){
            graph[i] = new ArrayList<>();
        }

        for(int[] city : cites){
            graph[city[0]].add(new CITY(city[1], city[2]));
        }

        pq.offer(new CITY(c, 0));
        dist[c] = 0;

        while(!pq.isEmpty()){
            CITY current = pq.poll();

            if(dist[current.number] < current.cost)
                continue;

            for(CITY next : graph[current.number]){
                int cost = current.cost + next.cost;

                if(cost < dist[next.number]){
                    dist[next.number] = cost;
                    pq.offer(new CITY(next.number, cost));
                }
            }
        }

        int count = 0;
        int max_dist = 0;

        for(int d : dist){
            if(d != Integer.MAX_VALUE){
                count++;
                max_dist = Math.max(max_dist, d);
            }
        }

        System.out.println(count - 1 + " " + max_dist);
    }

    public static void main(String[] args) {
        int[][] cites = {{1, 2, 4}, {1, 3, 2}};

        solution(3,1, cites);
    }
}
