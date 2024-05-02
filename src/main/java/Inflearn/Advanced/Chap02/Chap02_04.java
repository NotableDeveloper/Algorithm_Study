package Inflearn.Advanced.Chap02;

import java.util.HashMap;

public class Chap02_04 {
    public static int solution(int[] nums, int m){
        int answer = 0;
        HashMap<Integer, Integer> nH = new HashMap<>();
        int sum = 0;
        nH.put(0, 1);

        for(int x : nums){
            sum += x;
            if(nH.containsKey(sum - m)) answer += nH.get(sum - m);
            nH.put(sum, nH.getOrDefault(sum, 0) + 1);
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] nums = {2, 2, 3, -1, -1, -1, 3, 1, 1};
        System.out.println(solution(nums, 5));
    }
}
