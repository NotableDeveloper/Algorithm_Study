package Other.greedy;

import java.util.Arrays;

public class Adventurer {
    public static int solution(int [] members){
        int answer = 0;
        int count = 0;
        Arrays.sort(members);

        for(int member : members){
            count++;

            if(count >= member){
                answer++;
                count = 0;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] members = {2, 3, 1, 2, 2};
        System.out.println(solution(members));
    }
}
