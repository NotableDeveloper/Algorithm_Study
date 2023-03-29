import Chap03.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Chap03Test {
    @Test
    void Problem01(){
        int n = 3, m = 5;
        int[] arr1 = {1, 3, 5}, arr2 = {2, 3, 6, 7, 9};
        int[] answer = Chap03_01.solution(n, arr1, m, arr2);

        Assertions.assertArrayEquals(new int[]{1, 2, 3, 3, 5, 6, 7, 9}, answer);
    }

    @Test
    void Problem02(){
        int n = 5, m = 5;
        int[] arr1 = {1, 3, 9, 5, 2}, arr2 = {3, 2, 5, 7, 8};
        int[] answer = Chap03_02.solution(n, arr1, m, arr2);

        Assertions.assertArrayEquals(new int[]{2, 3, 5}, answer);
    }

    @Test
    void Problem03(){
        int n = 10, k = 3;
        int[] arr = {12, 15, 11, 20, 25, 10, 20, 19, 13, 15};
        int answer = Chap03_03.solution(n, k, arr);

        Assertions.assertEquals(56, answer);
    }

    @Test
    void Problem04(){
        int n = 8, m = 6;
        int[] arr = {1, 2, 1, 3, 1, 1, 1, 2};
        int answer = Chap03_04.solution(n, m, arr);

        Assertions.assertEquals(3, answer);
    }
}
