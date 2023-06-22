package Basic;

import Basic.Chap02.Chap02_01;
import Basic.Chap02.Chap02_02;
import Basic.Chap02.Chap02_03;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Chap02Test {
    @Test
    void Problem01(){
        int[] numbers = {7, 3, 9, 5, 6, 12};
        int[] answer = Chap02_01.solution(numbers.length, numbers);
        Assertions.assertArrayEquals(new int[]{7, 9, 6, 12}, answer);
    }

    @Test
    void Problem02(){
        int n = 8;
        int[] students1 = {130, 135, 148, 140, 145, 150, 150, 153};
        int[] students2 = {120, 110, 150, 140, 170, 180, 180, 165};

        int answer = Chap02_02.solution(n, students1);
        Assertions.assertEquals(5, answer);

        answer = Chap02_02.solution(n, students2);
        Assertions.assertEquals(4, answer);
    }

    @Test
    void Problem03(){
        int n = 5;
        int[] log_A = {2, 3, 3, 1, 3};
        int[] log_B = {1, 1, 2, 2, 3};
        String[] answer = Chap02_03.solution(n, log_A, log_B);
        Assertions.assertArrayEquals(new String[]{"A", "B", "A", "B", "D"}, answer);
    }
}
