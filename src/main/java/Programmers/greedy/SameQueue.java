package Programmers.greedy;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SameQueue {
    public static int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        int length = queue1.length;
        // queue1의 합계만을 사용한다.
        long queue1Sum = 0;
        long totalSum = 0;
        long targetSum = 0;

        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();

        queue1Sum = Arrays.stream(queue1).sum();
        totalSum = queue1Sum + Arrays.stream(queue2).sum();

        // 똑같이 나눌 수 없다면 -1 반환
        if (totalSum % 2 == 1) return -1;

        targetSum = totalSum / 2;

        for (int i = 0; i < length; i++) {
            q1.offer(queue1[i]);
            q2.offer(queue2[i]);
        }

        int tempNum = 0;

        while (queue1Sum != targetSum) {
            if (queue1Sum < targetSum) {
                tempNum = q2.poll();
                q1.offer(tempNum);
                queue1Sum += tempNum;
            }

            else {
                tempNum = q1.poll();
                q2.offer(tempNum);
                queue1Sum -= tempNum;
            }

            answer++;

            /*
                Queue 1과 Queue2의 모든 원소의 위치를 옮긴 경우의 횟수는 (Queue1의 길이 + Queue2의 길이) * 2
                이 횟수 이상을 옮겼다면 초기의 상태와 같아졌음을 의미하고, 더 이상의 반복은 무의미하다.
            */
            if (answer > (length * 4 - 1)) return -1;
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] queue1 = {1, 2, 1, 2};
        int[] queue2 = {1, 10, 1, 2};

        System.out.println(solution(queue1, queue2)); // 7
    }
}
