package Inflearn.Advanced.Chap07;

import java.util.LinkedList;
import java.util.Queue;

public class Chap07_01 {
    private static int solution(int[] nums){
        int n = nums.length;
        int[] check = new int[n];
        Queue<Integer> queue = new LinkedList<>();
        /*
            가장 맨 왼쪽(0번 인덱스)부터 출발한다.
        */
        queue.offer(0);
        check[0] = 1;
        /*
            탐색의 깊이를 의미하며, 여기서는 점프의 횟수가 된다.
        */
        int Level = 0;

        while(!queue.isEmpty()){
            /*
                현재 칸에서 이동할 수 있는 칸의 갯수를 구한다.
            */
            int len = queue.size();

            for(int i = 0; i < len; i++){
                int current = queue.poll();

                /*
                    현재 칸에서 이동할 수 있는 칸에 적혀 있는 수만큼 이동해본다.
                */
                for(int j = 1; j <= nums[current]; j++){
                    int next = current + j;

                    /*
                        정확하게 도착하면 지금까지 점프한 횟수에 하나를 더해서 반환
                    */
                    if(next == n - 1) return Level + 1;

                    /*
                        이동한 칸이 타일 범위 내에 있고, 방문한 적이 없는 타일이면
                        방문처리 하고 다음 타일을 큐에 넣는다.
                    */
                    if(next < n && check[next] == 0){
                        check[next] = 1;
                        queue.offer(next);
                    }
                }
            }
            /*
                타일을 이동하며 전진할 때마다 점프한 것으로 간주한다.
            */
            Level++;
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 2, 1, 1, 2, 3, 1, 3, 1, 2, 3, 5, 1, 5, 1, 2, 1, 1};
        System.out.println(solution(nums));
    }
}
