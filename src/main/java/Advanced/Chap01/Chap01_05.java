package Advanced.Chap01;

import java.util.ArrayList;

public class Chap01_05 {
    public static int solution(int[] nums){
        int answer = 0, n = nums.length;
        ArrayList<Integer> peaks = new ArrayList<>();

        /*
            바이토닉 수열이 될 수 있는 봉우리의 인덱스를
            List에 넣는다.
         */
        for(int i = 1; i < n - 1; i++){
            if(nums[i - 1] < nums[i] && nums[i] > nums[i + 1])
                peaks.add(i);
        }

        for(int p : peaks){
            int left = p, right = p, count = 1;

            while(left - 1 >= 0 && nums[left - 1] < nums[left]){
                left--;
                count++;
            }

            while(right + 1 < n && nums[right] > nums[right + 1]){
                right++;
                count++;
            }

            answer = Math.max(answer, count);
        }

        return answer;
    }
}
