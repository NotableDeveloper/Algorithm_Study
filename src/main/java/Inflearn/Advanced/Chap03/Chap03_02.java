package Inflearn.Advanced.Chap03;

import java.util.Scanner;
import java.util.Stack;

public class Chap03_02 {
    public static String solution(String s){
        String answer = "";
        Stack<String> st = new Stack<>();

        /*
            입력으로 주어지는 String을 순차 탐색한다.
            반복문에서 하는 행동은 닫는 소괄호가 나오는 경우에 대한 행동과
            그 외에 문자가 나오는 경우에 대한 행동을 한다.
        */
        for(Character x : s.toCharArray()){

            // 순차 탐색 도중에 닫는 소괄호를 찾은 경우
            if(x == ')'){
                String tmp = "";

                while(!st.empty()){
                    // 여는 소괄호를 찾을 때까지 Pop 연산을 반복하게 된다.
                    String c = st.pop();

                    /*
                        여는 소괄호를 찾으면 숫자만큼 반복하며 소문자로 반복된
                        문자열을 만들어내고 스택에 넣는다.
                    */
                    if(c.equals("(")){
                        String num = "";

                        /*
                            여는 소괄호를 Stack에서 꺼낸 시점에 Stack의
                            가장 위에 있는 값은 숫자이거나 혹은 또 다른 여는 소괄호이다.
                        */
                        while(!st.empty() && Character.isDigit(st.peek().charAt(0)))
                            num += st.pop();

                        /*
                            꺼낸 하나의 숫자만큼 소문자를 반복하여 하나의 문자열을 만들어내고
                            다시 스택에 넣는다. 만약 또 다른 여는 소괄호라면 다시 스택에 넣는다.
                        */
                        String res = "";
                        int cnt = 0;

                        if(num.equals("")) cnt = 1;
                        else cnt = Integer.parseInt(num);

                        for(int i = 0; i < cnt; i++)
                            res += tmp;

                        System.out.println(res);
                        st.push(res);

                        break;
                    }

                    tmp += c;
                    System.out.println(tmp);
                }
            }

            // 닫는 소괄호 이외의 문자를 찾은 경우
            else st.push(String.valueOf(x));
        }
        for(String x : st) answer += x;
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        System.out.printf(solution(input));
    }
}
