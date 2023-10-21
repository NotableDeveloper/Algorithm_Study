package Inflearn.Basic.Chap03;

public class Chap03_05 {
    public static int solution(int n){
        int answer = 0, sum = 0, lt = 0;
        /*
            어떤 숫자를 그 수보다 작은 2개의 연속된 수로 나타낸다면, 어떤 숫자를
            반으로 나눈 몫과 연속한 숫자 하나와 더해주면 된다. 몫보다 하나 큰 값을 초과하는
            값들은 어떤 숫자로 더해도 목표로 하는 숫자를 만들 수 없다.
         */
        int middle = n / 2 + 1;
        int[] numbers = new int[middle];

        for(int i = 0; i < middle; i++){
            numbers[i] = i + 1;
        }

        for(int rt = 0; rt < middle; rt++){
            sum += numbers[rt];

            if(sum == n) answer++;

            while(sum >= n){
                sum -= numbers[lt++];
                if(sum == n) answer++;
            }
        }


        return answer;
    }
}
