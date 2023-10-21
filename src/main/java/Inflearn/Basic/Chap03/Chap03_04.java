package Inflearn.Basic.Chap03;

/*
    어떤 수열의 연속 부분수열이란, 원래의 수열에서 연속적인 수들을 떼어내어 만들어진
    부분 수열을 말한다. 그러므로, 정렬을 해선 안 된다.
 */
public class Chap03_04 {
    public static int solution(int n, int m, int[] arr){
        int answer = 0, lt = 0, sum = 0;

        // 좌에서 우로 window를 생성해나감
        for(int rt = 0; rt < n; rt++){
            sum += arr[rt];

            if(sum == m) answer++;

            /*
                window 생성 중에 목표하던 값의 이상이 되어버린 경우
                맨 좌측의 값을 지워나가면서 목표하던 값을 찾는다.
            */
            while(sum >= m){
                sum -= arr[lt++];

                if(sum == m) answer++;
            }
        }

        return answer;
    }
}
