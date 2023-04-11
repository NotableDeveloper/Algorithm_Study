package Chap03;

public class Chap03_06 {
    public static int solution(int n, int k, int[] arr){
        // count : 0을 1로 바꾼 횟수
        int answer = 0, count = 0, lt = 0;
        
        /*
            lt와 rt가 0번에서 시작하고, rt가 우선적으로 움직이다가
            0을 1로 바꾼 횟수가 초과되면 lt가 움직인다.
         */
        for(int rt = 0; rt < n; rt++){
            if(arr[rt] == 0) count++;
            
            // 0을 1로 바꾸는 횟수가 초과한 경우
            while(count > k){
                if(arr[lt] == 0) count--;
                lt++;
            }
            
            // rt - lt + 1 : 연속된 1의 갯수
            answer = Math.max(answer, rt - lt + 1);
        }
        return answer;
    }
}
