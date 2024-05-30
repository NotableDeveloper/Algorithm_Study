package Other.greedy;

import java.util.Arrays;

class House implements Comparable<House>{
    int a;
    int b;
    int cost;

    public House(int a, int b, int cost){
        this.a = a;
        this.b = b;
        this.cost = cost;
    }

    @Override
    public int compareTo(House h) {
        return this.cost - h.cost;
    }
}

public class CityPlan {
    private static int findParents(int[] parents, int x){
        if(parents[x] != x)
            parents[x] = findParents(parents, parents[x]);
        return parents[x];
    }

    private static void unionParents(int[] parents, int a, int b){
        a = findParents(parents, a);
        b = findParents(parents, b);

        if(a < b) parents[b] = a;
        else parents[a] = b;
    }

    public static int solution(int n, int m, int[][] costs){
        int answer = 0;
        int[] parents = new int[n + 1];

        for(int i = 1; i < n; i++){
            parents[i] = i;
        }

        House[] houses = new House[m];

        for(int i = 0; i < m; i++){
            houses[i] = new House(costs[i][0], costs[i][1], costs[i][2]);
        }

        Arrays.sort(houses);
        //Arrays.stream(houses).toList().forEach(h -> System.out.println(h.a + " -> " + h.b + " = " + h.cost));

        int last = 0;

        for(House house : houses){
            int a = house.a;
            int b = house.b;
            int cost = house.cost;

            if(findParents(parents, a) != findParents(parents, b)){
                unionParents(parents, a, b);
                answer += cost;
                last = cost;
            }
        }

        return answer - last;
    }

    public static void main(String[] args) {
        int n = 7, m = 12;

        int[][] costs = {
                {1, 2, 3}, {1, 3, 2}, {3, 2, 1},
                {2, 5, 2}, {3, 4, 4}, {7, 3, 6},
                {5, 1, 5}, {1, 6, 2}, {6, 4, 1},
                {6, 5, 3}, {4, 5, 3}, {6, 7, 4}
        };

        System.out.println(solution(n, m, costs));
    }
}
