package Other;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class BoardGame {
    public static int solution(int field, int[][] jumps){
        int[] check = new int[field];
        int level = 0;
        Queue<Integer> Q = new LinkedList<>();

        HashMap<Integer, Integer> jump_table = new HashMap<>();

        for(int[] j : jumps)
            jump_table.put(j[0], j[1]);

        Q.offer(0);
        check[0] = 1;

        while(!Q.isEmpty()){
            int length = Q.size();

            for(int i = 0; i < length; i++){
                int current = Q.poll();

                // 주사위 눈금 수 만큼 이동
                for(int dice = 1; dice <= 6; dice++){
                    int next = current + dice;

                    /*
                        굴린 주사위로 나온 만큼 이동해서 도착하거나
                        도착지를 넘어가면 주사위 굴린 횟수를 한번 올리고 반환한다.
                    */
                    if(next >= field) return level + 1;

                    /*
                        주사위로 나온만큼 이동한 위치가 점프하는 위치이고,
                        지금보다 더 많은 칸을 간다면 이동한다.
                    */
                    if(jump_table.containsKey(next) && jump_table.get(next) > next){
                        next = jump_table.get(next);
                    }

                    if(next >= 0 && next <= field && check[next] == 0){
                        check[next] = 1;
                        Q.offer(next);
                    }
                }
            }

            level++;
        }

        return level;
    }

    public static void main(String[] args) {
        int field = 20;
        int[][] jumps = {{5, 7}, {14, 11}};

        System.out.println(solution(field, jumps));
    }
}
